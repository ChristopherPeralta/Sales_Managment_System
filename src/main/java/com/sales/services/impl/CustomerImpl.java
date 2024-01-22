package com.sales.services.impl;

import com.sales.dto.Request.CustomerRequestDTO;
import com.sales.dto.Response.CustomerResponseDTO;
import com.sales.dto.mapper.CustomerMapper;
import com.sales.entities.Customer;
import com.sales.repositories.CustomerRepository;
import com.sales.services.CustomerService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Transactional
@AllArgsConstructor
@Service
public class CustomerImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final Validator validator;

    //Listar
    @Transactional(readOnly = true)
    @Override
    public List<CustomerResponseDTO> getAllCustomers() {
        List<Customer> customersList = customerRepository.findByIsActiveTrue();
        return customerMapper.customerResponseDTOListDTOList(customersList);
    }

    @Override
    public CustomerResponseDTO getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El cliente no existe." + id));
        return customerMapper.toDTO(customer);
    }

    @Override
    public CustomerResponseDTO saveCustomer(CustomerRequestDTO customerRequestDTO) {
        Customer customer = customerMapper.customerRequestDTOtoCustomer(customerRequestDTO);
        customer.setActive(true);
        Customer customerSaved = customerRepository.save(customer);
        return customerMapper.toDTO(customerSaved);
    }

    @Override
    public CustomerResponseDTO updateCustomer(CustomerRequestDTO customerRequestDTO, Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El cliente no existe." + id));

        customer.setName(customerRequestDTO.getName());
        customer.setAddress(customerRequestDTO.getAddress());
        customer.setEmail(customerRequestDTO.getEmail());
        customer.setPhone(customerRequestDTO.getPhone());
        customer.setDocumentNumber(customerRequestDTO.getDocumentNumber());

        Customer customerSaved = customerRepository.save(customer);
        return customerMapper.toDTO(customerSaved);
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El cliente no existe." + id));
        customer.setActive(false);
        customerRepository.save(customer);
    }
}
