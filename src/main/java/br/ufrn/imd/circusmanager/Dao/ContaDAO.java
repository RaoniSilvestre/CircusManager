package br.ufrn.imd.circusmanager.Dao;

import br.ufrn.imd.circusmanager.Model.ContaBancaria.Conta;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ContaDAO extends GenericDAO<Conta> {

    public ContaDAO(EntityManager em) {
        super(em);
    }


    @Override
    public Conta buscarPorId(int id) {
        return em.find(Conta.class, id);
    }

    @Override
    public List<Conta> buscarTodos(int id) {
        TypedQuery<Conta> query = em.createQuery("SELECT c FROM Conta c", Conta.class);
        return query.getResultList();
    }

}
