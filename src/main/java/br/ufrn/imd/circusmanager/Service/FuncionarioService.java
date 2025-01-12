package br.ufrn.imd.circusmanager.Service;

import br.ufrn.imd.circusmanager.Dao.FuncionarioDAO;
import br.ufrn.imd.circusmanager.Dao.ItemDAO;
import br.ufrn.imd.circusmanager.Model.Circus.Circo;
import br.ufrn.imd.circusmanager.Model.Funcionarios.Funcionario;
import br.ufrn.imd.circusmanager.Model.Itens.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Funcionario service.
 */
public class FuncionarioService {
    private final FuncionarioDAO funcionarioDAO;
    private final ItemDAO itemDAO;

    /**
     * Instantiates a new Funcionario service.
     */
    public FuncionarioService() {
        this.funcionarioDAO = new FuncionarioDAO();
        this.itemDAO = new ItemDAO();
    }

    /**
     * Add funcionario.
     *
     * @param funcionario the funcionario
     * @param circo       the circo
     * @param itens       the itens
     */
    public void addFuncionario(Funcionario funcionario, Circo circo, ArrayList<Item> itens) {
        funcionario.setCirco(circo);
        funcionarioDAO.salvar(funcionario);

        itens.forEach(item -> {
            item.setFuncionario(funcionario);
            itemDAO.salvar(item);
        });
    }

    /**
     * Buscar todos funcionario list.
     *
     * @param circo the circo
     * @return the list
     */
    public List<Funcionario> buscarTodosFuncionario(Circo circo) {
        return funcionarioDAO.buscarTodos(circo);
    }

    /**
     * Deletar funcionario.
     *
     * @param funcionario the funcionario
     */
    public void deletarFuncionario(Funcionario funcionario) {
        funcionarioDAO.deletar(funcionario.getId());
    }


    /**
     * Gets custo total funcionario.
     *
     * @param circo the circo
     * @return the custo total funcionario
     */
    public double getCustoTotalFuncionario(Circo circo) {
        List<Funcionario> funcionarios = funcionarioDAO.buscarTodos(circo);
        return funcionarios.stream().map(Funcionario::getSalario).reduce(0.0, Double::sum);
    }

    /**
     * Gets funcionario mais antigo.
     *
     * @param circo the circo
     * @return the funcionario mais antigo
     */
    public String getFuncionarioMaisAntigo(Circo circo) {
        List<Funcionario> funcionarios = funcionarioDAO.buscarTodos(circo);

        Optional<Funcionario> funcionarioMaisAntigo = funcionarios.stream().reduce((a, b) -> {
            if (a.getId() < b.getId()) {
                return a;
            } else {
                return b;
            }
        });

        if (funcionarioMaisAntigo.isPresent()) {
            return funcionarioMaisAntigo.get().getNome();
        } else {
            return "Sem funcionarios";
        }
    }

    /**
     * Gets funcionario itens.
     *
     * @param circo the circo
     * @return the funcionario itens
     */
    public int getFuncionarioItens(Circo circo) {
        List<Item> itens = itemDAO.buscarTodos(circo);

        return itens.size();
    }

}
