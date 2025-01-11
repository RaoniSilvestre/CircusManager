package br.ufrn.imd.circusmanager.Model.Circus;

import br.ufrn.imd.circusmanager.Dao.*;
import br.ufrn.imd.circusmanager.Model.Animais.Animal;
import br.ufrn.imd.circusmanager.Model.ContaBancaria.ContaCirco;
import br.ufrn.imd.circusmanager.Model.ContaBancaria.Transacao;
import br.ufrn.imd.circusmanager.Model.ContaBancaria.Enums.TransacaoEnum;
import br.ufrn.imd.circusmanager.Model.Funcionarios.Funcionario;
import br.ufrn.imd.circusmanager.Model.Funcionarios.Vendedor;
import br.ufrn.imd.circusmanager.Model.Itens.Vendedores;

import java.util.ArrayList;
import java.util.List;

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

    public double getCustoFuncionarios() {
        double custoDosFuncionarios = 0.0;

        for (Funcionario funcionario : this.getListaDeFuncionarios()) {
            custoDosFuncionarios += funcionario.getSalario();
        }

        return custoDosFuncionarios;
    }

    public int getQuantidadeAnimadores() {
        return this.getListaDeFuncionarios().size();
    }

    public double getCustoAnimais() {
        return this.getListaDeAnimais()
                .stream()
                .map(Animal::getValorManutencao)
                .reduce(0.0, Double::sum);
    }

    public Vendedores getVendedores() {
        int vendedorDePipoca = 0;
        int vendedorDeAlgodaoDoce = 0;
        int vendedorDeBrinquedo = 0;

        List<Vendedor> vendedores = this.getListaDeFuncionarios()
                .stream()
                .filter(f -> f instanceof Vendedor)
                .map(f -> (Vendedor) f)
                .toList();

        for (Vendedor vendedor : vendedores) {
            Vendedores v = vendedor.getVendedores();

            vendedorDePipoca += v.vendedoresDePipoca();
            vendedorDeAlgodaoDoce = v.vendedoresDeAlgodaoDoce();
            vendedorDeBrinquedo = v.vendedoresDeBrinquedo();
        }

        return new Vendedores(vendedorDePipoca, vendedorDeAlgodaoDoce, vendedorDeBrinquedo);
    }

    public void editarSaldo(double valor) {

        double valorAtingo = conta.getBalanco();

        double valorDaTransacao =  valor - valorAtingo;
        
        conta.addTransacao(new Transacao("Edição", TransacaoEnum.INDEFINIDO, valorDaTransacao));
    }

    public String getNome() {
        return nome;
    }

    public ContaCirco getConta() {
        return conta;
    }

    public ArrayList<Funcionario> getListaDeFuncionarios() {
        return listaDeFuncionarios.getFuncionarios();
    }

    public void deleteFuncionario(Funcionario f) {
        this.listaDeFuncionarios.deleteFuncionario(f);
    }

    public void addAnimal(Animal a) {
        listaDeAnimais.addAnimal(a);
    }

    public ArrayList<Animal> getListaDeAnimais() {
        return listaDeAnimais.getAnimais();
    }

    public void deleteAnimal(Animal a) {
        listaDeAnimais.deleteAnimal(a);
    }

    public void addFuncionario(Funcionario f) {
        this.listaDeFuncionarios.addFuncionario(f);
    }

    public ShowDAO getListaDeShows() {
        return listaDeShows;
    }
}
