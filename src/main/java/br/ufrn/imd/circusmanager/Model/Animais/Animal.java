package br.ufrn.imd.circusmanager.Model.Animais;

import br.ufrn.imd.circusmanager.Model.Circus.Circo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private double custo;

    private String tipo;

    @ManyToOne
    @JoinColumn(name = "circo_id", referencedColumnName = "id")
    private Circo circo;

    Animal() {
    }
}
