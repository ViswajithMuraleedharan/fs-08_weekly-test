package com.example.PortalSystem.services;

import com.example.PortalSystem.dao.LaptopRepo;
import com.example.PortalSystem.model.Laptop;
import com.example.PortalSystem.model.Student;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {
    @Autowired
    LaptopRepo laptopRepo;
    public void addLaptop(Laptop laptop) {
        laptopRepo.save(laptop);
    }

    public List<Laptop> getAllLaptop() {
        return laptopRepo.findAll();
    }

    public String deleteBook(String laptopId) {
        for (Laptop laptop : laptopRepo.findAll()) {
            if (laptop.getID()==(Integer.valueOf(laptopId))){
                laptopRepo.delete(laptop);
                return "Deleted";
            }
        }
        return "Not found";
    }
}
