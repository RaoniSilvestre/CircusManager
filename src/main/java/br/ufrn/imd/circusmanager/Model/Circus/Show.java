package br.ufrn.imd.circusmanager.Model.Circus;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private double gasto;

    private double ganho;

    @ManyToOne
    @JoinColumn(name = "circo_id", referencedColumnName = "id")
    private Circo circo;

    public Show() {
    }
}
