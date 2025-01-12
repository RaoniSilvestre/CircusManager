package br.ufrn.imd.circusmanager.Model.Funcionarios;

import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.OcupacaoEnum;
import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.PalhacoEnum;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PALHACO")
@NoArgsConstructor
public class Palhaco extends Funcionario {
    private PalhacoEnum tipo;

    public Palhaco(String nome, double salario, PalhacoEnum tipo) {
        super(nome, salario, OcupacaoEnum.PALHACO);
        this.tipo = tipo;
    }

}
