package br.ufrn.imd.circusmanager.Dao;

import br.ufrn.imd.circusmanager.Model.Circus.Circo;
import br.ufrn.imd.circusmanager.Model.ContaBancaria.Conta;
import br.ufrn.imd.circusmanager.Utils.JpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * The type Conta dao.
 */
public class ContaDAO extends GenericDAO<Conta> {
    @Override
    public Conta buscarPorId(int id) {
        EntityManager em = JpaUtils.getEntityManager();
        return em.find(Conta.class, id);
    }

    @Override
    public List<Conta> buscarTodos(Circo circo) {
        EntityManager em = JpaUtils.getEntityManager();
        TypedQuery<Conta> query = em.createQuery("SELECT c FROM Conta c", Conta.class);
        return query.getResultList();
    }

}
