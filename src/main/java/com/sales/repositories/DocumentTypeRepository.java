package com.sales.repositories;

import com.sales.entities.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DocumentTypeRepository extends JpaRepository<DocumentType, Long> {
    @Query("SELECT dt FROM DocumentType dt WHERE LOWER(dt.name) = LOWER(:name)")
    DocumentType findByNameIgnoreCase(@Param("name") String name);
}
