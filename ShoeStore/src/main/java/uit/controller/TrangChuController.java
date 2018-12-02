package uit.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import uit.converter.TenGiayConverter;
import uit.dto.TenGiayDto;
import uit.repository.GiayRepository;

@RestController()
public class TrangChuController {
	@Autowired
	private TenGiayConverter tenGiayConverter;
	
	@Autowired
	private GiayRepository giayRepository;
	
	@GetMapping("/api/ten-giay")
	public Collection<TenGiayDto> getTenGiay() {

		List<TenGiayDto> listTenGiays = new ArrayList<>();
		giayRepository.findAll().forEach(giay->{
			TenGiayDto tenGiayDto = new TenGiayDto();
			this.tenGiayConverter.convertEntityToDto(giay, tenGiayDto);
			listTenGiays.add(tenGiayDto);
		});
		return listTenGiays;
	}
}
