package br.ufrn.imd.circusmanager.Model.Circus;

import br.ufrn.imd.circusmanager.Model.Animais.Animal;
import br.ufrn.imd.circusmanager.Model.ContaBancaria.Conta;
import br.ufrn.imd.circusmanager.Model.Funcionarios.Funcionario;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Circo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String nome;

    @OneToOne(mappedBy = "circo")
    private Conta conta;

    @OneToMany(mappedBy = "circo")
    private Set<Show> shows;

    @OneToMany(mappedBy = "circo")
    private Set<Animal> animais;

    @OneToMany(mappedBy = "circo")
    private Set<Funcionario> funcionarios;

    public Circo(String nome) {
        this.nome = nome;
    }
}

