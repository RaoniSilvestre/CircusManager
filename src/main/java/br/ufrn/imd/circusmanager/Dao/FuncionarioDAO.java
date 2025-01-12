package br.ufrn.imd.circusmanager.Dao;

import br.ufrn.imd.circusmanager.Model.Funcionarios.Funcionario;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class FuncionarioDAO extends GenericDAO<Funcionario> {
    protected FuncionarioDAO(EntityManager em) {
        super(em);
    }

    @Override
    public Funcionario buscarPorId(int id) {
        return em.find(Funcionario.class, id);
    }

    @Override
    public List<Funcionario> buscarTodos(int id) {
        TypedQuery<Funcionario> query = em.createQuery("SELECT f FROM Funcionario f", Funcionario.class);
        return query.getResultList();
    }


}