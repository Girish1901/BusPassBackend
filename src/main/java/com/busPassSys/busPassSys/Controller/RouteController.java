package com.busPassSys.busPassSys.Controller;

import com.busPassSys.busPassSys.Entities.Route;
import com.busPassSys.busPassSys.Service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/routes")
@RequiredArgsConstructor
public class RouteController {
    private final RouteService routeService;

    @PostMapping("/create")
    public ResponseEntity<Route> createRoute(
            @RequestBody Route route,
            @RequestParam String email) {
        return ResponseEntity.status(HttpStatus.CREATED).body(routeService.createRoute(route, email));
    }

    @GetMapping("/{routeName}")
    public ResponseEntity<Route> getRoute(@PathVariable String routeName) {
        Route r = routeService.getRouteByName(routeName);
        if (r != null) {
            return ResponseEntity.ok(r);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Route>> searchRoutes(
            @RequestParam String startPoint,
            @RequestParam String endPoint) {
        return ResponseEntity.ok(routeService.searchRoutes(startPoint, endPoint));
    }
        @GetMapping("/search/start")
    public ResponseEntity<List<Route>> searchRoutesByStartPoint(
            @RequestParam String startPoint) {
        return ResponseEntity.ok(routeService.searchRoutesByStartPoint(startPoint));
    }
         @GetMapping("/search/{routeName}")
    public ResponseEntity<Route> searchRoutesByRouteName(
            @PathVariable String routeName) {
        return ResponseEntity.ok(routeService.getRouteByName(routeName));
    }

    @GetMapping("/myroutes")
    public ResponseEntity<List<Route>> getMyRoutes(@RequestParam String email) {
        return ResponseEntity.ok(routeService.getRoutesByUserId(email));
    }

    @GetMapping
    public ResponseEntity<List<Route>> getAllRoutes() {
        return ResponseEntity.ok(routeService.getAllRoutes());
    }

    @PutMapping("/update")
    public ResponseEntity<Route> update(
            @RequestBody Route route,
            @RequestParam String routeName) {
        Route r = routeService.updateRoute(route, routeName);
        if (r != null) {
            return ResponseEntity.ok(r);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        boolean d = routeService.deleteRoute(id);
        if (d) {
            return ResponseEntity.ok("Deleted Successfully");
        }
        return ResponseEntity.notFound().build();
    }
}