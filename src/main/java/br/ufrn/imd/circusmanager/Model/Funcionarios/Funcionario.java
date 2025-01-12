package br.ufrn.imd.circusmanager.Model.Funcionarios;

import br.ufrn.imd.circusmanager.Model.Circus.Circo;
import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.OcupacaoEnum;
import br.ufrn.imd.circusmanager.Model.Itens.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor
@DiscriminatorColumn(name = "tipo_funcionario", discriminatorType = DiscriminatorType.STRING)
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

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
    private List<Item> itens = new ArrayList<>();


    Funcionario(String nome, double salario, OcupacaoEnum ocupacao) {
        this.nome = nome;
        this.salario = salario;
        this.ocupacao = ocupacao;
    }

    @Override
    public String toString() {
        return String.format("Id: %d ; Nome: %s, Salario: R$%.2f ; Ocupacao: %s ; Itens: %d",
                id, nome, salario, ocupacao, itens.size());
    }
}
