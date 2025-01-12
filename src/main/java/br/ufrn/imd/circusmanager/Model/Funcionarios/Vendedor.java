package br.ufrn.imd.circusmanager.Model.Funcionarios;

import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.OcupacaoEnum;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("VENDEDOR")
@NoArgsConstructor
public class Vendedor extends Funcionario {

    public Vendedor(String nome, double salario) {
        super(nome, salario, OcupacaoEnum.VENDEDOR);
    }

    @Override
    public String getTipoToString() {
        return "Vendedor";
    }
}
