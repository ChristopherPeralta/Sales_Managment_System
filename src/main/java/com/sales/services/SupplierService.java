package com.sales.services;

import com.sales.dto.Request.SupplierRequestDTO;
import com.sales.dto.Response.SupplierResponseDTO;

import java.util.List;

public interface SupplierService {

    public List<SupplierResponseDTO> getAllSuppliers();

    public SupplierResponseDTO getSupplierById(Long id);

    public SupplierResponseDTO saveSupplier(SupplierRequestDTO supplierRequestDTO);

    public SupplierResponseDTO updateSupplier(SupplierRequestDTO supplierRequestDTO, Long id);

    public void deleteSupplier(Long id);


}
