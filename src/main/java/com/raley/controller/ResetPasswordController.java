package com.raley.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raley.model.ApiResponse;
import com.raley.model.ResetPasswordDto;
import com.raley.service.ResetPasswordService;
import com.raley.service.UserService;

@RestController
@RequestMapping("/resetPassword")
public class ResetPasswordController {
	Logger logger = LoggerFactory.getLogger(ResetPasswordController.class);

	@Autowired
	private ResetPasswordService resetPasswordService;
	@Autowired
	private UserService userService;

	@PostMapping("/generate")
	public ApiResponse<Void> reset(@RequestBody ResetPasswordDto resetPassword) {
		logger.info("find the email : "+resetPassword.getEmail()+ " for reset the password");
		if (userService.findOne(resetPassword.getEmail()) == null) {
			return new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), "Email not exist.!", null);
		} else {
			return new ApiResponse<>(HttpStatus.OK.value(), "Password  reset successfully.",
					resetPasswordService.reset(resetPassword.getEmail()).getEmail());
		}
	}
}
