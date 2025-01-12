package br.ufrn.imd.circusmanager.Model.Funcionarios;

import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.OcupacaoEnum;
import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.TrapezistaEnum;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TRAPEZISTA")
@NoArgsConstructor
public class Trapezista extends Funcionario {
    private TrapezistaEnum tipo;

    public Trapezista(String nome, double salario, TrapezistaEnum tipo) {
        super(nome, salario, OcupacaoEnum.TRAPEZISTA);
        this.tipo = tipo;
    }

    @Override
    public String getTipoToString() {
        return tipo.toString();
    }
}
