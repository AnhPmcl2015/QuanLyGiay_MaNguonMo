package com.shoe.controller;

import com.shoe.dao.ChiTietGiayDAO;
import com.shoe.dto.ChiTietGiayDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/api/detail-shoe")
public class ChiTietGiayController {
    @Autowired
    private ChiTietGiayDAO chiTietGiayDAO;

    @GetMapping("/searchgiay")
    public ModelAndView gotoTraCuuGiay(Map<String, Object> model) {

        List<ChiTietGiayDTO> chiTietGiayDTOS = chiTietGiayDAO.getAllListNoneDel();
        model.put("list_chitietgiay", chiTietGiayDTOS);
        chiTietGiayDTOS.forEach(i->{
            System.out.println(i.getIdChiTietGiay() + " "+i.getGiay());
        });
        return new ModelAndView("tracuugiay");
    }
}
