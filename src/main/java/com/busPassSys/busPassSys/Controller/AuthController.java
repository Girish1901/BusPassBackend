package com.busPassSys.busPassSys.Controller;

import com.busPassSys.busPassSys.Dto.RequestDtoo.LoginRequestDto;
import com.busPassSys.busPassSys.Dto.RequestDtoo.RegisterDto;
import com.busPassSys.busPassSys.Dto.ResponseDto.LoginResponseDto;
import com.busPassSys.busPassSys.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "https://bus-pass-frontend-zeta.vercel.app")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/register")
    public ResponseEntity<LoginResponseDto>register(@RequestBody RegisterDto reg) throws Exception {
        try{
            return ResponseEntity.status(201).body(authService.register(reg));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto>login(@RequestBody LoginRequestDto log)throws Exception{
        try{
            return ResponseEntity.ok().body(authService.login(log));
        }catch (Exception e){
            return ResponseEntity.status(401).build();
        }
    }

}
