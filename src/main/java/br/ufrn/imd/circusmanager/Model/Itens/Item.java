package br.ufrn.imd.circusmanager.Model.Itens;

import br.ufrn.imd.circusmanager.Model.Funcionarios.Funcionario;
import br.ufrn.imd.circusmanager.Model.Itens.Enums.ItemEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * The type Item.
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private ItemEnum tipo;

    private double valor;

    @ManyToOne
    @JoinColumn(name = "funcionario_id", referencedColumnName = "id")
    private Funcionario funcionario;

    /**
     * Instantiates a new Item.
     *
     * @param tipo  the tipo
     * @param valor the valor
     */
    public Item(ItemEnum tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return tipo.toString() + " (R$ " + valor + ")";
    }
}
