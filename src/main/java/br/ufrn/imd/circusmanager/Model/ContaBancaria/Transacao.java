package br.ufrn.imd.circusmanager.Model.ContaBancaria;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "conta_id", referencedColumnName = "id", nullable = false)
    private Conta conta;

    private double amount;

    public Transacao() {
    }

    public Transacao(Conta conta, double amount) {
        this.conta = conta;
        this.amount = amount;
    }
}
