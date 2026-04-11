package com.gs.greenspace.service.serviceImpl;
import com.gs.greenspace.dto.request.LoginRequestDto;
import com.gs.greenspace.dto.response.LoginResponseDto;
import com.gs.greenspace.entity.LoginEntity;
import com.gs.greenspace.repository.LoginRepository;
import com.gs.greenspace.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public LoginResponseDto register(LoginRequestDto loginRequestDto) {
        String rawPassword = loginRequestDto.getPassword();
        String encodedPassword = passwordEncoder.encode(rawPassword);

        LoginEntity loginEntity = new LoginEntity(
                loginRequestDto.getUsername(),
                encodedPassword
        );

        LoginEntity savedEntity = loginRepository.save(loginEntity);

        return new LoginResponseDto(
                "Registration successful",
                true,
                savedEntity.getUsername(),
                savedEntity.getId()
        );
    }

    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        LoginEntity loginEntity = loginRepository.findByUsername(loginRequestDto.getUsername());

        if (loginEntity != null) {
            boolean passwordMatches = passwordEncoder.matches(
                    loginRequestDto.getPassword(),
                    loginEntity.getPassword()
            );

            if (passwordMatches) {
                return new LoginResponseDto(
                        "Login successful",
                        true,
                        loginEntity.getUsername(),
                        loginEntity.getId()
                );
            } else {
                return new LoginResponseDto(
                        "Invalid password",
                        false,
                        null,
                        null
                );
            }
        } else {
            return new LoginResponseDto(
                    "User not found",
                    false,
                    null,
                    null
            );
        }
    }
}