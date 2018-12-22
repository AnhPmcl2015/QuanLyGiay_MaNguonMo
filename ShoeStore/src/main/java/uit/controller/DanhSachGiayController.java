package uit.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uit.converter.GiayConverter;
import uit.dto.GiayDto;
import uit.entity.Giay;
import uit.entity.GioiTinh;
import uit.entity.HangSanXuat;
import uit.entity.LoaiGiay;
import uit.repository.GiayRepository;
import uit.repository.GioiTinhRepository;
import uit.repository.HangSanXuatRepository;
import uit.repository.LoaiGiayRepository;

@RestController
@RequestMapping("/danh-sach")
public class DanhSachGiayController {
	@Autowired
	private HangSanXuatRepository hangSanXuatRepository;

	@Autowired
	private LoaiGiayRepository loaiGiayRepository;

	@Autowired
	private GiayRepository giayRepository;

	@Autowired
	private GioiTinhRepository gioiTinhRepository;

	@Autowired
	private GiayConverter giayConverter;

	@GetMapping("/loai-giay/{id}")
	public Collection<GiayDto> getTenGiayDuaVaoLoaiGiay(@PathVariable("id") String idLoaiGiay) {
		List<GiayDto> listGiay = new ArrayList<>();

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

		return listGiay;
	}

	@GetMapping("/hang-san-xuat/{id}")
	public Collection<GiayDto> getTenGiayDuaVaoHangSanXuat(@PathVariable("id") String idHangSanXuat) {
		List<GiayDto> listGiay = new ArrayList<>();

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
