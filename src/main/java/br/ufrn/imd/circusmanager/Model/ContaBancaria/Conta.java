package br.ufrn.imd.circusmanager.Model.ContaBancaria;

import br.ufrn.imd.circusmanager.Model.Circus.Circo;

import javax.persistence.*;

@Entity
public class ContaCirco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "circo_id")
    private Circo circo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
