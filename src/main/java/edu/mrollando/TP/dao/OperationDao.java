package edu.mrollando.TP.dao;

import edu.mrollando.TP.models.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OperationDao extends JpaRepository<Operation, Integer> {
    Optional<Operation> findByNom(String nom);

    List<Operation> findByOuvrierPseudo(@Param("pseudo") String pseudo);
}
