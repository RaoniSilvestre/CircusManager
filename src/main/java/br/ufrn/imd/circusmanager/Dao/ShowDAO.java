package br.ufrn.imd.circusmanager.Dao;

import br.ufrn.imd.circusmanager.Model.Circus.Show;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ShowDAO extends GenericDAO<Show> {
    protected ShowDAO(EntityManager em) {
        super(em);
    }

    @Override
    public Show buscarPorId(int id) {
        return em.find(Show.class, id);
    }

    @Override
    public List<Show> buscarTodos(int id) {
        TypedQuery<Show> query = em.createQuery("SELECT s FROM Show s", Show.class);
        return query.getResultList();
    }


}
