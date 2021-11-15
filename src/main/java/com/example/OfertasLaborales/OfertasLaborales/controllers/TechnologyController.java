package com.example.OfertasLaborales.OfertasLaborales.controllers;


import com.example.OfertasLaborales.OfertasLaborales.entities.Technology;
import com.example.OfertasLaborales.OfertasLaborales.services.TechnologyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class TechnologyController {
    private final Logger log = LoggerFactory.getLogger(OfferController.class);
    private TechnologyService technologyService;
    private static final String API_BASE="/api/v1/technologies/";

    public TechnologyController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }
//CRUD

    //GET METHODS
    @GetMapping(API_BASE)
    public ResponseEntity<List<Technology>> getAllTechnology() {
        return new ResponseEntity<>(technologyService.getAllTechnology(), HttpStatus.OK);
    }

    @GetMapping (API_BASE + "/{id}")
    public ResponseEntity<Technology> getTechnologyById(@PathVariable("id") Long id) {
        Optional<Technology> offerOpt = technologyService.getById(id);
        if (offerOpt.isPresent()){
            return ResponseEntity.ok(offerOpt.get());
        }else{
            log.warn("trying to get a non existing offer");
            return ResponseEntity.notFound().build();
        }
    }

    //DELETE METHODS
    @DeleteMapping(API_BASE)
    public ResponseEntity deleteAllTechnology(){
        technologyService.deleteAllTechnology();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping (API_BASE + "/{id}")
    public ResponseEntity deleteTechnologyById (@PathVariable("id") Long id){
        Optional<Technology> offerOpt = technologyService.getById(id);
        if(offerOpt.isPresent()){
            technologyService.deleteTechnologyById(id);
            return ResponseEntity.ok().build();
        }else{
            log.warn("trying to delete a non existing offer");
            return ResponseEntity.notFound().build();
        }
    }

    // CREATE METHOD
    @PostMapping(API_BASE)
    public ResponseEntity createTechnology(@RequestBody Technology technology){
        technologyService.createTechnology(technology);
        return ResponseEntity.ok().build();
    }

    // UPDATE METHOD
    @PutMapping(API_BASE + "/{id}")
    public ResponseEntity updateTechnology(@PathVariable("id") Long id, @RequestBody Technology technology){
        technologyService.updateTechnology(technology);
        return ResponseEntity.ok().build();
    }
}
