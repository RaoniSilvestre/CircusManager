package br.ufrn.imd.circusmanager.Model.Circus;

public class Circus {
    private int id;
    private int circoId;
    private String nome;


    public Circus(int id, int circoId, String nome) {
        this.id = id;
        this.circoId = circoId;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCircoId() {
        return circoId;
    }

    public void setCircoId(int circoId) {
        this.circoId = circoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
