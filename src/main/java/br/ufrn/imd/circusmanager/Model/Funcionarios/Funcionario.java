package br.ufrn.imd.circusmanager.Model.Funcionarios;

import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.OcupacaoEnum;
import br.ufrn.imd.circusmanager.Model.Itens.Item;

import java.util.ArrayList;

public abstract class Funcionario {
    private ArrayList<Item> itens;
    private String nome;
    private double salario;
    protected OcupacaoEnum ocupacao;
    

    Funcionario(String nome, double salario, OcupacaoEnum ocupacao) {
        this.nome = nome;
        this.salario = salario;
        this.ocupacao = ocupacao;
        itens = new ArrayList<>();
    }

    public String itensToString() {
        if (!itens.isEmpty()) {
            StringBuilder itensString = new StringBuilder();
            for (Item item : itens){
                itensString.append(item).append(", ");
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

    public void addItem(Item i) {
        itens.add(i);
    }

    public void deleteItem(Item i) {
        itens.remove(i);
    }

    public ArrayList<Item> getItens() {
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
