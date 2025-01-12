package br.ufrn.imd.circusmanager.Model.ContaBancaria;

import br.ufrn.imd.circusmanager.Model.Circus.Circo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    public Conta() {
    }

    public Conta(Circo circo) {
        this.circo = circo;
    }

    public void addTransacao(Transacao t) {
        this.transacoes.add(t);
    }

    public double calcularSaldo() {
        transacoes.size();
        return transacoes.stream().map(Transacao::getAmount).reduce(0.0, Double::sum);
    }

}
