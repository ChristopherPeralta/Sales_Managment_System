package com.sales.controller;

import com.sales.dto.Request.SupplierRequestDTO;
import com.sales.dto.Response.SupplierResponseDTO;
import com.sales.services.SupplierService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("sales-system")
@CrossOrigin("*") //Angular port //value = "http://localhost:4200"
@AllArgsConstructor
public class SupplierController {

    private SupplierService supplierService;

    @GetMapping("/suppliers")
    public ResponseEntity<List<SupplierResponseDTO>> listSuppliers() {
        try {
            List<SupplierResponseDTO> responseDTO = supplierService.getAllSuppliers();
            return ResponseEntity.ok(responseDTO);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/suppliers/{id}")
    public ResponseEntity<SupplierResponseDTO> getSupplierById(@PathVariable Long id) {
        try {
            SupplierResponseDTO responseDTO = supplierService.getSupplierById(id);
            return ResponseEntity.ok(responseDTO);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/suppliers")
    public ResponseEntity<SupplierResponseDTO> saveSupplier(@Valid @RequestBody SupplierRequestDTO supplierRequestDTO) {
        try {
            SupplierResponseDTO responseDTO = supplierService.saveSupplier(supplierRequestDTO);
            return ResponseEntity.ok(responseDTO);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/suppliers/{id}")
    public ResponseEntity<SupplierResponseDTO> updateSupplier(@Valid @RequestBody SupplierRequestDTO supplierRequestDTO, @PathVariable Long id) {
        try {
            SupplierResponseDTO responseDTO = supplierService.updateSupplier(supplierRequestDTO, id);
            return ResponseEntity.ok(responseDTO);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/suppliers/{id}")
    public ResponseEntity<?> deleteSupplier(@PathVariable Long id) {
        try {
            supplierService.deleteSupplier(id);
            return ResponseEntity.ok().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
