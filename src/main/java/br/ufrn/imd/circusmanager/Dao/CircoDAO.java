package br.ufrn.imd.circusmanager.Dao;

import br.ufrn.imd.circusmanager.Model.Circus.Circo;
import br.ufrn.imd.circusmanager.Utils.JpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * The type Circo dao.
 */
public class CircoDAO extends GenericDAO<Circo> {


    @Override
    public Circo buscarPorId(int id) {
        EntityManager em = JpaUtils.getEntityManager();

        return em.find(Circo.class, id);
    }

    /**
     * Buscar por nome circo.
     *
     * @param nome the nome
     * @return the circo
     */
    public Circo buscarPorNome(String nome) {
        EntityManager em = JpaUtils.getEntityManager();
        try {
            return em.createQuery("SELECT c FROM Circo c WHERE c.nome = :nome", Circo.class)
                    .setParameter("nome", nome)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;  // Caso não encontre nenhum resultado
        } finally {
            em.close();
        }
    }

    @Override
    public List<Circo> buscarTodos(Circo circo) {
        EntityManager em = JpaUtils.getEntityManager();

        TypedQuery<Circo> query = em.createQuery("SELECT c FROM Circo c", Circo.class);
        return query.getResultList();
    }

    @Override
    public void deletar(int id) {
        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Circo entidade = buscarPorId(id);
            if (entidade != null) {
                entidade = em.merge(entidade);
                em.remove(entidade);
            }
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

}
