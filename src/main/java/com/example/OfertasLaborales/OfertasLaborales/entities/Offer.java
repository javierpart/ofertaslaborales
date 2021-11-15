package com.example.OfertasLaborales.OfertasLaborales.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "offers")
public class Offer {

    //atributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String position;
    private String description;
    private Integer salary;
    @JsonManagedReference
    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.ALL})
    @JoinTable(name="rel_technologies-offers",
            joinColumns = @JoinColumn(name = "fk_offers"),
            inverseJoinColumns = @JoinColumn(name = "fk_technologies")
    )
    private List<Technology> technologies = new ArrayList<Technology>();

    //constructors

    public Offer() {
    }

    public Offer(Long id, String companyName, String position, String description, Integer salary) {
        this.id = id;
        this.companyName = companyName;
        this.position = position;
        this.description = description;
        this.salary = salary;
    }

    //getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public List<Technology> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<Technology> technologies) {
        this.technologies = technologies;
    }
}
