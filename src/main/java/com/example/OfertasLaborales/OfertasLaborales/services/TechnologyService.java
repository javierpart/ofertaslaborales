package com.example.OfertasLaborales.OfertasLaborales.services;

import com.example.OfertasLaborales.OfertasLaborales.entities.Technology;
import com.example.OfertasLaborales.OfertasLaborales.repositories.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TechnologyService {

    @Autowired
    private TechnologyRepository technologyRepository;

    public TechnologyService(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    //CRUD

    public List<Technology> getAllTechnology(){
        return technologyRepository.findAll();
    }

    public Optional<Technology> getById(Long id){
        return technologyRepository.findById(id);
    }

    public Technology createTechnology(Technology tech){
        return technologyRepository.save(tech);
    }

    public void deleteAllTechnology (){
        technologyRepository.deleteAll();
    }

    public void deleteTechnologyById(Long id){
        technologyRepository.deleteById(id);
    }

    public Technology updateTechnology(Technology tech){
        return technologyRepository.save(tech);
    }
}
