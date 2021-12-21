package com.example.kommunalvalgeksamenbackend.controller;


import com.example.kommunalvalgeksamenbackend.model.Partier;

import com.example.kommunalvalgeksamenbackend.repositories.PartierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/partier")
public class RESTPartier {

    @Autowired
    PartierRepository partierRepository;
    @PostMapping(value = "/save", consumes = "application/json")
    public ResponseEntity<Partier> createpartier(@RequestBody Partier parti){

        partierRepository.save(parti);
        return new ResponseEntity<>(parti, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public List<Partier> displaypartier() {
        return partierRepository.findAll();

    }

    @DeleteMapping("/update/{partiId}")
    public ResponseEntity<Partier> deletepartier(@PathVariable int partiId){
        partierRepository.deleteById(partiId);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/update{partiId}")
    public ResponseEntity<Partier> updatepartier(@PathVariable int partiId, @RequestBody Partier updatedpartier){

        Optional<Partier> optionalObj = partierRepository.findById(partiId);

        Partier myPartiObj = optionalObj.get();

        myPartiObj.setPartiNavn(updatedpartier.getPartiNavn());
        myPartiObj.setPartiId(updatedpartier.getPartiId());

        myPartiObj = partierRepository.save(myPartiObj);
        return new ResponseEntity<>(myPartiObj, HttpStatus.OK);


    }

}
