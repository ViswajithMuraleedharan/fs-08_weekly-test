package com.example.PortalSystem.controller;

import com.example.PortalSystem.dao.StudentRepo;
import com.example.PortalSystem.model.Laptop;
import com.example.PortalSystem.model.Student;
import com.example.PortalSystem.services.LaptopService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LaptopController {
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    LaptopService laptopService;
    @PostMapping("/add-laptop")
    public String addLaptop(@RequestBody String newLaptop){
        JSONObject json = new JSONObject(newLaptop);
        Laptop laptop = setLaptop(json);
        laptopService.addLaptop(laptop);
        return "Student Added";
    }
    @GetMapping("/get-laptop")
    public List<Laptop> getAllBook(){
        return laptopService.getAllLaptop();
    }

    @DeleteMapping("/delete-laptop/{laptop_id}")
    public String deleteBook(@PathVariable String laptop_id){
        return laptopService.deleteBook(laptop_id);
    }

    private Laptop setLaptop(JSONObject json) {
        Laptop laptop=new Laptop();
        laptop.setName(json.getString("name"));
        laptop.setBrand(json.getString("brand"));
        laptop.setPrice(json.getInt("price"));

        String studentid = json.getString("student_id");
        Student student = studentRepo.findById(Integer.valueOf(studentid)).get();

        laptop.setID(student.getId());
        return laptop;
    }
}
