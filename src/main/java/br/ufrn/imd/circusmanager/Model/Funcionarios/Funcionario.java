package br.ufrn.imd.circusmanager.Model.Funcionarios;

import java.util.ArrayList;

import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.OcupacaoEnum;

public abstract class Funcionario {
    private ArrayList<String> itens;
    private String nome;
    private double salario;
    private OcupacaoEnum ocupacaoEnum;
    
    public abstract String getDescricao();

    Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
        itens = new ArrayList<>();
    }

    public String itensToString() {
        if (!itens.isEmpty()) {
            String itensString = "";
            for (String item : itens){
                itensString += item + ", ";
            }

            return itensString.substring(0, itensString.length()-2);
        }
        return "Nenhum";
    }
    
    public void addItem(String s) {
        itens.add(s);
    }

    public void deleteItem(String s) {
        itens.remove(s);
    }

    public ArrayList<String> getItens() {
        return itens;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}
