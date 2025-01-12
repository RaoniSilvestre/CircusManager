package br.ufrn.imd.circusmanager.Model.Funcionarios;

import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.MagicoEnum;
import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.OcupacaoEnum;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MAGICO")
@NoArgsConstructor
public class Magico extends Funcionario {
    private MagicoEnum tipo;

    public Magico(String nome, double salario, MagicoEnum tipo) {
        super(nome, salario, OcupacaoEnum.MAGICO);
        this.tipo = tipo;
    }

    @Override
    public String getTipoToString() {
        return tipo.toString();
    }
}
