package uit.controller;

import com.shoe.converter.TenGiayConverter;
import com.shoe.converter.TheAnhConverter.GiayConverter;
import com.shoe.dto.TheAnhDto.GiayDto;
import com.shoe.dto.TenGiayDto;
import com.shoe.jpa.JpaGiay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/admin/home")
public class TrangChuController {
	@Autowired
	private TenGiayConverter tenGiayConverter;
	
	@Autowired 
	private GiayConverter giayConverter;
	
	@Autowired
	private JpaGiay giayRepository;
	
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
	
	
	@GetMapping("/api/list-giay-noi-bac")
	public Collection<GiayDto> getListGiayNoiBat() {
		
		List<GiayDto> listGiayNoiBac = new ArrayList<>();
		
		giayRepository.findTop8().forEach(giay->{
			GiayDto giayDto = new GiayDto();
			this.giayConverter.convertEntityToDto(giay, giayDto);
			listGiayNoiBac.add(giayDto);
		});
		return listGiayNoiBac;
	}
	
	@GetMapping("/api/list-giay-ban-chay")
	public Collection<GiayDto> getListGiayBanChay() {
		
		List<GiayDto> listGiayBanChay = new ArrayList<>();
		
		giayRepository.findTopSeller().forEach(giay->{
			GiayDto giayDto = new GiayDto();
			this.giayConverter.convertEntityToDto(giay, giayDto);
			listGiayBanChay.add(giayDto);
		});
		return listGiayBanChay;
	}
}
