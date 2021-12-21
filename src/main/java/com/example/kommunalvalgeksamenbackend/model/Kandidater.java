package com.example.kommunalvalgeksamenbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.query.criteria.internal.predicate.PredicateImplementor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Kandidater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int kandidatId;
    @ManyToOne
    @JoinColumn(name ="parti_id")
    private Partier partier;
    private String kandidatNavn;

    public int getKandidatId() {
        return kandidatId;
    }

    public void setKandidatId(int kandidatId) {
        this.kandidatId = kandidatId;
    }

    public String getKandidatNavn() {
        return kandidatNavn;
    }

    public void setKandidatNavn(String kandidatNavn) {
        this.kandidatNavn = kandidatNavn;
    }

    public Kandidater() {
    }

    public Partier getPartier() {
        return partier;
    }

    public void setPartier(Partier partier) {
        this.partier = partier;
    }
}
