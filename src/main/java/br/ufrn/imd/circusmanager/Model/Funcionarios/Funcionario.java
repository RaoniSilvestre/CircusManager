package br.ufrn.imd.circusmanager.Model.Funcionarios;

import br.ufrn.imd.circusmanager.Model.Circus.Circo;
import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.OcupacaoEnum;
import br.ufrn.imd.circusmanager.Model.Itens.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public abstract class Funcionario {

    protected OcupacaoEnum ocupacao;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private double salario;

    @ManyToOne
    @JoinColumn(name = "circo_id")
    private Circo circo;

    @OneToMany(mappedBy = "funcionario")
    private Set<Item> itens;


    Funcionario(String nome, double salario, OcupacaoEnum ocupacao, Set<Item> itens) {
        this.nome = nome;
        this.salario = salario;
        this.ocupacao = ocupacao;
        this.itens = itens;
    }

    public String getDescricao() {
        return String.format("%s - Ocupação: %s - Salario: %s", getNome(), getOcupacacao().toString(), getSalario());
    }

    public OcupacaoEnum getOcupacacao() {
        return this.ocupacao;
    }
}
