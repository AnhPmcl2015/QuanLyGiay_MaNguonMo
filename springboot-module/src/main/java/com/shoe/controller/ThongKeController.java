package com.shoe.controller;

import com.shoe.dao.ThongKeDAO;
import com.shoe.dto.DoanhThuDTO;
import com.shoe.dto.DoanhThuHangSanXuatDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/admin/api/thong-ke")
public class ThongKeController {

    @Autowired
    private ThongKeDAO thongKeDAO;

    @PostMapping(value = "/get-so-don-hang")
    @PreAuthorize("hasRole('ADMIN')")
    public String getSoDonHang() {

        return thongKeDAO.getSoDonhangHomNay() + "";
    }

    @PostMapping(value = "/get-doanh-thu")
    @PreAuthorize("hasRole('ADMIN')")
    public Long getDoanhThu() {
        return thongKeDAO.getDoanhThuTuanNay();
    }

    @PostMapping(value = "/get-tong-doanh-thu")
    @PreAuthorize("hasRole('ADMIN')")
    public List<DoanhThuDTO> getTongDoanhThu(@RequestBody int year) {

        return thongKeDAO.getDoanhThu(year);
    }

    @PostMapping(value = "/get-thang-trong-don-hang")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Integer> getThangTrongDonhang() {

        return thongKeDAO.getThangTrongDonhang();
    }

    @PostMapping(value = "/get-doanh-thu-hsx")
    @PreAuthorize("hasRole('ADMIN')")
    public List<DoanhThuHangSanXuatDTO> getDoanhThuHSX(@RequestBody String day) throws ParseException {
        String myDate = "10/" + day;
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(myDate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return thongKeDAO.getDoanhThuHSX(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1);
    }

    @PostMapping(value = "/get-so-luong-giay-ban")
    @PreAuthorize("hasRole('ADMIN')")
    public Long getSoLuongGiayBan() {
        System.out.println(" concac");
        return thongKeDAO.getSoLuongGiayBan();
    }
}
