package br.ufrn.imd.circusmanager.Dao;

import br.ufrn.imd.circusmanager.Model.Circus.Circo;
import br.ufrn.imd.circusmanager.Model.Funcionarios.Funcionario;
import br.ufrn.imd.circusmanager.Utils.JpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class FuncionarioDAO extends GenericDAO<Funcionario> {
    @Override
    public Funcionario buscarPorId(int id) {
        EntityManager em = JpaUtils.getEntityManager();
        return em.find(Funcionario.class, id);
    }

    @Override
    public List<Funcionario> buscarTodos(Circo circo) {
        EntityManager em = JpaUtils.getEntityManager();
        String sql = "SELECT f FROM Funcionario f WHERE f.circo = :circo";
        TypedQuery<Funcionario> query = em.createQuery(sql, Funcionario.class);
        query.setParameter("circo", circo);
        return query.getResultList();
    }


}