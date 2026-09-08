package com.fooddelivery.controller;
import com.fooddelivery.entity.User;
import com.fooddelivery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class AuthController {

    @Autowired
    UserRepository userRepo;

    @PostMapping("/auth/login")
    public Map<String,Object> login(@RequestBody Map<String,String> body){
        String username = body.get("username");
        Optional<User> opt = userRepo.findByUsername(username);
        User u;
        long id;
        String role;

        if(opt.isPresent()){
            u = opt.get();
            id = u.getId();
            role = u.getRole();
        } else {
            // new custom user not in DB yet
            id = 3L;
            role = "CUSTOMER";
            if(username.equals("admin")){
                id = 1L;
                role = "ADMIN";
            }
            if(username.equals("owner")){
                id = 2L;
                role = "OWNER";
            }
        }

        if(role == null){
            role = "CUSTOMER";
        }

        Map<String,Object> res = new HashMap<>();
        res.put("token", "demo-token-" + username);
        res.put("id", id);
        res.put("username", username);
        res.put("role", role);
        return res;
    }

    @PostMapping("/auth/register")
    public Map<String,Object> register(@RequestBody Map<String,String> body){
        String username = body.get("username");
        String password = body.get("password");
        String role = body.getOrDefault("role", "CUSTOMER");

        if(userRepo.findByUsername(username).isEmpty()){
            User nu = new User();
            nu.setUsername(username);
            nu.setPassword(password);
            nu.setRole(role);
            userRepo.save(nu);
        }

        Optional<User> opt2 = userRepo.findByUsername(username);
        User saved = opt2.isPresent() ? opt2.get() : new User();

        long id = 3L;
        if(saved.getId() != null){
            id = saved.getId();
        }
        if(username.equals("admin")) id = 1L;
        if(username.equals("owner")) id = 2L;

        String finalRole = saved.getRole();
        if(finalRole == null) finalRole = role;

        Map<String,Object> res = new HashMap<>();
        res.put("message", "Account created! Now Sign In");
        res.put("token", "demo-token-" + username);
        res.put("id", id);
        res.put("username", username);
        res.put("role", finalRole);
        return res;
    }
}