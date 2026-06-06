package com.busPassSys.busPassSys.Controller;

import com.busPassSys.busPassSys.Entities.Route;
import com.busPassSys.busPassSys.Service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "https://bus-pass-frontend-zeta.vercel.app")
@RestController
@RequestMapping("/routes")
@RequiredArgsConstructor
public class RouteController {
    private final RouteService routeService;

    @PostMapping("/create")
    public ResponseEntity<Route> createRoute(@RequestBody Route route,String email){
        return ResponseEntity.status(201).body(routeService.createRoute(route,email));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Route> getRoute(@PathVariable Long id){
        Route r=routeService.getRouteById(id);
        if(r!=null){
            return ResponseEntity.ok().body(r);
        }
       return ResponseEntity.status(404).build();

    }
    @GetMapping("/myroutes/{email}")
    public ResponseEntity<List<Route>>getMyRoutes(@PathVariable String email){
        return ResponseEntity.ok(routeService.getRoutesByUserId(email));
    }
    @GetMapping
    public ResponseEntity<List<Route>>getAllRoutes(){
        return ResponseEntity.ok(routeService.getAllRoutes());
    }
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Route route){
        boolean b=routeService.updateRoute(route);
        if(b){
            return ResponseEntity.ok("Updated successfully");
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        boolean d=routeService.deleteRoute(id);
        if(d){
            return ResponseEntity.ok("Deleted Successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
