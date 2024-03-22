package edu.mrollando.TP.controllers;

import edu.mrollando.TP.dao.OperationDao;
import edu.mrollando.TP.models.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class OperationController {

    @Autowired
    OperationDao operationDao;

    @GetMapping("/operations/ouvrier/{ouvrierPseudo}")
    @PreAuthorize("hasAuthority('ROLE_CHEF') or hasAuthority('ROLE_OUVRIER')")
    public ResponseEntity<List<Operation>> getOperationsPourUnOuvrier(@PathVariable String ouvrierPseudo, Principal principal) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean estChef = authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_CHEF"));

        if (!estChef && !principal.getName().equals(ouvrierPseudo)) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        List<Operation> operations = operationDao.findByOuvrierPseudo(ouvrierPseudo);
        if (operations.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(operations);

    }
}
