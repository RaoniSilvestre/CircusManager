package br.ufrn.imd.circusmanager.Dao;

import br.ufrn.imd.circusmanager.Model.ContaBancaria.Transacao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class TransacaoDAO extends GenericDAO<Transacao> {
    protected TransacaoDAO(EntityManager em) {
        super(em);
    }


    @Override
    public Transacao buscarPorId(int id) {
        return em.find(Transacao.class, id);
    }

    @Override
    public List<Transacao> buscarTodos(int id) {
        TypedQuery<Transacao> query = em.createQuery("SELECT t FROM Transacao t", Transacao.class);
        return query.getResultList();
    }

}
