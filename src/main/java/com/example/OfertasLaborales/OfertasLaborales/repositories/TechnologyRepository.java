package com.example.OfertasLaborales.OfertasLaborales.repositories;

import com.example.OfertasLaborales.OfertasLaborales.entities.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology,Long> {
}
