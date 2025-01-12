package br.ufrn.imd.circusmanager.Model.ContaBancaria;

import br.ufrn.imd.circusmanager.Model.ContaBancaria.Enums.TransacaoEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * The type Transacao.
 */
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

    private TransacaoEnum transacaoEnum;

    private double amount;

    /**
     * Instantiates a new Transacao.
     */
    public Transacao() {
    }

    /**
     * Instantiates a new Transacao.
     *
     * @param transacaoEnum the transacao enum
     * @param amount        the amount
     */
    public Transacao(TransacaoEnum transacaoEnum, double amount) {
        this.transacaoEnum = transacaoEnum;
        this.amount = amount;
    }

    /**
     * Instantiates a new Transacao.
     *
     * @param amount the amount
     */
    public Transacao(double amount) {
        this.amount = amount;
    }
}
