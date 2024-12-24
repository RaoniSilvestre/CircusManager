package br.ufrn.imd.circusmanager.Model.Itens;

public class Item {
    private String nome;
    private Long valor;

    protected Item(String nome, Long valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
