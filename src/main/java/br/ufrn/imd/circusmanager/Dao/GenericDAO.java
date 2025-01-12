package br.ufrn.imd.circusmanager.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;


public abstract class GenericDAO<T> {
    protected final EntityManager em;

    protected GenericDAO(EntityManager em) {
        this.em = em;
    }

    public void salvar(T t) {
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
        }
    }

    public abstract T buscarPorId(int id);

    public abstract List<T> buscarTodos(int id);

    public void atualizar(T t) {
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
        }
    }

    ;

    public void deletar(int id) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            T animal = buscarPorId(id);
            if (animal != null) {
                em.remove(animal);
            }
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    ;
}
