package com.sales.dto.Request;

import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRequestDTO {
    @NotBlank(message = "The name can't be empty")
    @Size(min = 1, max = 100, message = "The name can't be more than 100 letters")
    private String name;

    @NotBlank(message = "The document number can't be empty")
    @Pattern(regexp = "\\d{8}|\\d{11}", message = "The document number must be either 8 or 11 digits")
    private String documentNumber;


    @Pattern(regexp = "\\d{9}", message = "The phone must have 9 numbers")
    private String phone;

    @Size(min = 1, max = 100, message = "The address can't be more than 100 letters")
    private String address;

    @Email
    @Size(min = 1, max = 100, message = "The email can't be more than 100 letters")
    private String email;

    private boolean isActive;

    @NotBlank(message = "You should select a district")
    @Size(min = 1, max = 100, message = "The district name can't be more than 100 letters")
    private String districtName;

    @NotBlank(message = "You should select a document type RUC or DNI")
    @Size(min = 3, max = 3, message = "The document type name must be 3 letters")
    private String documentTypeName;
}
