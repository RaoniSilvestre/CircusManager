package br.ufrn.imd.circusmanager.Service;

import br.ufrn.imd.circusmanager.Dao.FuncionarioDAO;
import br.ufrn.imd.circusmanager.Dao.ItemDAO;
import br.ufrn.imd.circusmanager.Model.Circus.Circo;
import br.ufrn.imd.circusmanager.Model.Funcionarios.Funcionario;
import br.ufrn.imd.circusmanager.Model.Itens.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FuncionarioService {
    private FuncionarioDAO funcionarioDAO;
    private ItemDAO itemDAO;

    public FuncionarioService() {
        this.funcionarioDAO = new FuncionarioDAO();
        this.itemDAO = new ItemDAO();
    }

    public void addFuncionario(Funcionario funcionario, Circo circo, ArrayList<Item> itens) {
        funcionario.setCirco(circo);
        funcionarioDAO.salvar(funcionario);

        itens.forEach(item -> {
            item.setFuncionario(funcionario);
            itemDAO.salvar(item);
        });
    }

    public List<Funcionario> buscarTodosFuncionario(Circo circo) {
        return funcionarioDAO.buscarTodos(circo);
    }

    public void deletarFuncionario(Funcionario funcionario) {
        funcionarioDAO.deletar(funcionario.getId());
    }


    public double getCustoTotalFuncionario(Circo circo) {
        List<Funcionario> funcionarios = funcionarioDAO.buscarTodos(circo);
        return funcionarios.stream().map(Funcionario::getSalario).reduce(0.0, Double::sum);
    }

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

    public int getFuncionarioItens(Circo circo) {
        List<Item> itens = itemDAO.buscarTodos(circo);

        return itens.size();
    }

}
