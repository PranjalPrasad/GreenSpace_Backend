package com.gs.greenspace.service;

import com.gs.greenspace.dto.request.LoginRequestDto;
import com.gs.greenspace.dto.response.LoginResponseDto;

public interface LoginService {
    LoginResponseDto register(LoginRequestDto loginRequestDto);
    LoginResponseDto login(LoginRequestDto loginRequestDto);
}