package br.ufrn.imd.circusmanager.Service;

import br.ufrn.imd.circusmanager.Dao.CircoDAO;
import br.ufrn.imd.circusmanager.Dao.ContaDAO;
import br.ufrn.imd.circusmanager.Dao.TransacaoDAO;
import br.ufrn.imd.circusmanager.Model.Circus.Circo;
import br.ufrn.imd.circusmanager.Model.ContaBancaria.Conta;
import br.ufrn.imd.circusmanager.Model.ContaBancaria.Enums.TransacaoEnum;
import br.ufrn.imd.circusmanager.Model.ContaBancaria.Transacao;

/**
 * The type Circo service.
 */
public class CircoService {
    private final CircoDAO circoDAO;
    private final ContaDAO contaDAO;
    private final TransacaoDAO transacaoDAO;

    /**
     * Instantiates a new Circo service.
     */
    public CircoService() {
        this.circoDAO = new CircoDAO();
        this.contaDAO = new ContaDAO();
        this.transacaoDAO = new TransacaoDAO();
    }

    /**
     * Criar circo.
     *
     * @param nomeCirco    the nome circo
     * @param saldoInicial the saldo inicial
     */
    public void criarCirco(String nomeCirco, double saldoInicial) {
        Circo novoCirco = new Circo(nomeCirco);
        circoDAO.salvar(novoCirco);

        Conta novaConta = new Conta(novoCirco);
        contaDAO.salvar(novaConta);

        novoCirco.setConta(novaConta);
        circoDAO.atualizar(novoCirco);

        Transacao transacaoInicial = new Transacao(TransacaoEnum.FUNDACAO, saldoInicial);
        transacaoInicial.setConta(novaConta);
        novaConta.addTransacao(transacaoInicial);
        transacaoDAO.salvar(transacaoInicial);
    }

    /**
     * Add transacao.
     *
     * @param transacao the transacao
     * @param circo     the circo
     */
    public void addTransacao(Transacao transacao, Circo circo) {
        Conta conta = contaDAO.buscarTodos(circo).get(0);

        conta.getTransacoes().add(transacao);
        transacao.setConta(conta);

        transacaoDAO.salvar(transacao);
        contaDAO.atualizar(conta);
    }

    /**
     * Calcular saldo double.
     *
     * @param circo the circo
     * @return the double
     */
    public double calcularSaldo(Circo circo) {
        return transacaoDAO.buscarTodos(circo).stream().map(Transacao::getAmount).reduce(0.0, Double::sum);
    }

    /**
     * Gets circo por nome.
     *
     * @param nomeCirco the nome circo
     * @return the circo por nome
     */
    public Circo getCircoPorNome(String nomeCirco) {
        return circoDAO.buscarPorNome(nomeCirco);
    }

}
