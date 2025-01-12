package br.ufrn.imd.circusmanager.Model.Funcionarios;

import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.OcupacaoEnum;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * The type Vendedor.
 */
@Entity
@DiscriminatorValue("VENDEDOR")
@NoArgsConstructor
public class Vendedor extends Funcionario {

    /**
     * Instantiates a new Vendedor.
     *
     * @param nome    the nome
     * @param salario the salario
     */
    public Vendedor(String nome, double salario) {
        super(nome, salario, OcupacaoEnum.VENDEDOR);
    }

    /**
     * Gets tipo.
     *
     * @return the tipo
     */
    public String getTipo() {
        return "Vendedor";
    }

}
