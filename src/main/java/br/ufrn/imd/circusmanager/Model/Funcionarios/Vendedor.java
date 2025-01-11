package br.ufrn.imd.circusmanager.Model.Funcionarios;

import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.OcupacaoEnum;

public class Vendedor extends Funcionario {

    public Vendedor(String nome, double salario){
        super(nome, salario, OcupacaoEnum.VENDEDOR);
    }

    public String getTipo() {
        return "Vendedor";
    }

}
