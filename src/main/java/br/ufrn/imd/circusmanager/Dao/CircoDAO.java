package br.ufrn.imd.circusmanager.Dao;

import br.ufrn.imd.circusmanager.Model.Circus.Circo;
import br.ufrn.imd.circusmanager.Utils.JpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class CircoDAO extends GenericDAO<Circo> {


    @Override
    public Circo buscarPorId(int id) {
        EntityManager em = JpaUtils.getEntityManager();

        return em.find(Circo.class, id);
    }

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

}
