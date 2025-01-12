package br.ufrn.imd.circusmanager.Dao;

import br.ufrn.imd.circusmanager.Model.Circus.Circo;
import br.ufrn.imd.circusmanager.Utils.JpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;


/**
 * The type Generic dao.
 *
 * @param <T> the type parameter
 */
public abstract class GenericDAO<T> {


    /**
     * Salvar.
     *
     * @param t the t
     */
    public void salvar(T t) {
        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(t);
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

    /**
     * Buscar por id t.
     *
     * @param id the id
     * @return the t
     */
    public abstract T buscarPorId(int id);

    /**
     * Buscar todos list.
     *
     * @param circo the circo
     * @return the list
     */
    public abstract List<T> buscarTodos(Circo circo);

    /**
     * Atualizar.
     *
     * @param t the t
     */
    public void atualizar(T t) {
        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(t);
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


    /**
     * Deletar.
     *
     * @param id the id
     */
    public void deletar(int id) {
        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            T entidade = buscarPorId(id);
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
