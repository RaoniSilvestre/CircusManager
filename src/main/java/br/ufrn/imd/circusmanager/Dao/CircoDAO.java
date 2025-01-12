package br.ufrn.imd.circusmanager.Dao;

import br.ufrn.imd.circusmanager.Model.Circus.Circo;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class CircoDAO extends GenericDAO<Circo> {


    public CircoDAO(EntityManager em) {
        super(em);
    }


    @Override
    public Circo buscarPorId(int id) {
        return em.find(Circo.class, id);
    }

    public Circo buscarPorNome(String nome) {
        try {
            return em.createQuery("SELECT c FROM Circo c WHERE c.nome = :nome", Circo.class)
                    .setParameter("nome", nome)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;  // Caso não encontre nenhum resultado
        }
    }

    @Override
    public List<Circo> buscarTodos(int id) {
        TypedQuery<Circo> query = em.createQuery("SELECT c FROM Circo c", Circo.class);
        return query.getResultList();
    }

}
