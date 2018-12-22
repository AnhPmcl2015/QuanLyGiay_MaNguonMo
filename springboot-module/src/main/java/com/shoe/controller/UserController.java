package com.shoe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.shoe.jpa.UserRepository;
import com.shoe.jwtauthentication.security.services.CurrentUser;
import com.shoe.jwtauthentication.security.services.UserPrinciple;
import com.shoe.payload.UserSummary;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;


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
	public UserSummary getCurrentUser(@CurrentUser UserPrinciple currentUser){
		UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(),
				currentUser.getRoles());
		return userSummary;
	}
}
