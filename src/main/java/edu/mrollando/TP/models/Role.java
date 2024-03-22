package edu.mrollando.TP.models;

import com.fasterxml.jackson.annotation.JsonView;
import edu.mrollando.TP.views.RoleView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(RoleView.class)
    protected Integer id;

    @JsonView(RoleView.class)
    protected String designation;

    @OneToMany(mappedBy = "role")
    @JsonView(RoleView.class)
    protected Set<Utilisateur> utilisateurs;

}
