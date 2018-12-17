package com.shoe.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.shoe.Bus.ImageBus;
import com.shoe.dto.ShoeImage;
import org.apache.commons.validator.GenericValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import com.shoe.ObjectToJson.ConvertToJson;
import com.shoe.converter.ShoeConverter;
import com.shoe.dao.GiayDAO;
import com.shoe.dao.LoaiGiayDAO;
import com.shoe.dto.ShoeDTO;
import com.shoe.dto.GiayTableDTO;
import com.shoe.form.GiayForm;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/admin/api/shoe")
public class GiayController {

    @Autowired
    GiayDAO giayDAO;

    @Autowired
    private ShoeConverter converter;

    @Autowired
    LoaiGiayDAO loaigiayDAO;

    // thêm, sửa giày
    @PostMapping(value = "/save", consumes = "application/json")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> saveGiay(@Valid @RequestBody GiayForm model, Errors error) {
        ResponseEntity<String> resp = null;
        if (error.hasFieldErrors("maGiay")) {
            resp = new ResponseEntity<>("{\"status\":\"unique\"}", HttpStatus.BAD_REQUEST);
        } else if (error.hasErrors()) {
            resp = new ResponseEntity<>("{\"status\":\"invalid\"}", HttpStatus.BAD_REQUEST);
        } else {
            ShoeDTO dto = new ShoeDTO();
            converter.convertFormToDTO(model, dto);
            giayDAO.saveShoe(dto);
            resp = new ResponseEntity<>(ConvertToJson.ToJson(model), HttpStatus.OK);
        }
        return resp;
    }

    @PostMapping(value = "/edit", consumes = "application/json")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> editGiay(@Valid @RequestBody GiayForm model, Errors error) {
        ResponseEntity<String> resp = null;
        if (!giayDAO.checkUniqueOnEdit(model)) {
            resp = new ResponseEntity<>("{\"status\":\"unique\"}", HttpStatus.BAD_REQUEST);
        } else if (error.hasFieldErrors("tenGiay")
                || error.hasFieldErrors("giaBan")
                || error.hasFieldErrors("id_gioi_tinh")
                || error.hasFieldErrors("id_loai_giay")) {
            resp = new ResponseEntity<>("{\"status\":\"invalid\"}", HttpStatus.BAD_REQUEST);
        } else {
            ShoeDTO dto = new ShoeDTO();
            converter.convertFormToDTO(model, dto);
            giayDAO.saveShoe(dto);
            resp = new ResponseEntity<>(ConvertToJson.ToJson(model), HttpStatus.OK);
        }
        return resp;
    }


    @PostMapping(value = "/get-giay-by-id")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> getGiayById(@RequestBody String id) {
        ResponseEntity<String> resp = null;
        if (id == null || "".equals(id.trim())) {
            resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            ShoeDTO dto = giayDAO.getGiayById(Integer.parseInt(id));
            GiayForm form = new GiayForm();
            converter.convertDTOtoForm(dto, form);
            resp = new ResponseEntity<>(ConvertToJson.ToJson(form), HttpStatus.OK);
        }
        return resp;
    }

    @PostMapping("/list-shoe")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> getListGiay() {
        List<ShoeDTO> list = giayDAO.getAllListNoneDel();
        List<GiayTableDTO> giayTableDTOs = new ArrayList<>();
        list.forEach(i -> {
            GiayTableDTO dto = new GiayTableDTO();
            dto.setIdGiay(i.getIdGiay());
            dto.setMaGiay(i.getMaGiay());
            dto.setTenGiay(i.getTenGiay());
            dto.setTenGioiTinh(i.getGioiTinh().getTenGioiTinh());
            dto.setTenHangSanXuat(i.getLoaiGiay().getHangSanXuat().getTenHangSanXuat());
            dto.setTenLoaiGiay(i.getLoaiGiay().getTenLoaiGiay());
            giayTableDTOs.add(dto);
        });
        ResponseEntity<String> res = new ResponseEntity<>(ConvertToJson.ToJson(giayTableDTOs), HttpStatus.OK);
        return res;
    }

    @PostMapping("/delete-giay")
    public ResponseEntity<String> deleteGiay(@RequestBody String id) {
        ResponseEntity<String> response = null;
        ShoeDTO dto = new ShoeDTO();
        System.out.println(id);
        if (GenericValidator.isInt(id)) {
            dto.setIdGiay(Integer.parseInt(id));
            if (giayDAO.deleteShoe(dto)) {
                response = new ResponseEntity<>("{\"status\":\"success\"}", HttpStatus.OK);
            } else {
                response = new ResponseEntity<>("{\"status\":\"faild\"}", HttpStatus.BAD_REQUEST);
            }
        }
        return response;
    }

    @PostMapping("/get-img-by-id")
    public ResponseEntity<String> getImgById(@RequestBody String id) {
        ResponseEntity<String> response = null;
        if (GenericValidator.isInt(id)) {
            ShoeImage img = giayDAO.getImageById(Integer.parseInt(id));
            response = new ResponseEntity<>(ConvertToJson.ToJson(img), HttpStatus.OK);
        }
        return response;
    }


    @Autowired
    private ImageBus imgBus;

//    @PostMapping(value = "/upload-img", consumes = {"multipart/form-data"})
//    public ResponseEntity<String> uploadImg(@RequestParam("file") MultipartFile[] files,
//                                            @RequestParam("idGiay") String idGiay) throws IOException {
//        ResponseEntity<String> resp = null;
//
//        if (files.length <= 4) {
//            //imgBus.saveImage(files, idGiay);
//            resp = new ResponseEntity<>(ConvertToJson.ToJson(idGiay), HttpStatus.OK);
//        } else {
//            resp = new ResponseEntity<>(ConvertToJson.ToJson(idGiay), HttpStatus.BAD_REQUEST);
//        }
//
//        return resp;
//    }

    @PostMapping(value = "/save-img")
    public ResponseEntity<String> saveImg(@RequestParam("file") String[] files,
                                          @RequestParam("idGiay") String idGiay,
                                          @RequestParam("filepart") MultipartFile[] filePart) throws IOException {
        ResponseEntity<String> resp = null;
        if (filePart.length <= 4) {
            imgBus.saveImage(files,filePart, idGiay);
            resp = new ResponseEntity<>("{\"status\":\"success\"}", HttpStatus.OK);
        } else {
            resp = new ResponseEntity<>("{\"status\":\"faild\"}",HttpStatus.BAD_REQUEST);
        }
        return resp;
    }

}