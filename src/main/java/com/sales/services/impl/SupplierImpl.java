package com.sales.services.impl;

import com.sales.dto.Request.SupplierRequestDTO;
import com.sales.dto.Response.SupplierResponseDTO;
import com.sales.dto.mapper.SupplierMapper;
import com.sales.entities.Supplier;
import com.sales.repositories.SupplierRepository;
import com.sales.services.SupplierService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@AllArgsConstructor
@Service
public class SupplierImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;


    @Override
    public List<SupplierResponseDTO> getAllSuppliers() {
        List<Supplier> suppliersList = supplierRepository.findByIsActiveTrue();
        return supplierMapper.supplierResponseDTOListDTOList(suppliersList);
    }

    @Override
    public SupplierResponseDTO getSupplierById(Long id) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("The supplier with the id number " + id+ " does not exist."));
        return supplierMapper.toDTO(supplier);
    }

    @Override
    public SupplierResponseDTO saveSupplier(SupplierRequestDTO supplierRequestDTO) {
        Supplier supplier = supplierMapper.supplierRequestDTOtoSupplier(supplierRequestDTO);
        supplier.setActive(true);
        Supplier supplierSaved = supplierRepository.save(supplier);
        return supplierMapper.toDTO(supplierSaved);
    }

    @Override
    public SupplierResponseDTO updateSupplier(SupplierRequestDTO supplierRequestDTO, Long id) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("The supplier with the id number " + id+ " does not exist."));

        supplier.setName(supplierRequestDTO.getName());
        supplier.setRuc(supplierRequestDTO.getRuc());
        supplier.setPhone(supplierRequestDTO.getPhone());
        supplier.setEmail(supplierRequestDTO.getEmail());
        supplier.setAddress(supplierRequestDTO.getAddress());

        Supplier supplierSaved = supplierRepository.save(supplier);
        return supplierMapper.toDTO(supplierSaved);
    }

    @Override
    public void deleteSupplier(Long id) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("The supplier with the id number " + id+ " does not exist."));
        supplier.setActive(false);
        supplierRepository.save(supplier);
    }
}
