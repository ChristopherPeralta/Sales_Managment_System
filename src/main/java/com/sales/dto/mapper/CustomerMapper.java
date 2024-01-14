package com.sales.dto.mapper;

import com.sales.dto.Request.CustomerRequestDTO;
import com.sales.dto.Response.CustomerResponseDTO;
import com.sales.entities.Customer;
import com.sales.entities.DocumentType;
import com.sales.repositories.DocumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerMapper {
    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    public Customer customerRequestDTOtoCustomer(CustomerRequestDTO customerRequestDTO) {
        Customer customer = new Customer();

        customer.setName(customerRequestDTO.getName());
        customer.setAddress(customerRequestDTO.getAddress());
        customer.setEmail(customerRequestDTO.getEmail());
        customer.setPhone(customerRequestDTO.getPhone());
        customer.setDocumentNumber(customerRequestDTO.getDocumentTypeName());

        // Buscar el DocumentType en la base de datos
        DocumentType documentType = documentTypeRepository.findByNameIgnoreCase(customerRequestDTO.getDocumentTypeName());
        customer.setDocumentType(documentType);

        return customer;
    }

    public CustomerResponseDTO toDTO(Customer customer) {
        CustomerResponseDTO customerDTO = new CustomerResponseDTO();

        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPhone(customer.getPhone());
        customerDTO.setDocumentNumber(customer.getDocumentNumber());
        customerDTO.setActive(customer.isActive());

        if (customer.getDocumentType() != null) {
            customerDTO.setDocumentTypeName(customer.getDocumentType().getName().name());
        }

        return customerDTO;
    }

    public List<CustomerResponseDTO> customerResponseDTOListDTOList(List<Customer> customersList) {
        List<CustomerResponseDTO> listResponse = new ArrayList<>();

        if (customersList == null) {
            throw new IllegalArgumentException("La lista de clientes es nula. Proporcione una lista válida.");
        }

        for (Customer customers : customersList) {
            CustomerResponseDTO customerResponseDTO = toDTO(customers);
            listResponse.add(customerResponseDTO);
        }

        return listResponse;
    }
}
