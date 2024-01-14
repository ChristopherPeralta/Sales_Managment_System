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

    @Size(min = 9, max = 9, message = "The phone must have 9 numbers")
    private String phone;

    @Size(min = 1, max = 100, message = "The address can't be more than 100 letters")
    private String address;

    @Email
    @Size(min = 1, max = 100, message = "The email can't be more than 100 letters")
    private String email;

    private boolean isActive;

    @NotBlank(message = "You should select a document type RUC or DNI")
    @Size(min = 3, max = 3, message = "The document type name must be 3 letters")
    private String documentTypeName;
}
