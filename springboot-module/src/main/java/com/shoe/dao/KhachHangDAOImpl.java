package com.shoe.dao;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.shoe.converter.KhachHangConverter;
import com.shoe.dto.KhachHangDTO;
import com.shoe.entities.KhachHang;
import com.shoe.entities.User;
import com.shoe.form.KhachHangPwdForm;
import com.shoe.jpa.JpaKhachHang;
import com.shoe.jpa.UserRepository;

@Repository
@Transactional
public class KhachHangDAOImpl implements KhachHangDAO {

	@Autowired
	private JpaKhachHang jpaKhachHang;

	@Autowired
	private UserRepository jpaUser;

	@Autowired
	KhachHangConverter khachHangEco;

	@Autowired
	PasswordEncoder encoder;

	@Override
	public KhachHangDTO getKhachHangByUser(Long idUser) {
		KhachHang khachHang = new KhachHang();
		KhachHangDTO khachHangdto = new KhachHangDTO();
		khachHang = jpaKhachHang.findByUserUserId(idUser);
		khachHangEco.convertEntityToDto(khachHang, khachHangdto);
		return khachHangdto;
	}

	@Override
	public void saveKhachHang(KhachHangDTO dto) {
		Optional<KhachHang> kh = jpaKhachHang.findById(dto.getIdKhachHang());
		if(kh.isPresent()){
			KhachHang khachHang = kh.get();
			khachHang.setDiaChi(dto.getDiaChi());
			khachHang.setIdKhachHang(dto.getIdKhachHang());
			khachHang.setSoDienThoai(dto.getSoDienThoai());
			khachHang.setTenKhachHang(dto.getTenKhachHang());
			jpaKhachHang.save(khachHang);
		}
	}

	@Override
	public boolean updatePassword(KhachHangPwdForm form) {

		Optional<User> u = jpaUser.findById(Long.parseLong(form.getId()));
		if (u.isPresent()) {
			User user = u.get();
			if(encoder.matches(form.getOldPwd(),user.getPassword())){
				user.setPassword(encoder.encode(form.getNewPwd()));
				jpaUser.save(user);
				return true;
			}
		}
		return false;
	}
}