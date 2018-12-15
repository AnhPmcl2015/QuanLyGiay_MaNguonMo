package uit.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import uit.converter.GiayConverter;
import uit.converter.HangSanXuatConverter;
import uit.converter.TenGiayConverter;
import uit.converter.TenLoaiGiayConverter;
import uit.dto.GiayDto;
import uit.dto.HangSanXuatDto;
import uit.dto.TenGiayDto;
import uit.dto.TenLoaiGiayDto;
import uit.entity.HangSanXuat;
import uit.repository.GiayRepository;
import uit.repository.HangSanXuatRepository;
import uit.repository.LoaiGiayRepository;

@RestController()
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
	private GiayRepository giayRepository;

	@Autowired
	private HangSanXuatRepository hangSanXuatRepository;

	@Autowired
	private LoaiGiayRepository loaiGiayRepository;

	@GetMapping("/api/ten-giay")
	public Collection<TenGiayDto> getTenGiay() {

		List<TenGiayDto> listTenGiays = new ArrayList<>();
		giayRepository.findAll().forEach(giay -> {
			TenGiayDto tenGiayDto = new TenGiayDto();
			this.tenGiayConverter.convertEntityToDto(giay, tenGiayDto);
			listTenGiays.add(tenGiayDto);
		});
		return listTenGiays;
	}

	@GetMapping("/api/hang-san-xuat")
	public Collection<HangSanXuatDto> getHangSanXuat() {

		List<HangSanXuatDto> listHangSanXuatDto = new ArrayList<>();

		hangSanXuatRepository.findAll().forEach(hangSanXuat -> {
			HangSanXuatDto dto = new HangSanXuatDto();
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

		giayRepository.findTop8().forEach(giay -> {
			GiayDto giayDto = new GiayDto();
			this.giayConverter.convertEntityToDto(giay, giayDto);
			listGiayNoiBac.add(giayDto);
		});
		return listGiayNoiBac;
	}

	@GetMapping("/api/list-giay-ban-chay")
	public Collection<GiayDto> getListGiayBanChay() {

		List<GiayDto> listGiayBanChay = new ArrayList<>();

		giayRepository.findTopSeller().forEach(giay -> {
			GiayDto giayDto = new GiayDto();
			this.giayConverter.convertEntityToDto(giay, giayDto);
			listGiayBanChay.add(giayDto);
		});
		return listGiayBanChay;
	}
}
