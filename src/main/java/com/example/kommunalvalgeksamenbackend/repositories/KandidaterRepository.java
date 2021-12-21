package com.example.kommunalvalgeksamenbackend.repositories;

import com.example.kommunalvalgeksamenbackend.model.Kandidater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KandidaterRepository extends JpaRepository<Kandidater, Integer> {
}
