package com.sales.controller;

import com.sales.dto.Request.CustomerRequestDTO;
import com.sales.dto.Response.CustomerResponseDTO;
import com.sales.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("sales-system")
@CrossOrigin("*") //Angular port //value = "http://localhost:4200"
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerResponseDTO>> listCostumers() {
        try {
            List<CustomerResponseDTO> responseDTO = customerService.getAllCustomers();
            return ResponseEntity.ok(responseDTO);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<CustomerResponseDTO> getCustomerById(@PathVariable Long id) {
        try {
            CustomerResponseDTO responseDTO = customerService.getCustomerById(id);
            return ResponseEntity.ok(responseDTO);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/customers")
    public ResponseEntity<CustomerResponseDTO> saveCustomer(@RequestBody CustomerRequestDTO customerRequestDTO) {
        try {
            CustomerResponseDTO responseDTO = customerService.saveCustomer(customerRequestDTO);
            return ResponseEntity.ok(responseDTO);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<CustomerResponseDTO> updateCustomer(@RequestBody CustomerRequestDTO customerRequestDTO, @PathVariable Long id) {
        try {
            CustomerResponseDTO responseDTO = customerService.updateCustomer(customerRequestDTO, id);
            return ResponseEntity.ok(responseDTO);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        try {
            customerService.deleteCustomer(id);
            return ResponseEntity.ok().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
