package com.shoe.dao;

import com.shoe.dto.DoanhThuDTO;
import com.shoe.dto.DoanhThuHangSanXuatDTO;

import java.util.List;

public interface ThongKeDAO {
    Long getSoDonhangHomNay();
    Long getDoanhThuTuanNay();
    List<DoanhThuDTO> getDoanhThu(int year);
    List<Integer> getThangTrongDonhang();
    List<DoanhThuHangSanXuatDTO> getDoanhThuHSX(int year, int month);
    Long getSoLuongGiayBan();
}
