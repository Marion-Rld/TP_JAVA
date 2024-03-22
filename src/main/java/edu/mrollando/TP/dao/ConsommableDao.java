package edu.mrollando.TP.dao;

import edu.mrollando.TP.models.Consommable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConsommableDao extends JpaRepository<Consommable, Integer> {
    Optional<Consommable> findByNom(String nom);
}
