package com.shoe.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shoe.converter.UserConverter;
import com.shoe.dao.KhachHangDAO;
import com.shoe.dto.KhachHangDTO;
import com.shoe.dto.UserDTO;
import com.shoe.entities.User;
import com.shoe.jpa.UserRepository;
import com.shoe.jwtauthentication.security.services.CurrentUser;
import com.shoe.jwtauthentication.security.services.UserPrinciple;
import com.shoe.payload.SeverResponse;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UserConverter userConverter;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private KhachHangDAO khachHangDAO;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@GetMapping("/checkUsernameAvailability")
	public Boolean checkUsernameAvailability(@RequestParam(value = "username") String username) {
		Boolean isAvailable = !userRepository.existsByUsername(username);
		return isAvailable;
	}

	@GetMapping("/checkEmailAvailability")
	public Boolean checkEmailAvailability(@RequestParam(value = "email") String email) {
		Boolean isAvailable = !userRepository.existsByEmail(email);
		return isAvailable;
	}

	@GetMapping("/me")
	public ResponseEntity<?> getCurrentUser(@CurrentUser UserPrinciple currentUser) {
//		if (currentUser == null) {
//			return new ResponseEntity(new SeverResponse(false, "unloggin"), HttpStatus.FORBIDDEN);
//		}
		
		KhachHangDTO khachHang = new KhachHangDTO();
		khachHang = khachHangDAO.getKhachHangByUser(currentUser.getId());
		if (khachHang == null) {
			Optional<User> optionalUser = userRepository.findById(currentUser.getId());
			if (optionalUser.isPresent()) {
				UserDTO userDTO = new UserDTO();
				userConverter.convertEntityToDto(optionalUser.get(), userDTO);
				KhachHangDTO khachHangDTO = new KhachHangDTO();
				khachHangDTO.setUser(userDTO);
				return ResponseEntity.ok(khachHangDTO);
			} else {
				return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
			}
		}
//		UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(),
//				currentUser.getRoles());
		return ResponseEntity.ok(khachHang);
	}
}
