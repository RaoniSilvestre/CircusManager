package br.ufrn.imd.circusmanager.Model.ContaBancaria;

import br.ufrn.imd.circusmanager.Model.Circus.Circo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Conta.
 */
@Entity
@Getter
@Setter
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    @JoinColumn(name = "circo_id", referencedColumnName = "id")
    private Circo circo;

    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Transacao> transacoes = new ArrayList<>();

    /**
     * Instantiates a new Conta.
     */
    public Conta() {
    }

    /**
     * Instantiates a new Conta.
     *
     * @param circo the circo
     */
    public Conta(Circo circo) {
        this.circo = circo;
    }

    /**
     * Add transacao.
     *
     * @param t the t
     */
    public void addTransacao(Transacao t) {
        this.transacoes.add(t);
    }

    /**
     * Calcular saldo double.
     *
     * @return the double
     */
    public double calcularSaldo() {
        transacoes.size();
        return transacoes.stream().map(Transacao::getAmount).reduce(0.0, Double::sum);
    }

}
