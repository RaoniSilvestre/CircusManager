package br.ufrn.imd.circusmanager.Dao;

import br.ufrn.imd.circusmanager.Model.Funcionarios.Funcionario;

import java.util.ArrayList;

public class FuncionarioDAO {
    private ArrayList<Funcionario> funcionarios;

    public FuncionarioDAO() {
        this.funcionarios = new ArrayList<>();
    }

    public void addFuncionario(Funcionario f) {
        this.funcionarios.add(f);
    }

    public void deleteFuncionario(Funcionario f) {
        this.funcionarios.remove(f);
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}
