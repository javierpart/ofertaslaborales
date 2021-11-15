package com.example.OfertasLaborales.OfertasLaborales.controllers;

import com.example.OfertasLaborales.OfertasLaborales.entities.Offer;
import com.example.OfertasLaborales.OfertasLaborales.services.OfferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OfferController {

    private final Logger log = LoggerFactory.getLogger(OfferController.class);
    private OfferService offerService;
    private static final String API_BASE="/api/v1/offers/";

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    //CRUD

    //GET METHODS
    @GetMapping (API_BASE)
    public ResponseEntity<List<Offer>> getAllOffers() {
        return new ResponseEntity<>(offerService.getAllOffers(), HttpStatus.OK);
    }

    @GetMapping (API_BASE + "/{id}")
    public ResponseEntity<Offer> getOfferById(@PathVariable("id") Long id) {
        Optional<Offer> offerOpt = offerService.getOfferByID(id);
        if (offerOpt.isPresent()){
            return ResponseEntity.ok(offerOpt.get());
        }else{
            log.warn("trying to get a non existing offer");
            return ResponseEntity.notFound().build();
        }
    }

    //DELETE METHODS
    @DeleteMapping (API_BASE)
    public ResponseEntity deleteAllOffers(){
        offerService.deleteAllOffers();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping (API_BASE + "/{id}")
    public ResponseEntity deleteOfferById (@PathVariable("id") Long id){
        Optional<Offer> offerOpt = offerService.getOfferByID(id);
        if(offerOpt.isPresent()){
            offerService.deleteOfferByID(id);
            return ResponseEntity.ok().build();
        }else{
            log.warn("trying to delete a non existing offer");
            return ResponseEntity.notFound().build();
        }
    }

    // CREATE METHOD
    @PostMapping(API_BASE)
    public ResponseEntity createOffer(@RequestBody Offer offer){
        offerService.createOffer(offer);
        return ResponseEntity.ok().build();
    }

    // UPDATE METHOD
    @PutMapping(API_BASE + "/{id}")
    public ResponseEntity updateOffer(@PathVariable("id") Long id, @RequestBody Offer offer){
        offerService.updateById(id, offer);
        return ResponseEntity.ok().build();
    }
}
