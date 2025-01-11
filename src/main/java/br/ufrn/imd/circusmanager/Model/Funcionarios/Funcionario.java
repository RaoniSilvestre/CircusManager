package br.ufrn.imd.circusmanager.Model.Funcionarios;

import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.OcupacaoEnum;

import java.util.ArrayList;

public abstract class Funcionario {
    private ArrayList<String> itens;
    private String nome;
    private double salario;
    private OcupacaoEnum ocupacao;
    

    Funcionario(String nome, double salario, OcupacaoEnum ocupacao) {
        this.nome = nome;
        this.salario = salario;
        this.ocupacao = ocupacao;
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

    public String getDescricao() {
        return String.format("%s - Ocupação: %s - Tipo: %s - Salario: %s - Itens: %s.", getNome(), getOcupacacao().toString(), getTipo(), getSalario(), itensToString());
    }

    public OcupacaoEnum getOcupacacao() {
        return this.ocupacao;
    }

    public abstract String getTipo();
    
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
