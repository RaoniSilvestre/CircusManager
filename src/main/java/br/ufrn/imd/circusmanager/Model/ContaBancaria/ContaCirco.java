package br.ufrn.imd.circusmanager.Model.ContaBancaria;

import java.util.ArrayList;

public class ContaCirco {
    private ArrayList<Transacao> transacoes;
    private Long balanco;

    public ContaCirco() {
        this.transacoes = new ArrayList<>();
    }

    public void addTransacao(Transacao t) {
        transacoes.add(t);
        balanco+= t.getValor();
    }
}
