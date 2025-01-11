package br.ufrn.imd.circusmanager.Model.Funcionarios;

import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.OcupacaoEnum;
import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.PalhacoEnum;

public class Palhaco extends Funcionario{
    private PalhacoEnum tipo;

    public Palhaco(String nome, double salario, PalhacoEnum tipo) {
        super(nome, salario, OcupacaoEnum.PALHACO);
        this.tipo = tipo;
        this.ocupacao = OcupacaoEnum.PALHACO;
    }


    public String getTipo() {
        return tipo.toString();
    }
}
