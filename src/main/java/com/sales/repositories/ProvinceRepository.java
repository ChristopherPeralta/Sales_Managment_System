package com.sales.repositories;

import com.sales.entities.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Long> {

    @Query("SELECT dt FROM Province dt WHERE LOWER(dt.name) = LOWER(:name)")
    Province findByNameIgnoreCase(@Param("name") String name);
}
