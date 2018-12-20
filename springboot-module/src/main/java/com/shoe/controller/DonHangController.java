package com.shoe.controller;

import com.shoe.converter.GiayConverter;
import com.shoe.converter.ThongTinGiayConverter;
import com.shoe.dto.GiayDto;
import com.shoe.dto.ThongTinGiayDto;
import com.shoe.entities.Giay;
import com.shoe.jpa.JpaGiay;
import com.shoe.jpa.JpaLoaiGiay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chi-tiet-giay")
public class DonHangController {

	@Autowired
	private JpaGiay giayRepository;

	@Autowired
	private JpaLoaiGiay loaiGiayRepository;

	@Autowired
	private ThongTinGiayConverter thongTinGiayConverter;

	@Autowired
	private GiayConverter giayConverter;

	@GetMapping("/thong-tin-giay/{id}")
	public ResponseEntity<ThongTinGiayDto> getThongTinGiay(@PathVariable String id) {
		Optional<Giay> optGiay = this.giayRepository.findById(Integer.parseInt(id));
		System.out.println("running");
		if (optGiay.isPresent()) {
			Giay giay = optGiay.get();
			giay.setChiTietGiays(giay.getChiTietGiays());
			ThongTinGiayDto thongTinGiayDto = new ThongTinGiayDto();
			this.thongTinGiayConverter.convertEntityToDto(giay, thongTinGiayDto);

			if (thongTinGiayDto != null)
				return new ResponseEntity<>(thongTinGiayDto, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/thong-tin-giay/hang-san-xuat/{idHangGiay}")
	public Collection<GiayDto> getListGiayNoiBat(@PathVariable String idHangGiay) {

		List<GiayDto> listGiayDto = new ArrayList<>();

		for(Giay giay : giayRepository.findGiayBaseOnIdHangSanXuat(idHangGiay)) {
			GiayDto giayDto = new GiayDto();
			this.giayConverter.convertEntityToDto(giay, giayDto);
			listGiayDto.add(giayDto);
		}
		return listGiayDto;
	}
}
