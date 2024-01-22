package com.sales.services;

import com.sales.dto.Request.CustomerRequestDTO;
import com.sales.dto.Response.CustomerResponseDTO;
import com.sales.entities.Customer;
import jakarta.validation.Valid;

import java.util.List;

public interface CustomerService {
    public List<CustomerResponseDTO> getAllCustomers();

    public CustomerResponseDTO getCustomerById(Long id);

    public CustomerResponseDTO saveCustomer(CustomerRequestDTO customerRequestDTO);

    public CustomerResponseDTO updateCustomer(CustomerRequestDTO customerRequestDTO, Long id);

    public void deleteCustomer(Long id);

}
