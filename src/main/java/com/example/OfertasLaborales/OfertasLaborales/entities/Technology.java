package com.example.OfertasLaborales.OfertasLaborales.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "technologies")
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonBackReference
    @ManyToMany(mappedBy = "technologies", cascade = CascadeType.MERGE)
    private List<Offer> offers = new ArrayList<Offer>();

    //constructors

    public Technology() {
    }

    public Technology(Long id, String name) {
        this.id = id;
        this.name = name;
    }
// getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }
}


