package br.ufrn.imd.circusmanager.Dao;

import java.util.List;

public interface GenericDAO<T> {
    void salvar(T t);
    T buscarPorId(int id);
    List<T> buscarTodos();
    void atualizar(T t);
    void deletar(int id);
}
