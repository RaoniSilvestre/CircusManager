package br.ufrn.imd.circusmanager.Model.ContaBancaria;

import br.ufrn.imd.circusmanager.Model.ContaBancaria.Enums.TransacaoEnum;

public class Transacao {
    private String nome;
    private TransacaoEnum tipo;
    private long valor;

    
    public Transacao(String nome, TransacaoEnum tipo, long valor) {
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TransacaoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TransacaoEnum tipo) {
        this.tipo = tipo;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }
}
