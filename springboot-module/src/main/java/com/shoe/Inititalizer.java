package com.shoe;

import com.shoe.entities.ChiTietGiay;
import com.shoe.entities.Giay;
import com.shoe.entities.GioiTinh;
import com.shoe.entities.LoaiGiay;
import com.shoe.jpa.JpaChiTietGiay;
import com.shoe.jpa.JpaGiay;
import com.shoe.jpa.JpaGioiTinh;
import com.shoe.jpa.JpaLoaiGiay;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class Inititalizer implements CommandLineRunner {

	private static final String PATH = "E:\\Git\\QuanLyGiay_MaNguonMo\\springboot-module\\ListGiay.xlsx";

	@Autowired
	private JpaGiay giayRepository;

	@Autowired
	private JpaChiTietGiay chiTietGiayRepository;

	@Autowired
	private JpaLoaiGiay loaiGiayRepository;

	@Autowired
	private JpaGioiTinh gioiTinhRepository;

	private static int count = -1;
	private static boolean FLAG = false;

	@Override
	public void run(String... args) throws Exception {

		if (FLAG) {
			Workbook workBook = WorkbookFactory.create(new File(PATH));

			Sheet sheet = workBook.getSheetAt(0);
			System.out.println(sheet);
			sheet.forEach(row -> {
				List<String> arr = new ArrayList<>();

				row.forEach(cell -> {
					arr.add(cell.toString());
				});

				count++;
				if (count != 0 && !"".equals(arr.get(0))) {
					String maGiay = arr.get(1);
					String tenGiay = arr.get(2);
					String idLoaiGiay = arr.get(3);
					String idGioiTinh = arr.get(4);
					String ghiChu = arr.get(5);
					String soLuongBan = arr.get(6);
					String giaBan = arr.get(7);

					String img = arr.get(8);
					String img1 = img.substring(0, img.lastIndexOf(".")) + "1" + img.substring(img.lastIndexOf("."));
					String img2 = img.substring(0, img.lastIndexOf(".")) + "2" + img.substring(img.lastIndexOf("."));
					String img3 = img.substring(0, img.lastIndexOf(".")) + "3" + img.substring(img.lastIndexOf("."));
					String img4 = img.substring(0, img.lastIndexOf(".")) + "4" + img.substring(img.lastIndexOf("."));

					String size38 = arr.get(9);
					String size39 = arr.get(10);
					String size40 = arr.get(11);
					String size41 = arr.get(12);
					String size42 = arr.get(13);
					String size43 = arr.get(14);

					Giay giay = new Giay();
					giay.setMaGiay(maGiay);
					giay.setTenGiay(tenGiay);
					giay.setGiaBan((int) Double.parseDouble(giaBan));
					giay.setGhiChu(ghiChu);
					giay.setSoLuongBan((int) Double.parseDouble(soLuongBan));
					giay.setImg1(img1);
					giay.setImg2(img2);
					giay.setImg3(img3);
					giay.setImg4(img4);
					giay.setXoaFlag(false);
					System.out.println(idLoaiGiay);
					LoaiGiay loaiGiay = loaiGiayRepository.findById((int)Double.parseDouble(idLoaiGiay)).get();
					giay.setLoaiGiay(loaiGiay);

					GioiTinh gioiTinh = gioiTinhRepository.findById((int)Double.parseDouble(idGioiTinh)).get();
					giay.setGioiTinh(gioiTinh);

					giayRepository.save(giay);

					ChiTietGiay chiTietGiay38 = new ChiTietGiay();
					chiTietGiay38.setSize(38);
					chiTietGiay38.setSoLuong((int) Double.parseDouble(size38));
					chiTietGiay38.setGiay(giay);
					chiTietGiay38.setXoaFlag(false);
					chiTietGiayRepository.save(chiTietGiay38);

					ChiTietGiay chiTietGiay39 = new ChiTietGiay();
					chiTietGiay39.setSize(39);
					chiTietGiay39.setSoLuong((int) Double.parseDouble(size39));
					chiTietGiay39.setGiay(giay);
					chiTietGiay39.setXoaFlag(false);
					chiTietGiayRepository.save(chiTietGiay39);

					ChiTietGiay chiTietGiay40 = new ChiTietGiay();
					chiTietGiay40.setSize(40);
					chiTietGiay40.setSoLuong((int) Double.parseDouble(size40));
					chiTietGiay40.setGiay(giay);
					chiTietGiay40.setXoaFlag(false);
					chiTietGiayRepository.save(chiTietGiay40);

					ChiTietGiay chiTietGiay41 = new ChiTietGiay();
					chiTietGiay41.setSize(41);
					chiTietGiay41.setSoLuong((int) Double.parseDouble(size41));
					chiTietGiay41.setGiay(giay);
					chiTietGiay41.setXoaFlag(false);
					chiTietGiayRepository.save(chiTietGiay41);

					ChiTietGiay chiTietGiay42 = new ChiTietGiay();
					chiTietGiay42.setSize(42);
					chiTietGiay42.setSoLuong((int) Double.parseDouble(size42));
					chiTietGiay42.setGiay(giay);
					chiTietGiay42.setXoaFlag(false);
					chiTietGiayRepository.save(chiTietGiay42);

					ChiTietGiay chiTietGiay43 = new ChiTietGiay();
					chiTietGiay43.setSize(43);
					chiTietGiay43.setSoLuong((int) Double.parseDouble(size43));
					chiTietGiay43.setGiay(giay);
					chiTietGiay43.setXoaFlag(false);
					chiTietGiayRepository.save(chiTietGiay43);
				}

			});
			System.out.println("Da import giay xong");
			workBook.close();
		}

	}

}
