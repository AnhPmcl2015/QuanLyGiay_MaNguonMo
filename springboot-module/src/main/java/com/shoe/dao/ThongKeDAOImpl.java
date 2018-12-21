package com.shoe.dao;

import com.shoe.dto.DoanhThuDTO;
import com.shoe.dto.DoanhThuHangSanXuatDTO;
import com.shoe.jpa.JpaDonHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class ThongKeDAOImpl implements ThongKeDAO {

    @Autowired
    private JpaDonHang jpaDonHang;
    @Autowired
    private EntityManager em;

    @Override
    public Long getSoDonhangHomNay() {

        StringBuilder query = new StringBuilder();
        query.append("select count(d.idDonHang) ")
                .append("from DonHang d ")
                .append("where DATE(d.ngayGiao) = DATE(NOW()) and d.tinhTrangDonHang.idTinhTrang =3");
        TypedQuery<Long> q = em
                .createQuery(query.toString(), Long.class);
        return q.getSingleResult();
    }

    @Override
    public Long getDoanhThuTuanNay() {

        StringBuilder query = new StringBuilder();
        query.append("select sum(d.tongTien) ")
                .append("from DonHang d ")
                .append("where WEEK(d.ngayGiao) = WEEK(NOW()) and d.tinhTrangDonHang.idTinhTrang =3");
        TypedQuery<Long> q = em
                .createQuery(query.toString(), Long.class);
        return q.getSingleResult();
    }

    @Override
    public List<DoanhThuDTO> getDoanhThu(int year) {

        StringBuilder query = new StringBuilder();
        query.append("select sum(d.tongTien), MONTH(ngay_giao) as thang ")
                .append("from DonHang d ")
                .append("where YEAR(d.ngayGiao) = :year and d.tinhTrangDonHang.idTinhTrang = 3 ")
                .append("group by MONTH(ngay_giao) order by thang");
        TypedQuery<Object[]> q = em
                .createQuery(query.toString(), Object[].class);
        q.setParameter("year", year);

        List<DoanhThuDTO> list = new ArrayList<>();
        q.getResultList().forEach(i -> {
            DoanhThuDTO dto = new DoanhThuDTO();
            dto.setDoanhThu((long) i[0]);
            dto.setThang("Tháng " + (int) i[1]);
            list.add(dto);
        });
        return list;
    }

    @Override
    public List<Integer> getThangTrongDonhang() {
        TypedQuery<Integer> q = em
                .createQuery("select distinct YEAR(d.ngayGiao) from DonHang d", Integer.class);
        return q.getResultList();
    }

    @Override
    public List<DoanhThuHangSanXuatDTO> getDoanhThuHSX(int year, int month) {
        StringBuilder query = new StringBuilder();
        query.append("select sum(ctdh.thanhTien), hsx.tenHangSanXuat ")
                .append("from DonHang dh, ChiTietDonHang ctdh, ")
                .append("ChiTietGiay ctg, Giay g, ")
                .append("LoaiGiay lg, HangSanXuat hsx ")
                .append("where dh.idDonHang = ctdh.donHang.idDonHang ")
                .append("and ctg.idChiTietGiay = ctdh.chiTietGiay.idChiTietGiay ")
                .append("and g.idGiay = ctg.giay.idGiay and g.loaiGiay.idLoaiGiay = lg.idLoaiGiay ")
                .append("and hsx.idHangSanXuat = lg.hangSanXuat.idHangSanXuat ")
                .append("and year(dh.ngayGiao) = :year and Month(dh.ngayGiao) = :month ")
                .append("group by hsx.idHangSanXuat, hsx.tenHangSanXuat");
        TypedQuery<Object[]> q = em
                .createQuery(query.toString(), Object[].class);
        q.setParameter("year", year).setParameter("month", month);
        List<DoanhThuHangSanXuatDTO> list = new ArrayList<>();
        q.getResultList().forEach(i->{
            DoanhThuHangSanXuatDTO dto = new DoanhThuHangSanXuatDTO();
            dto.setDoanhThu((long)i[0]);
            dto.setTenHangSanXuat(i[1]+"");
            list.add(dto);
        });
        return list;
    }

    @Override
    public Long getSoLuongGiayBan() {
        StringBuilder query = new StringBuilder();
        query.append("select sum(ctdh.soLuong) from DonHang dh, ChiTietDonHang ctdh ")
                .append("where dh.idDonHang = ctdh.donHang.idDonHang ")
                .append("and WEEK(dh.ngayGiao)= WEEK(NOW()) and dh.tinhTrangDonHang.idTinhTrang =3 ");
        TypedQuery<Long> q = em
                .createQuery(query.toString(), Long.class);
        return q.getSingleResult();
    }


}
