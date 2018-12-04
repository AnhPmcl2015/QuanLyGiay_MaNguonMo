package uit.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uit.converter.GiayConverter;
import uit.converter.ThongTinGiayConverter;
import uit.dto.GiayDto;
import uit.dto.ThongTinGiayDto;
import uit.entity.Giay;
import uit.entity.LoaiGiay;
import uit.repository.GiayRepository;
import uit.repository.LoaiGiayRepository;

@RestController()
@RequestMapping("/api/don-hang")
public class DonHangController {

	@Autowired
	private GiayRepository giayRepository;
	
	@Autowired
	private LoaiGiayRepository loaiGiayRepository;
	
	@Autowired
	private ThongTinGiayConverter thongTinGiayConverter;

	@Autowired
	private GiayConverter giayConverter;

	@GetMapping("/thong-tin-giay/{id}")
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<ThongTinGiayDto> getThongTinGiay(@PathVariable String id) {
		Optional<Giay> optGiay = this.giayRepository.findById(Integer.parseInt(id));

		if (optGiay.isPresent()) {
			Giay giay = optGiay.get();
			giay.setChiTietGiays(giay.getChiTietGiays());
			ThongTinGiayDto thongTinGiayDto = new ThongTinGiayDto();
			this.thongTinGiayConverter.convertEntityToDto(giay, thongTinGiayDto);

			if (thongTinGiayDto != null)
				return new ResponseEntity<ThongTinGiayDto>(thongTinGiayDto, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/thong-tin-giay/hang-san-xuat/{idHangGiay}")
	@CrossOrigin(origins="http://localhost:3000")
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
