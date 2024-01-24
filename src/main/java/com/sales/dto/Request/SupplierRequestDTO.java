package com.sales.dto.Request;

import com.sales.entities.District;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SupplierRequestDTO {

    @NotBlank(message = "The name can't be empty")
    @Size(min = 1, max = 100, message = "The name can't be more than 100 letters")
    private String name;

    @NotBlank(message = "The RUC number can't be empty")
    @Pattern(regexp = "\\d{11}", message = "The document number must be 11 digits")
    private String ruc;

    @NotBlank(message = "The phone can't be empty")
    @Pattern(regexp = "\\d{9}", message = "The phone must have 9 numbers")
    private String phone;

    @NotBlank(message = "The phone can't be empty")
    @Size(min = 1, max = 100, message = "The address can't be more than 100 letters")
    private String address;

    @Email
    @NotBlank(message = "The phone can't be empty")
    @Size(min = 1, max = 100, message = "The email can't be more than 100 letters")
    private String email;

    @Column(name = "isActive")
    private boolean isActive;

    @NotBlank(message = "You should select a district")
    @Size(min = 1, max = 100, message = "The district name can't be more than 100 letters")
    private String districtName;
}
