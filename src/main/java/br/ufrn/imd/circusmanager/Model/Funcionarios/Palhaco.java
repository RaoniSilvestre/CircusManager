package br.ufrn.imd.circusmanager.Model.Funcionarios;

import java.util.ArrayList;

import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.PalhacosEnum;

public class Palhaco extends Funcionario{
    public ArrayList<String> itensPalhaco;
    private PalhacosEnum tipo;

    public Palhaco(String nome, double salario, PalhacosEnum tipo) {
        super(nome, salario);
        this.itensPalhaco = new ArrayList<>();
        this.tipo = tipo;
    }

    public void addItem(String s) {
        itensPalhaco.add(s);
    }

    public void deleteItem(String s) {
        itensPalhaco.remove(s);
    }

    //getters
    public ArrayList<String> getItens() {
        return itensPalhaco;
    }

    public PalhacosEnum getTipo() {
        return tipo;
    }
}
