package com.busPassSys.busPassSys.Controller;

import com.busPassSys.busPassSys.Dto.RequestDtoo.LoginRequestDto;
import com.busPassSys.busPassSys.Dto.RequestDtoo.RegisterDto;
import com.busPassSys.busPassSys.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDto reg) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(reg));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto log) {
        try {
            return ResponseEntity.ok(authService.login(log));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}