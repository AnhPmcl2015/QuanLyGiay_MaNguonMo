package com.shoe.controller;

import com.shoe.converter.GiayConverter;
import com.shoe.converter.HangSanXuatConverter;
import com.shoe.converter.TenGiayConverter;
import com.shoe.converter.TenLoaiGiayConverter;
import com.shoe.dto.GiayDto;
import com.shoe.dto.HangSanXuatDTO;
import com.shoe.dto.TenGiayDto;
import com.shoe.dto.TenLoaiGiayDto;
import com.shoe.entities.HangSanXuat;
import com.shoe.jpa.JpaGiay;
import com.shoe.jpa.JpaHangSanXuat;
import com.shoe.jpa.JpaLoaiGiay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
public class TrangChuController {
	@Autowired
	private TenGiayConverter tenGiayConverter;
	
	@Autowired 
	private GiayConverter giayConverter;

	@Autowired
	private HangSanXuatConverter hangSanXuatConverter;

	@Autowired
	private TenLoaiGiayConverter tenLoaiGiayConverter;

	@Autowired
	private JpaGiay giayRepository;

	@Autowired
	private JpaHangSanXuat hangSanXuatRepository;

	@Autowired
	private JpaLoaiGiay loaiGiayRepository;
	
	@GetMapping("/api/ten-giay")
	public Collection<TenGiayDto> getTenGiay() {
		List<TenGiayDto> listTenGiays = new ArrayList<>();
		giayRepository.findAll().forEach(giay->{
			if(!giay.getXoaFlag()){
				TenGiayDto tenGiayDto = new TenGiayDto();
				this.tenGiayConverter.convertEntityToDto(giay, tenGiayDto);
				listTenGiays.add(tenGiayDto);
			}
		});
		return listTenGiays;
	}
	@GetMapping("/api/hang-san-xuat")
	public Collection<HangSanXuatDTO> getHangSanXuat() {

		List<HangSanXuatDTO> listHangSanXuatDto = new ArrayList<>();

		hangSanXuatRepository.findAll().forEach(hangSanXuat -> {
			HangSanXuatDTO dto = new HangSanXuatDTO();
			this.hangSanXuatConverter.convertEntityToDto(hangSanXuat, dto);
			listHangSanXuatDto.add(dto);
		});

		return listHangSanXuatDto;
	}

	@GetMapping("/api/hang-san-xuat/loai-giay/{id}")
	public Collection<TenLoaiGiayDto> getTenLoaiGiay(@PathVariable("id") String idHangSanXuat) {
		List<TenLoaiGiayDto> listTenLoaiGiayDto = new ArrayList<>();
		
		Optional<HangSanXuat> optHangSanXuat = this.hangSanXuatRepository.findById(Integer.parseInt(idHangSanXuat));
		
		if(optHangSanXuat.isPresent()) {
			HangSanXuat hangSanXuat = optHangSanXuat.get();
			this.loaiGiayRepository.findByHangSanXuat(hangSanXuat).forEach(loaiGiay->{
				TenLoaiGiayDto dto = new TenLoaiGiayDto();
				this.tenLoaiGiayConverter.convertEntityToDto(loaiGiay, dto);
				listTenLoaiGiayDto.add(dto);
			});
		}
		
		return listTenLoaiGiayDto;
	}
	@GetMapping("/api/list-giay-noi-bac")
	public Collection<GiayDto> getListGiayNoiBat() {

		List<GiayDto> listGiayNoiBac = new ArrayList<>();
		giayRepository.findTop8().forEach(giay->{
			if(!giay.getXoaFlag()){
				TenGiayDto tenGiayDto = new TenGiayDto();
				this.tenGiayConverter.convertEntityToDto(giay, tenGiayDto);
				listGiayNoiBac.add(tenGiayDto);
			}
		});
		return listGiayNoiBac;
	}
	
	@GetMapping("/api/list-giay-ban-chay")
	public Collection<GiayDto> getListGiayBanChay() {
		
		List<GiayDto> listGiayBanChay = new ArrayList<>();
		giayRepository.findTopSeller().forEach(giay->{
			if(!giay.getXoaFlag()) {
				GiayDto giayDto = new GiayDto();
				this.giayConverter.convertEntityToDto(giay, giayDto);
				listGiayBanChay.add(giayDto);
			}
		});
		return listGiayBanChay;
	}
	@GetMapping("/api/loai-giay")
	public Collection<TenLoaiGiayDto> getListLoaiGiay() {

		List<TenLoaiGiayDto> listTenLoaiGiay = new ArrayList<>();

		this.loaiGiayRepository.findAll().forEach(loaiGiay -> {
			TenLoaiGiayDto dto = new TenLoaiGiayDto();
			this.tenLoaiGiayConverter.convertEntityToDto(loaiGiay, dto);
			listTenLoaiGiay.add(dto);
		});
		return listTenLoaiGiay;
	}
}
