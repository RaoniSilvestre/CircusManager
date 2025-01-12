package br.ufrn.imd.circusmanager.Service;

import br.ufrn.imd.circusmanager.Dao.FuncionarioDAO;
import br.ufrn.imd.circusmanager.Dao.ItemDAO;
import br.ufrn.imd.circusmanager.Model.Circus.Circo;
import br.ufrn.imd.circusmanager.Model.Funcionarios.Funcionario;
import br.ufrn.imd.circusmanager.Model.Itens.Item;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioService {
    private FuncionarioDAO funcionarioDAO;
    private ItemDAO itemDAO;

    public FuncionarioService() {
        this.funcionarioDAO = new FuncionarioDAO();
        this.itemDAO = new ItemDAO();
    }

    public void salvarFuncionario(Funcionario funcionario, Circo circo, ArrayList<Item> itens) {
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

}
