package br.ufrn.imd.circusmanager.Model.Circus;

import br.ufrn.imd.circusmanager.Model.ContaBancaria.ContaCirco;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class Circus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    @OneToOne(mappedBy = "circo")
    private ContaCirco conta;


    public Circus(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCircoId() {
        return circoId;
    }

    public void setCircoId(int circoId) {
        this.circoId = circoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
