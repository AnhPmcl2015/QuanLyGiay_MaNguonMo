package com.shoe.dao;

import java.util.List;

import com.shoe.dto.ShoeDTO;
import com.shoe.dto.ShoeImage;
import com.shoe.form.GiayForm;

public interface GiayDAO {

    public void saveShoe(ShoeDTO giay);

    public List<ShoeDTO> getAllListNoneDel();

    public boolean deleteShoe(ShoeDTO giay);

    public ShoeDTO getGiayById(Integer id);

    public boolean checkUniqueOnEdit(GiayForm giay);

    public ShoeImage getImageById(Integer id);
}
