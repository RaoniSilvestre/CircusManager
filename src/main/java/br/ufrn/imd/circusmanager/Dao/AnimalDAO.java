package br.ufrn.imd.circusmanager.Dao;

import br.ufrn.imd.circusmanager.Model.Animais.Animal;
import br.ufrn.imd.circusmanager.Model.Circus.Circo;
import br.ufrn.imd.circusmanager.Utils.JpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;


/**
 * The type Animal dao.
 */
public class AnimalDAO extends GenericDAO<Animal> {
    @Override
    public Animal buscarPorId(int id) {
        EntityManager em = JpaUtils.getEntityManager();
        return em.find(Animal.class, id);
    }

    @Override
    public List<Animal> buscarTodos(Circo circo) {
        EntityManager em = JpaUtils.getEntityManager();
        String sql = "SELECT f FROM Animal f WHERE f.circo = :circo";
        TypedQuery<Animal> query = em.createQuery(sql, Animal.class);
        query.setParameter("circo", circo);
        return query.getResultList();
    }


    @Override
    public void deletar(int id) {
        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Animal animal = em.find(Animal.class, id);
            if (animal != null) {
                em.merge(animal);
                animal.setCirco(null);
                em.remove(animal);
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
