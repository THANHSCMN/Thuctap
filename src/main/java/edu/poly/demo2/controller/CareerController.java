package edu.poly.demo2.controller;

import edu.poly.demo2.DTO.CareerDTO;
import edu.poly.demo2.service.CareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/careers")
public class CareerController {

    @Autowired
    private CareerService careerService;


    @GetMapping
    public List<CareerDTO> getAllCareers() {
        return careerService.getAll();
    }

    @PostMapping
    public ResponseEntity<String> createCareer(@RequestBody CareerDTO career) {
        CareerDTO createCareer = careerService.insert(career);
        if (createCareer != null) {
            return ResponseEntity.ok("Thêm thành công");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCareer(@PathVariable String id, @RequestBody CareerDTO career) {
        CareerDTO updatedCareer = careerService.update(id, career);
        if (updatedCareer != null) {
            return ResponseEntity.ok("Update thành công");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCareer(@PathVariable String id) {
        boolean deleted = careerService.deleteById(id);
        if (deleted) {
            return ResponseEntity.ok("Career deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
