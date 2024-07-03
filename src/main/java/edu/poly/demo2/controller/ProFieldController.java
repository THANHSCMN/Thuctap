package edu.poly.demo2.controller;

import edu.poly.demo2.DTO.ProFieldDTO;
import edu.poly.demo2.service.ProFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proFields")
public class ProFieldController {

    @Autowired
    private ProFieldService proFieldService;

    @GetMapping
    public List<ProFieldDTO> getAllProFields() {
        return proFieldService.getAll();
    }

    @PostMapping
    public ResponseEntity<String> createProField(@RequestBody ProFieldDTO proField) {
        ProFieldDTO createProField = proFieldService.insert(proField);
        if (createProField != null) {
            return ResponseEntity.ok("Thêm thành công");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateProField(@PathVariable String id, @RequestBody ProFieldDTO proField) {
        ProFieldDTO updatedProField = proFieldService.update(id, proField);
        if (updatedProField != null) {
            return ResponseEntity.ok("Update thành công");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProField(@PathVariable String id) {
        boolean deleted = proFieldService.deleteById(id);
        if (deleted) {
            return ResponseEntity.ok("ProField deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
