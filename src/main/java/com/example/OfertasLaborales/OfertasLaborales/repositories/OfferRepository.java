package com.example.OfertasLaborales.OfertasLaborales.repositories;

import com.example.OfertasLaborales.OfertasLaborales.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer,Long> {
}
