package com.sales.dto.Response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponseDTO {

    private Long id;

    private String documentNumber;

    private String name;

    private String phone;

    private String address;

    private String email;

    private boolean isActive;

    private String documentTypeName;

    private String districtName;

    private String provinceName;
}
