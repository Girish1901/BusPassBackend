package com.busPassSys.busPassSys.Repository;

import com.busPassSys.busPassSys.Entities.Route;
import com.busPassSys.busPassSys.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route,Long>{
    List<Route> findByUser(User user);
    List<Route>findByUserEmail(String email);
    List<Route> findByStarPointAndEndPoint(String starPoint, String endPoint);
    List<Route> findByStarPoint(String starPoint);
    Route findByRouteName(String routeName);
}
