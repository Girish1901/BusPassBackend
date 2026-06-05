package com.busPassSys.busPassSys.Service;

import com.busPassSys.busPassSys.Dto.RequestDtoo.LoginRequestDto;
import com.busPassSys.busPassSys.Dto.RequestDtoo.RegisterDto;
import com.busPassSys.busPassSys.Dto.ResponseDto.LoginResponseDto;
import com.busPassSys.busPassSys.Entities.User;
import com.busPassSys.busPassSys.Repository.UserRepository;
import com.busPassSys.busPassSys.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;


    public LoginResponseDto register(RegisterDto req) throws Exception {
        User user=userRepository.findByEmail(req.getEmail());
        if(user!=null){
            throw new Exception("User already exists");
        }
        else{
            User u=new User();
            u.setUserName(req.getName());
            u.setEmail(req.getEmail());
            u.setPassword(req.getPassword());
            u.setPhone(req.getPhno());
            u.setRole(Role.USER);
            userRepository.save(u);
            return new LoginResponseDto(u.getUserName(),u.getEmail(),u.getRole());
        }

    }
    public LoginResponseDto login(LoginRequestDto req)throws Exception{
        User u=userRepository.findByEmail(req.getEmail());
        if(u!=null){
           boolean a=u.getPassword().equals(req.getPassword());
           if(a){
               return new LoginResponseDto(u.getUserName(),u.getEmail(),u.getRole());
           }
            throw new Exception("Wrong password");
        }
        throw new Exception("User not found");
    }
}
