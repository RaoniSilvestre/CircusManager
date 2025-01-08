package br.ufrn.imd.circusmanager.Model.Circus;

import java.time.LocalDate;

public class Show {
    private String nome;
    private int totalDeVisitantes;
    private int pipocasVendidas;
    private int algodoesDocesVendidos;
    private int brinquedosVendidos;
    private double custosTotais;
    private double lucro;
    private LocalDate data;

    public Show(String nome, int totalDeVisitantes, int pipocasVendidas, int algodoesDocesVendidos,
            int brinquedosVendidos, double custosTotais, double lucro, LocalDate data) {
        this.nome = nome;
        this.totalDeVisitantes = totalDeVisitantes;
        this.pipocasVendidas = pipocasVendidas;
        this.algodoesDocesVendidos = algodoesDocesVendidos;
        this.brinquedosVendidos = brinquedosVendidos;
        this.custosTotais = custosTotais;
        this.lucro = lucro;
        this.data = data;
    }

    public String getDescricao() {
        return (nome + " - Visitantes: " + totalDeVisitantes + " - Custos: "+ custosTotais + " - Lucro: " + lucro + " - Data: " + data.toString());
    }
    
    public int getTotalDeVisitantes() {
        return totalDeVisitantes;
    }
    public void setTotalDeVisitantes(int totalDeVisitantes) {
        this.totalDeVisitantes = totalDeVisitantes;
    }
    public int getPipocasVendidas() {
        return pipocasVendidas;
    }
    public void setPipocasVendidas(int pipocasVendidas) {
        this.pipocasVendidas = pipocasVendidas;
    }
    public int getAlgodoesDocesVendidos() {
        return algodoesDocesVendidos;
    }
    public void setAlgodoesDocesVendidos(int algodoesDocesVendidos) {
        this.algodoesDocesVendidos = algodoesDocesVendidos;
    }
    public int getBrinquedosVendidos() {
        return brinquedosVendidos;
    }
    public void setBrinquedosVendidos(int brinquedosVendidos) {
        this.brinquedosVendidos = brinquedosVendidos;
    }
    public double getCustosTotais() {
        return custosTotais;
    }
    public void setCustosTotais(double custosTotais) {
        this.custosTotais = custosTotais;
    }
    public double getLucro() {
        return lucro;
    }
    public void setLucro(double lucro) {
        this.lucro = lucro;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    
}
