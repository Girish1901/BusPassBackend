package com.busPassSys.busPassSys.Repository;

import com.busPassSys.busPassSys.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User,Long>{
    User findByEmail(String email);
    void deleteByEmail(String email);
}
