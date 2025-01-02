package br.ufrn.imd.circusmanager.Model.Funcionarios;

public class Vendedor extends Funcionario {

    public Vendedor(String nome, double salario){
        super(nome, salario);
    }

    public String getDescricao() {
        return String.format("%s - Ocupação: %s - Salario: %s - Itens: %s", getNome(), "Vendendor",  getSalario(), itensToString());
    }

}
