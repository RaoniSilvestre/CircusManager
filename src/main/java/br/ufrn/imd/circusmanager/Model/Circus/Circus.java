package br.ufrn.imd.circusmanager.Model.Circus;

import br.ufrn.imd.circusmanager.Dao.*;
import br.ufrn.imd.circusmanager.Model.ContaBancaria.ContaCirco;
import br.ufrn.imd.circusmanager.Model.ContaBancaria.Transacao;
import br.ufrn.imd.circusmanager.Model.ContaBancaria.Enums.TransacaoEnum;

public class Circus {
    private String nome;
    private ContaCirco conta;
    private FuncionarioDAO listaDeFuncionarios;
    private AnimalDAO listaDeAnimais;
    private ShowDAO listaDeShows;
    

    public Circus(String nome, double saldo) {
        this.nome = nome;
        conta = new ContaCirco();

        Transacao transacaoInicial = new Transacao("Fundação", TransacaoEnum.FUNDACAO, saldo);

        conta.addTransacao(transacaoInicial);

        listaDeAnimais = new AnimalDAO();
        listaDeFuncionarios = new FuncionarioDAO();
        listaDeShows = new ShowDAO();
    }

    public String getNome() {
        return nome;
    }

    public ContaCirco getConta() {
        return conta;
    }

    public FuncionarioDAO getListaDeFuncionarios() {
        return listaDeFuncionarios;
    }

    public AnimalDAO getListaDeAnimais() {
        return listaDeAnimais;
    }

    public ShowDAO getListaDeShows() {
        return listaDeShows;
    }
}
