package com.gs.greenspace.controller;
import com.gs.greenspace.dto.request.LoginRequestDto;
import com.gs.greenspace.dto.response.LoginResponseDto;
import com.gs.greenspace.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/admin")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/register")
    public LoginResponseDto register(@RequestBody LoginRequestDto loginRequestDto) {
        return loginService.register(loginRequestDto);
    }

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto) {
        return loginService.login(loginRequestDto);
    }
}