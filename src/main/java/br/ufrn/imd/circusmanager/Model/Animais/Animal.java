package br.ufrn.imd.circusmanager.Model.Animais;

public class Animal {
    private String nome;
    private Long valorManutencao;
    private AnimaisEnum tipo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getValorManutencao() {
        return valorManutencao;
    }

    public void setValorManutencao(Long valorManutencao) {
        this.valorManutencao = valorManutencao;
    }

    public AnimaisEnum getTipo() {
        return tipo;
    }

    public void setTipo(AnimaisEnum tipo) {
        this.tipo = tipo;
    }
}
