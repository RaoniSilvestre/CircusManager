package br.ufrn.imd.circusmanager.Model.Circus;

import br.ufrn.imd.circusmanager.Model.Animais.Animal;
import br.ufrn.imd.circusmanager.Model.ContaBancaria.Conta;
import br.ufrn.imd.circusmanager.Model.Funcionarios.Funcionario;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * The type Circo.
 */
@Entity
@Getter
@Setter
public class Circo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String nome;

    @OneToOne(mappedBy = "circo", cascade = CascadeType.ALL)
    private Conta conta;

    @OneToMany(mappedBy = "circo", cascade = CascadeType.ALL)
    private List<Show> shows;

    @OneToMany(mappedBy = "circo", cascade = CascadeType.ALL)
    private List<Animal> animais;

    @OneToMany(mappedBy = "circo", cascade = CascadeType.ALL)
    private List<Funcionario> funcionarios;

    /**
     * Instantiates a new Circo.
     */
    public Circo() {
    }

    /**
     * Instantiates a new Circo.
     *
     * @param nome the nome
     */
    public Circo(String nome) {
        this.nome = nome;
    }
}

