package com.gs.greenspace.controller;

import com.gs.greenspace.dto.request.LoginRequestDto;
import com.gs.greenspace.dto.response.LoginResponseDto;
import com.gs.greenspace.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/authenticate")
    public ResponseEntity<LoginResponseDto> authenticate(@RequestBody LoginRequestDto loginRequestDto) {

        LoginResponseDto response = loginService.authenticate(loginRequestDto);

        if (response.isSuccess()) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}
