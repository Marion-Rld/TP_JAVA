package edu.mrollando.TP.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import edu.mrollando.TP.dao.ChantierDao;
import edu.mrollando.TP.models.Chantier;
import edu.mrollando.TP.views.ChantierView;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ChantierController {

    @Autowired
    ChantierDao chantierDao;

    @GetMapping("/chantier/list")
    @PreAuthorize("hasAuthority('ROLE_CHEF')")
    @JsonView(ChantierView.class)
    public List<Chantier> liste() {

        List<Chantier> chantierList = chantierDao.findAll();

        return chantierList;
    }

    @GetMapping("/chantier/{id}/temps-total")
    @PreAuthorize("hasAuthority('ROLE_CHEF')")
    public ResponseEntity<?> getTempsTotal(@PathVariable Integer id) {
        Optional<Integer> tempsTotalOptional = chantierDao.calculerTempsTotalPourChantier(id);
        if (tempsTotalOptional.isPresent()) {
            return ResponseEntity.ok(tempsTotalOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
