package br.ufrn.imd.circusmanager.Model.Funcionarios;

import java.util.ArrayList;

public class Palhaco extends Funcionario{
    public ArrayList<String> itensPalhaco;

    public Palhaco(String nome, double salario) {
        super(nome, salario);
        this.itensPalhaco = new ArrayList<>();
    }

    public void addItem(String s) {
        itensPalhaco.add(s);
    }

    public void deleteItem(String s) {
        itensPalhaco.remove(s);
    }


}
