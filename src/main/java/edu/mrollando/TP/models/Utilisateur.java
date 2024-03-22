package edu.mrollando.TP.models;

import com.fasterxml.jackson.annotation.JsonView;
import edu.mrollando.TP.views.UtilisateurView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(UtilisateurView.class)
    protected Integer id;
    protected String pseudo;
    protected String motDePasse;
    protected boolean admin;

    @ManyToOne
    @JoinColumn(name = "role_id")
    @JsonView(UtilisateurView.class)
    protected Role role;

}
