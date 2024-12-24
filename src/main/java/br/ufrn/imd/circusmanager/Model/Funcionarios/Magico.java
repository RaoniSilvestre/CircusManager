package br.ufrn.imd.circusmanager.Model.Funcionarios;

import java.util.ArrayList;

public class Magico extends Funcionario {
    ArrayList<String> itensMagico;

    public Magico(String nome, double salario) {
        super(nome, salario);
        this.itensMagico = new ArrayList<>();
    }

    public void addItem(String s) {
        itensMagico.add(s);
    }

    public void deleteItem(String s) {
        itensMagico.remove(s);
    }
}
