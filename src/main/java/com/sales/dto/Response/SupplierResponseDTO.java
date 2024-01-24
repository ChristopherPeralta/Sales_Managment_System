package com.sales.dto.Response;

import com.sales.entities.District;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SupplierResponseDTO {

    private Long id;

    private String name;

    private String ruc;

    private String phone;

    private String address;

    private String email;

    private boolean isActive;

    private String districtName;
    private String provinceName;

}
