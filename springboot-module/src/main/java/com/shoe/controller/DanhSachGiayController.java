package com.shoe.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.shoe.converter.GiayConverter;
import com.shoe.dto.GiayDto;
import com.shoe.entities.Giay;
import com.shoe.entities.GioiTinh;
import com.shoe.entities.HangSanXuat;
import com.shoe.entities.LoaiGiay;
import com.shoe.jpa.JpaGiay;
import com.shoe.jpa.JpaGioiTinh;
import com.shoe.jpa.JpaHangSanXuat;
import com.shoe.jpa.JpaLoaiGiay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/danh-sach")
public class DanhSachGiayController {
    @Autowired
    private JpaHangSanXuat hangSanXuatRepository;

    @Autowired
    private JpaLoaiGiay loaiGiayRepository;

    @Autowired
    private JpaGiay giayRepository;

    @Autowired
    private JpaGioiTinh gioiTinhRepository;

    @Autowired
    private GiayConverter giayConverter;

    @GetMapping("/loai-giay/{id}")
    public Collection<GiayDto> getTenGiayDuaVaoLoaiGiay(@PathVariable("id") String idLoaiGiay) {
        List<GiayDto> listGiay = new ArrayList<>();

        if (Integer.parseInt(idLoaiGiay) == -1) {
            List<Giay> giays = this.giayRepository.findAll();
            for (Giay giay : giays) {
                GiayDto dto = new GiayDto();
                this.giayConverter.convertEntityToDto(giay, dto);
                listGiay.add(dto);
            }
        } else {
            Optional<LoaiGiay> optLoaiGiay = this.loaiGiayRepository.findById(Integer.parseInt(idLoaiGiay));

            if (optLoaiGiay.isPresent()) {
                LoaiGiay loaiGiay = optLoaiGiay.get();

                List<Giay> giays = this.giayRepository.findByLoaiGiay(loaiGiay);

                for (Giay giay : giays) {
                    GiayDto dto = new GiayDto();
                    this.giayConverter.convertEntityToDto(giay, dto);
                    listGiay.add(dto);
                }
            }
        }

        return listGiay;
    }

    @GetMapping("/hang-san-xuat/{id}")
    public Collection<GiayDto> getTenGiayDuaVaoHangSanXuat(@PathVariable("id") String idHangSanXuat) {
        List<GiayDto> listGiay = new ArrayList<>();

        if (Integer.parseInt(idHangSanXuat) == -1) {
            List<Giay> giays = this.giayRepository.findAll();
            for (Giay giay : giays) {
                GiayDto dto = new GiayDto();
                this.giayConverter.convertEntityToDto(giay, dto);
                listGiay.add(dto);
            }
        } else {
            Optional<HangSanXuat> optHangSanXuat = this.hangSanXuatRepository.findById(Integer.parseInt(idHangSanXuat));

            if (optHangSanXuat.isPresent()) {
                HangSanXuat hangSanXuat = optHangSanXuat.get();

                List<LoaiGiay> loaiGiays = this.loaiGiayRepository.findByHangSanXuat(hangSanXuat);

                for (LoaiGiay loaiGiay : loaiGiays) {
                    List<Giay> giays = this.giayRepository.findByLoaiGiay(loaiGiay);

                    for (Giay giay : giays) {
                        GiayDto dto = new GiayDto();
                        this.giayConverter.convertEntityToDto(giay, dto);
                        listGiay.add(dto);
                    }
                }
            }
        }

        return listGiay;
    }

    @GetMapping("/giay/{idGioiTinh}")
    public Collection<GiayDto> getGiayDuaVaoGioiTinh(@PathVariable("idGioiTinh") String idGioiTinh) {
        List<GiayDto> listGiay = new ArrayList<>();

        Integer maGioiTinh = Integer.parseInt(idGioiTinh);
        List<Giay> giays = new ArrayList<>();

        switch (maGioiTinh) {
            case 0:
                giays = this.giayRepository.findAll();
                break;

            default:

                Optional<GioiTinh> optGioiTinh = this.gioiTinhRepository.findById(maGioiTinh);

                if (optGioiTinh.isPresent()) {
                    GioiTinh gioiTinh = optGioiTinh.get();

                    giays = this.giayRepository.findByGioiTinh(gioiTinh);
                }
                break;
        }

        for (Giay giay : giays) {
            GiayDto dto = new GiayDto();
            this.giayConverter.convertEntityToDto(giay, dto);
            listGiay.add(dto);
        }

        return listGiay;
    }

    @GetMapping("/giay/{min}/{max}")
    public Collection<GiayDto> getGiayByGiaBan(@PathVariable("min") String min, @PathVariable("max") String max) {
        List<GiayDto> listGiay = new ArrayList<>();

        List<Giay> giays = this.giayRepository.findByGiaBanBetween(Integer.parseInt(min), Integer.parseInt(max));

        for (Giay giay : giays) {
            GiayDto dto = new GiayDto();
            this.giayConverter.convertEntityToDto(giay, dto);
            listGiay.add(dto);
        }

        return listGiay;
    }
}