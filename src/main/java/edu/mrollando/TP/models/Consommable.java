package edu.mrollando.TP.models;

import com.fasterxml.jackson.annotation.JsonView;
import edu.mrollando.TP.views.ConsommableView;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Consommable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(ConsommableView.class)
    protected Integer id;

    @JsonView(ConsommableView.class)
    protected String nom;
}
