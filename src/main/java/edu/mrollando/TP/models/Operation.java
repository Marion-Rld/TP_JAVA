package edu.mrollando.TP.models;

import com.fasterxml.jackson.annotation.JsonView;
import edu.mrollando.TP.views.ChantierView;
import edu.mrollando.TP.views.OperationView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({ChantierView.class, OperationView.class})
    protected Integer id;

    @JsonView({ChantierView.class, OperationView.class})
    protected String nom;

    @JsonView({ChantierView.class, OperationView.class})
    protected LocalDate date;

    @ManyToOne
    @JoinColumn(name = "chantier_id")
    @JsonView(OperationView.class)
    protected Chantier chantier;

    @ManyToOne
    @JoinColumn(name = "tache_id")
    @JsonView(OperationView.class)
    protected Tache tache;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    @JsonView(OperationView.class)
    protected Utilisateur ouvrier; // Assume Utilisateur is the entity representing a worker
}
