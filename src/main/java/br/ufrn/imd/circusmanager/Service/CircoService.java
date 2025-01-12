package br.ufrn.imd.circusmanager.Service;

import br.ufrn.imd.circusmanager.Dao.CircoDAO;
import br.ufrn.imd.circusmanager.Dao.ContaDAO;
import br.ufrn.imd.circusmanager.Dao.TransacaoDAO;
import br.ufrn.imd.circusmanager.Model.Circus.Circo;
import br.ufrn.imd.circusmanager.Model.ContaBancaria.Conta;
import br.ufrn.imd.circusmanager.Model.ContaBancaria.Transacao;

public class CircoService {
    private CircoDAO circoDAO;
    private ContaDAO contaDAO;
    private TransacaoDAO transacaoDAO;

    public CircoService() {

        this.circoDAO = new CircoDAO();
        this.contaDAO = new ContaDAO();
        this.transacaoDAO = new TransacaoDAO();
    }

    public void criarCirco(String nomeCirco, double saldoInicial) {
        Circo novoCirco = new Circo(nomeCirco);
        circoDAO.salvar(novoCirco);

        Conta novaConta = new Conta(novoCirco);
        contaDAO.salvar(novaConta);

        novoCirco.setConta(novaConta);
        circoDAO.atualizar(novoCirco);

        Transacao transacaoInicial = new Transacao(novaConta, saldoInicial);
        novaConta.addTransacao(transacaoInicial);
        transacaoDAO.salvar(transacaoInicial);
    }

    public Circo getCircoPorNome(String nomeCirco) {
        return circoDAO.buscarPorNome(nomeCirco);
    }

}
