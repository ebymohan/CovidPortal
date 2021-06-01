package com.nila.covidportal.repository;

import com.nila.covidportal.models.District;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DistrictRepository extends JpaRepository<District, Integer>{
    
}
