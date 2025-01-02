package br.ufrn.imd.circusmanager.Model.ContaBancaria;

import java.util.ArrayList;

public class ContaCirco {
    private ArrayList<Transacao> transacoes;
    private double balanco = 0;

    public ContaCirco() {
        this.transacoes = new ArrayList<>();
    }

    public void addTransacao(Transacao t) {
        transacoes.add(t);
        balanco+= t.getValor();
    }

    public double getBalanco() {
        return balanco;
    }

    public ArrayList<Transacao> getTransacoes() {
        return transacoes;
    }
    
}
