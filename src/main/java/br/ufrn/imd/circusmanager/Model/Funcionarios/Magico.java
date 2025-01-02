package br.ufrn.imd.circusmanager.Model.Funcionarios;

import java.util.ArrayList;

import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.MagicoEnum;

public class Magico extends Funcionario {
    ArrayList<String> itensMagico;
    private MagicoEnum tipo;

    public Magico(String nome, double salario, MagicoEnum tipo) {
        super(nome, salario);
        this.itensMagico = new ArrayList<>();
        this.tipo = tipo;
    }

    public void addItem(String s) {
        itensMagico.add(s);
    }

    public void deleteItem(String s) {
        itensMagico.remove(s);
    }


    @Override
    public String getOcupação() {
        return "";
    }

    // getters
    public ArrayList<String> getItens() {
        return itensMagico;
    }

    public MagicoEnum getTipo() {
        return tipo;
    }
}
