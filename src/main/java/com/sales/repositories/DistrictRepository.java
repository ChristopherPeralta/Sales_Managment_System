package com.sales.repositories;

import com.sales.entities.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {

    @Query("SELECT dt FROM District dt WHERE LOWER(dt.name) = LOWER(:name)")
    District findByNameIgnoreCase(@Param("name") String name);
}
