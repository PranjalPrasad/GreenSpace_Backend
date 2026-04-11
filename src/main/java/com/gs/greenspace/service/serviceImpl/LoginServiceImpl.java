package com.gs.greenspace.service.serviceImpl;

import com.gs.greenspace.dto.request.LoginRequestDto;
import com.gs.greenspace.dto.response.LoginResponseDto;
import com.gs.greenspace.entity.LoginEntity;
import com.gs.greenspace.repository.LoginRepository;
import com.gs.greenspace.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public LoginResponseDto authenticate(LoginRequestDto loginRequestDto) {

        // Find by username only (not by password)
        Optional<LoginEntity> loginEntityOpt = loginRepository.findByUsername(
                loginRequestDto.getUsername()
        );

        if (loginEntityOpt.isPresent()) {
            LoginEntity loginEntity = loginEntityOpt.get();
            String storedPassword = loginEntity.getPassword();

            // Check if password is BCrypt hashed or plain text
            boolean passwordMatches;
            if (storedPassword.startsWith("$2a$") || storedPassword.startsWith("$2b$")) {
                // BCrypt hashed password
                passwordMatches = passwordEncoder.matches(
                        loginRequestDto.getPassword(),
                        storedPassword
                );
            } else {
                // Plain text password (for migration)
                passwordMatches = loginRequestDto.getPassword().equals(storedPassword);

                // Optional: Migrate plain text to BCrypt on successful login
                if (passwordMatches) {
                    String hashedPassword = passwordEncoder.encode(loginRequestDto.getPassword());
                    loginEntity.setPassword(hashedPassword);
                    loginRepository.save(loginEntity);
                }
            }

            if (passwordMatches) {
                return new LoginResponseDto(true, "Login successful", loginEntity.getUsername());
            }
        }

        return new LoginResponseDto(false, "Invalid username or password", null);
    }
}