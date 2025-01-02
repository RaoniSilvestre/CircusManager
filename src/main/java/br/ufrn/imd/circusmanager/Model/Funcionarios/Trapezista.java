package br.ufrn.imd.circusmanager.Model.Funcionarios;


import java.util.ArrayList;

import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.OcupacaoEnum;
import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.TrapezistaEnum;

public class Trapezista extends Funcionario{
    ArrayList<String> itensTrapezista;
    private TrapezistaEnum tipo;

    public Trapezista(String nome, double salario, TrapezistaEnum tipo) {
        super(nome, salario);
        this.itensTrapezista = new ArrayList<>();
        this.tipo = tipo;
    }

    public void addItem(String s) {
        itensTrapezista.add(s);
    }
    
    public void deleteItem(String s) {
        itensTrapezista.remove(s);
    }

    public ArrayList<String> getItens() {
        return itensTrapezista;
    }

    @Override
    public String getOcupacao() {
        return OcupacaoEnum.TRAPEZISTA.toString();
    }

    public String getTipo() {
        return tipo.toString();
    }
}
