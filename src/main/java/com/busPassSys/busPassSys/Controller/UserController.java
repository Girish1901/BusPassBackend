package com.busPassSys.busPassSys.Controller;

import com.busPassSys.busPassSys.Entities.User;
import com.busPassSys.busPassSys.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
    }

    @GetMapping("/user")
    public ResponseEntity<User> getUser(@RequestParam String email) {
        User u = userService.findUserByEmail(email);
        if (u != null) {
            return ResponseEntity.ok(u);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User b = userService.updateUser(user);
        if (b != null) {
            return ResponseEntity.ok(b);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{email}")
    public ResponseEntity<String> deleteById(@PathVariable String email) {
        boolean d = userService.deleteUserByEmail(email);
        if (d) {
            return ResponseEntity.ok("Deleted Successfully");
        }
        return ResponseEntity.notFound().build();
    }
}