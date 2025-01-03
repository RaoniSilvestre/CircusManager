package br.ufrn.imd.circusmanager.Model.Animais;

public class Animal {
    private String nome;
    private Double valorManutencao;
    private AnimalEnum tipo;

    public Animal(String nome, Double valorManutencao, AnimalEnum tipo) {
        this.nome = nome;
        this.valorManutencao = valorManutencao;
        this.tipo = tipo;
    }

    public String getDescricao() {
        return String.format("%s - Especie: %s - Custo: %s", getNome(), getTipo().toString(), getValorManutencao());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValorManutencao() {
        return valorManutencao;
    }

    public void setValorManutencao(Double valorManutencao) {
        this.valorManutencao = valorManutencao;
    }

    public AnimalEnum getTipo() {
        return tipo;
    }

    public void setTipo(AnimalEnum tipo) {
        this.tipo = tipo;
    }
}
