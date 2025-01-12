package br.ufrn.imd.circusmanager.Dao;

import br.ufrn.imd.circusmanager.Model.Circus.Circo;
import br.ufrn.imd.circusmanager.Model.ContaBancaria.Transacao;
import br.ufrn.imd.circusmanager.Utils.JpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * The type Transacao dao.
 */
public class TransacaoDAO extends GenericDAO<Transacao> {
    @Override
    public Transacao buscarPorId(int id) {
        EntityManager em = JpaUtils.getEntityManager();
        return em.find(Transacao.class, id);
    }

    @Override
    public List<Transacao> buscarTodos(Circo circo) {
        EntityManager em = JpaUtils.getEntityManager();
        TypedQuery<Transacao> query = em.createQuery("SELECT t FROM Transacao t WHERE t.conta.circo = :circo", Transacao.class);
        query.setParameter("circo", circo);
        return query.getResultList();
    }

}
