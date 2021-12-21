package com.example.kommunalvalgeksamenbackend.repositories;

import com.example.kommunalvalgeksamenbackend.model.Partier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartierRepository extends JpaRepository<Partier, Integer> {
}
