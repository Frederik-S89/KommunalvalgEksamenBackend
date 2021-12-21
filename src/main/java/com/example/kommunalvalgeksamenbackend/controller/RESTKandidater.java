package com.example.kommunalvalgeksamenbackend.controller;

import com.example.kommunalvalgeksamenbackend.model.Kandidater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.kommunalvalgeksamenbackend.repositories.KandidaterRepository;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/kandidater")
public class RESTKandidater {

    @Autowired
    KandidaterRepository kandidaterRepository;

    @PostMapping(value = "/save", consumes = "application/json")
    public ResponseEntity<Kandidater> createKandidater(@RequestBody Kandidater kandidater){

        kandidaterRepository.save(kandidater);
        return new ResponseEntity<>(kandidater, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public List<Kandidater> displayKandidater() {
        return kandidaterRepository.findAll();

    }

    @DeleteMapping("/update/{kandidatId}")
    public ResponseEntity<Kandidater> deleteKandidater(@PathVariable int kandidatId){
        kandidaterRepository.deleteById(kandidatId);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/update{kandidatId}")
    public ResponseEntity<Kandidater> updateKandidater(@PathVariable int kandidatId, @RequestBody Kandidater updatedKandidater){

        Optional<Kandidater> optionalObj = kandidaterRepository.findById(kandidatId);

        Kandidater myKandidatObj = optionalObj.get();

        myKandidatObj.setKandidatNavn(updatedKandidater.getKandidatNavn());
        myKandidatObj.setKandidatId(updatedKandidater.getKandidatId());

        myKandidatObj = kandidaterRepository.save(myKandidatObj);
        return new ResponseEntity<>(myKandidatObj, HttpStatus.OK);


    }

}
