package edu.mrollando.TP.dao;

import edu.mrollando.TP.models.Chantier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChantierDao extends JpaRepository<Chantier, Integer> {
    Optional<Chantier> findByNom(String nom);

    @Query("SELECT SUM(t.temps) FROM Chantier c JOIN c.operations o JOIN o.tache t WHERE c.id = :chantierId")
    Optional<Integer> calculerTempsTotalPourChantier(@Param("chantierId") Integer chantierId);
}
