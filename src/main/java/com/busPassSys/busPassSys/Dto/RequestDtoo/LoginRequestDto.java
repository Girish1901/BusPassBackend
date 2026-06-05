package com.busPassSys.busPassSys.Dto.RequestDtoo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class LoginRequestDto {
    private String email;

    private String password;
}
