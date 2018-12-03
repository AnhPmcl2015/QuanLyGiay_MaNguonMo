package com.shoe.dao;

import com.shoe.dto.HangSanXuatDTO;
import com.shoe.dto.HangSanXuatSelectDTO;
import java.util.List;

public interface HangSanXuatDAO {

    public List<HangSanXuatDTO> getHangSanXuat();

    public List<HangSanXuatSelectDTO> getAllList();

}
