package com.busPassSys.busPassSys.Service;

import com.busPassSys.busPassSys.Entities.Route;
import com.busPassSys.busPassSys.Entities.User;
import com.busPassSys.busPassSys.Repository.RouteRepository;
import com.busPassSys.busPassSys.Repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteService {
    private final RouteRepository routeRepository;
    private final UserRepository userRepository;

    public Route createRoute(Route route,@RequestParam String email){
        User u=userRepository.findByEmail(email);
        route.setUser(u);
        return routeRepository.save(route);
    }
    public List<Route> searchRoutes(String startPoint,String endPoint) {
        return routeRepository
                .findByStarPointAndEndPoint(
                        startPoint,
                        endPoint);
    }
        public List<Route> searchRoutesByStartPoint(String startPoint) {
        return routeRepository
                .findByStarPoint(startPoint);
    }

    public List<Route>getRoutesByUserId(String email){
        return routeRepository.findByUserEmail(email);
    }
    public Route getRouteByName(String routeName){
        return routeRepository.findByRouteName(routeName);
    }

    public List<Route>getAllRoutes(){
        return routeRepository.findAll();
    }
    public Route getRouteById(Long id){
        return routeRepository.findById(id).orElse(null);
    }
    @Transactional
    public Route updateRoute(Route route,String routename){
        Route r=routeRepository.findByRouteName(routename);
        if(r!=null){
            r.setRouteName(route.getRouteName()!=null?route.getRouteName():r.getRouteName());
            r.setStarPoint(route.getStarPoint()!=null?route.getStarPoint():r.getStarPoint());
            r.setEndPoint(route.getEndPoint()!=null?route.getEndPoint():r.getEndPoint());
            r.setFare(route.getFare()!=0?route.getFare():r.getFare());
            routeRepository.save(r);
            return r;
        }
        return null;
    }
    @Transactional
    public boolean deleteRoute(Long id){
        Route r=routeRepository.findById(id).orElse(null);
        routeRepository.deleteById(id);
        return r!=null?true:false;
    }
}
