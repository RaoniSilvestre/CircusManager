package br.ufrn.imd.circusmanager.Model.Funcionarios;

import java.util.ArrayList;

import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.MagicoEnum;
import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.OcupacaoEnum;

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
    public String getOcupacao() {
        return OcupacaoEnum.MAGICO.toString();
    }

    // getters
    public ArrayList<String> getItens() {
        return itensMagico;
    }

    public String getTipo() {
        return tipo.toString();
    }
}
