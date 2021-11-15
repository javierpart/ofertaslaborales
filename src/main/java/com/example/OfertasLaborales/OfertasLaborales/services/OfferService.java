package com.example.OfertasLaborales.OfertasLaborales.services;

import com.example.OfertasLaborales.OfertasLaborales.entities.Offer;
import com.example.OfertasLaborales.OfertasLaborales.repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;

    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    //CRUD METHODS



    // Create an offer.
    public Offer createOffer (Offer offer){
        return offerRepository.save(offer);
    }

    // Show all offers
    public List<Offer> getAllOffers (){
        return offerRepository.findAll();
    }

    // Show offer by ID

    public Optional<Offer> getOfferByID (Long id){
        return offerRepository.findById(id);
    }

    // Update an offer by Id
    public void updateById (Long id, Offer offer){
        Optional<Offer> offerOpt = offerRepository.findById(id);
        if(offerOpt.isPresent()){
            offerRepository.save(offer);
        }


    }
    // Delete an offer
    public void deleteOfferByID (Long id){
        offerRepository.deleteById(id);
    }

    // Delete all offers
    public void deleteAllOffers(){
        offerRepository.deleteAll();
    }
}
