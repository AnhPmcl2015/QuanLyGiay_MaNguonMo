package com.shoe.dao;

import com.shoe.dto.KhachHangDTO;
import com.shoe.dto.UserDTO;
import com.shoe.form.KhachHangPwdForm;

public interface KhachHangDAO  {
	public KhachHangDTO getKhachHangByUser(Long idUser);

	public void saveKhachHang(KhachHangDTO dto);

	public boolean updatePassword(KhachHangPwdForm form);

}
