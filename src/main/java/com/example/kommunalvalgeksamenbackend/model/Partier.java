package com.example.kommunalvalgeksamenbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Partier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int PartiId;
    @OneToMany
    @JoinColumn(name ="parti_id")
    @JsonBackReference
    private Set<Kandidater> kandidater = new HashSet<>();
    private String partiNavn;

    public int getPartiId() {
        return PartiId;
    }

    public void setPartiId(int partiId) {
        PartiId = partiId;
    }

    public String getPartiNavn() {
        return partiNavn;
    }

    public void setPartiNavn(String partiNavn) {
        this.partiNavn = partiNavn;
    }

    public Partier() {
    }

    public Set<Kandidater> getKandidater() {
        return kandidater;
    }

    public void setKandidater(Set<Kandidater> kandidater) {
        this.kandidater = kandidater;
    }
}
