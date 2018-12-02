package com.shoe.controller;

import com.shoe.ObjectToJson.ConvertToJson;
import com.shoe.dao.HangSanXuatDAO;
import com.shoe.dao.GiayDAO;
import com.shoe.dao.GioiTinhDAO;
import com.shoe.dao.LoaiGiayDAO;
import com.shoe.dao.ChiTietGiayDAO;
import com.shoe.dto.*;
import com.shoe.form.SelectBox;
import org.apache.commons.validator.GenericValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import com.shoe.converter.GiayConverter;
import com.shoe.form.GiayForm;

@RestController
@RequestMapping("/admin/api/shoe")
public class GiayController {

    @Autowired
    GiayDAO giayDAO;

    @Autowired
    private GiayConverter converter;

    @Autowired
    private HangSanXuatDAO hangSanXuatDAO;

    @Autowired
    LoaiGiayDAO loaigiayDAO;

    private List<HangSanXuatSelectDTO> getListLoaiGiay() {
        List<HangSanXuatDTO> listHSX = hangSanXuatDAO.getHangSanXuat();
        List<LoaiGiayDTO> listLG = loaigiayDAO.getList();
        List<HangSanXuatSelectDTO> list = new ArrayList<>();
        for (HangSanXuatDTO hsx : listHSX) {
            HangSanXuatSelectDTO dto = new HangSanXuatSelectDTO();
            dto.setTenHangSanXuat(hsx.getTenHangSanXuat());
            List<LoaiGiaySelectDTO> selectLoaiGiay = new ArrayList<>();
            for (LoaiGiayDTO lg : listLG) {
                LoaiGiaySelectDTO loaiGiaySelectDTO = new LoaiGiaySelectDTO();
                if (lg.getHangSanXuat().getIdHangSanXuat() == hsx.getIdHangSanXuat()) {
                    loaiGiaySelectDTO.setIdLoaiGiay(lg.getIdLoaiGiay());
                    loaiGiaySelectDTO.setTenLoaiGiay(lg.getTenLoaiGiay());
                    selectLoaiGiay.add(loaiGiaySelectDTO);
                }
            }
            if (selectLoaiGiay.size() > 0) {
                dto.setLoaiGiays(selectLoaiGiay);
            }
            list.add(dto);
        }
        return list;
    }

    // thêm, sửa giày
    @PostMapping(value = "/save", consumes = "application/json")
    public ResponseEntity<String> saveGiay(@Valid @RequestBody GiayForm model, Errors error) {
        ResponseEntity resp = null;
        if (error.hasFieldErrors("maGiay")) {
            resp = new ResponseEntity<>("{\"status\":\"unique\"}", HttpStatus.BAD_REQUEST);
        } else if (error.hasErrors()) {
            resp = new ResponseEntity<>("{\"status\":\"invalid\"}", HttpStatus.BAD_REQUEST);
        } else {
            GiayDTO dto = new GiayDTO();
            converter.convertFormToDTO(model, dto);
            giayDAO.saveShoe(dto);
            resp = new ResponseEntity<>(ConvertToJson.ToJson(model), HttpStatus.OK);
        }
        return resp;
    }

    @GetMapping("/sua-giay/{id}")
    public ModelAndView getGiay(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("suagiay");
        modelAndView.addObject("title", "Cập nhật");
        GiayDTO giay = new GiayDTO();
        byte[] b = Base64.getDecoder().decode(id);
        id = new String(b);
        System.out.println(id);
        try {
            giay = giayDAO.getGiayById(Integer.parseInt(id));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        //modelAndView.addObject("gioitinh",gioiTinhDAO.getList());
        modelAndView.addObject("hangsanxuat", getListLoaiGiay());
        modelAndView.addObject("giay", giay);
        return modelAndView;
    }

    @PostMapping(value = "/get-giay-by-id")
    public ResponseEntity<String> saveGiay(@RequestBody String id) {
        ResponseEntity resp = null;
        if (id == null || "".equals(id.trim())) {
            resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            GiayDTO dto = giayDAO.getGiayById(Integer.parseInt(id));
            GiayForm form = new GiayForm();
            converter.convertDTOtoForm(dto, form);
            resp = new ResponseEntity<>(ConvertToJson.ToJson(form), HttpStatus.OK);
        }
        return resp;
    }

    @PostMapping("/list-shoe")
    public ResponseEntity<String> getListGiay() {
        List<GiayDTO> list = giayDAO.getAllListNoneDel();
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
        GiayDTO dto = new GiayDTO();
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


}