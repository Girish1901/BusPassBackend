package com.busPassSys.busPassSys.Dto.ResponseDto;

import com.busPassSys.busPassSys.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponseDto {
    private String name;
    private String email;
    private Role role;
}
