package com.sales.dto.mapper;

import com.sales.dto.Request.SupplierRequestDTO;
import com.sales.dto.Response.SupplierResponseDTO;
import com.sales.entities.District;
import com.sales.entities.Supplier;
import com.sales.repositories.DistrictRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Component
public class SupplierMapper {

    private DistrictRepository districtRepository;

    public Supplier supplierRequestDTOtoSupplier(SupplierRequestDTO supplierRequestDTO) {
        Supplier supplier = new Supplier();

        supplier.setName(supplierRequestDTO.getName());
        supplier.setRuc(supplierRequestDTO.getRuc());
        supplier.setPhone(supplierRequestDTO.getPhone());
        supplier.setEmail(supplierRequestDTO.getEmail());
        supplier.setAddress(supplierRequestDTO.getAddress());

        District district = districtRepository.findByNameIgnoreCase(supplierRequestDTO.getDistrictName());
        supplier.setDistrict(district);

        return supplier;
    }

    public SupplierResponseDTO toDTO(Supplier supplier) {
        SupplierResponseDTO supplierDTO = new SupplierResponseDTO();

        supplierDTO.setId(supplier.getId());
        supplierDTO.setName(supplier.getName());
        supplierDTO.setRuc(supplier.getRuc());
        supplierDTO.setPhone(supplier.getPhone());
        supplierDTO.setAddress(supplier.getAddress());
        supplierDTO.setEmail(supplier.getEmail());
        supplierDTO.setActive(supplier.isActive());

        if (supplier.getDistrict() != null) {
            supplierDTO.setDistrictName(supplier.getDistrict().getName());
            supplierDTO.setProvinceName(supplier.getDistrict().getProvince().getName());
        }

        return supplierDTO;
    }

    public List<SupplierResponseDTO> supplierResponseDTOListDTOList(List<Supplier> suppliersList) {
        List<SupplierResponseDTO> listResponse = new ArrayList<>();

        if (suppliersList == null) {
            throw new IllegalArgumentException("La lista de proveedores es nula. Proporcione una lista válida.");
        }

        for (Supplier supplier : suppliersList) {
            SupplierResponseDTO supplierResponseDTO = toDTO(supplier);
            listResponse.add(supplierResponseDTO);
        }

        return listResponse;
    }

}
