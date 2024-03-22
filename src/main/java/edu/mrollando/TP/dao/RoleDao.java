package edu.mrollando.TP.dao;

import edu.mrollando.TP.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleDao extends JpaRepository<Role, Integer>{
    Optional<Role> findByDesignation(String designation);
}
