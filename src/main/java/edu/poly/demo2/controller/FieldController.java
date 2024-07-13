package edu.poly.demo2.controller;

import edu.poly.demo2.DTO.FieldDTO;
import edu.poly.demo2.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class FieldController {

    @Autowired
    private FieldService fieldService;

    @GetMapping
    public List<FieldDTO> getAllFields() {
        return fieldService.getAll();
    }

    @PostMapping
    public ResponseEntity<String> createField(@RequestBody FieldDTO field) {
        FieldDTO createField = fieldService.insert(field);
        if (createField != null) {
            return ResponseEntity.ok("Thêm thành công");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<String> updateField(@PathVariable String id, @RequestBody FieldDTO field) {
        FieldDTO updatedField = fieldService.update(id, field);
        if (updatedField != null) {
            return ResponseEntity.ok("Update thành công");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteField(@PathVariable String id) {
        boolean deleted = fieldService.deleteById(id);
        if (deleted) {
            return ResponseEntity.ok("Field deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
