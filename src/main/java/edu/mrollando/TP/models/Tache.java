package edu.mrollando.TP.models;

import com.fasterxml.jackson.annotation.JsonView;
import edu.mrollando.TP.views.TacheView;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
public class Tache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(TacheView.class)
    protected Integer id;

    @JsonView(TacheView.class)
    @NotNull(message = "Le nom de la tâche ne peut pas être null")
    @NotBlank(message = "Le nom de la tâche ne peut pas être vide" )
    protected String nom;

    @JsonView(TacheView.class)
    protected int temps;

    @ManyToMany
    @JoinTable(
            name = "tache_consommable",
            joinColumns = @JoinColumn(name = "tache_id"),
            inverseJoinColumns = @JoinColumn(name = "consommable_id")
    )
    @JsonView(TacheView.class)
    protected Set<Consommable> consommables;
}
