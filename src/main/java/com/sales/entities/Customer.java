package com.sales.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "documentNumber", length = 11, nullable = false)
    private String documentNumber;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "phone", length = 9, nullable = false)
    private String phone;

    @Column(name = "address", length = 100)
    private String address;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "isActive")
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "document_type_id", nullable = false)
    protected DocumentType documentType;
}