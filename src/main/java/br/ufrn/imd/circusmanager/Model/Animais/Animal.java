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

    private String nome;

    private double custo;

    private AnimalEnum tipo;

    @ManyToOne
    @JoinColumn(name = "circo_id", referencedColumnName = "id")
    private Circo circo;

    public Animal() {
    }

    public Animal(String nome, double custo, AnimalEnum tipo) {
        this.nome = nome;
        this.custo = custo;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s ; Espécie: %s ; Custo: R$ %.2f", nome, tipo, custo);
    }

}
