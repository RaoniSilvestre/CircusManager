package br.ufrn.imd.circusmanager.Model.Funcionarios;


import java.util.ArrayList;

public class Trapezista extends Funcionario{
    ArrayList<String> itensTrapezista;

    Trapezista(String nome, double salario) {
        super(nome, salario);
        this.itensTrapezista = new ArrayList<>();
    }

    public void addItem(String s) {
        itensTrapezista.add(s);
    }
    
    public void deleteItem(String s) {
        itensTrapezista.remove(s);
    }
}
