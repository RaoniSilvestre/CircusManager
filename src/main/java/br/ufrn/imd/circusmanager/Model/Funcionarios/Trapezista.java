package br.ufrn.imd.circusmanager.Model.Funcionarios;

import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.TrapezistaEnum;

public class Trapezista extends Funcionario{
    private TrapezistaEnum tipo;

    public Trapezista(String nome, double salario, TrapezistaEnum tipo) {
        super(nome, salario);
        this.tipo = tipo;
    }


    public  String getTipo() {
        return  this.tipo.toString();
    }
}
