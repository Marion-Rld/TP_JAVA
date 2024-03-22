package edu.mrollando.TP.models;

import com.fasterxml.jackson.annotation.JsonView;
import edu.mrollando.TP.views.ChantierView;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
public class Chantier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(ChantierView.class)
    protected Integer id;

    @JsonView(ChantierView.class)
    @NotNull(message = "Le nom du chantier ne peut pas être vide.")
    @NotBlank(message = "Le nom du chantier ne peut pas être vide.")
    @Size(max = 100, message = "Le nom du chantier ne peut pas dépasser 100 caractères.")
    protected String nom;

    @JsonView(ChantierView.class)
    @NotBlank(message = "L'adresse du chantier ne peut pas être vide.")
    @Size(max = 200, message = "L'adresse du chantier ne peut pas dépasser 200 caractères.")
    protected String adresse;

    @OneToMany(mappedBy = "chantier")
    @JsonView(ChantierView.class)
    protected Set<Operation> operations;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonView(ChantierView.class)
    protected Utilisateur client;

    @ManyToOne
    @JoinColumn(name = "chef_id")
    @JsonView(ChantierView.class)
    protected Utilisateur chef;
}
