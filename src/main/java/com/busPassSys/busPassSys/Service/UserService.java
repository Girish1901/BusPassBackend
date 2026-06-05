package com.busPassSys.busPassSys.Service;

import com.busPassSys.busPassSys.Entities.User;
import com.busPassSys.busPassSys.Repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }
    public User findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    @Transactional
    public boolean updateUser(User user){
        User u=userRepository.findByEmail(user.getEmail());
        if(u!=null){
            u.setUserName(user.getUserName()!=null? user.getUserName() : u.getUserName());
            u.setPhone(user.getPhone()!=null? user.getPhone() : u.getPhone());
            createUser(u);
            return true;
        }
        return false;
    }
    @Transactional
    public boolean deleteUserByEmail(String email){
        User u=userRepository.findByEmail(email);
        if(u!=null){
            userRepository.deleteByEmail(email);
            return true;
        }
        return false;
    }

}

