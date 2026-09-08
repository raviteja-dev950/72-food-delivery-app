package com.fooddelivery.controller;
import com.fooddelivery.entity.Food;
import com.fooddelivery.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class FoodController {

    @Autowired
    FoodRepository foodRepo;

    @GetMapping("/foods")
    public List<Food> list(){
        return foodRepo.findAll();
    }

    @PostMapping("/foods")
    public Food add(@RequestBody Food f){
        return foodRepo.save(f);
    }

    @PutMapping("/foods/{id}")
    public Food edit(@PathVariable Long id, @RequestBody Food body){
        Optional<Food> opt = foodRepo.findById(id);
        if(opt.isPresent()){
            Food f = opt.get();
            if(body.getTitle() != null) f.setTitle(body.getTitle());
            if(body.getCity() != null) f.setCity(body.getCity());
            if(body.getType() != null) f.setType(body.getType());
            if(body.getPrice() != null) f.setPrice(body.getPrice());
            if(body.getImageUrl() != null) f.setImageUrl(body.getImageUrl());
            if(body.getDescription() != null) f.setDescription(body.getDescription());
            if(body.getRestaurantName() != null) f.setRestaurantName(body.getRestaurantName());
            return foodRepo.save(f);
        }
        return null;
    }

    @DeleteMapping("/foods/{id}")
    public Map<String,String> del(@PathVariable Long id){
        foodRepo.deleteById(id);
        Map<String,String> res = new HashMap<>();
        res.put("message", "Deleted");
        return res;
    }
}