package br.ufrn.imd.circusmanager.Dao;

import br.ufrn.imd.circusmanager.Model.Circus.Circo;
import br.ufrn.imd.circusmanager.Model.Circus.Show;
import br.ufrn.imd.circusmanager.Utils.JpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * The type Show dao.
 */
public class ShowDAO extends GenericDAO<Show> {
    @Override
    public Show buscarPorId(int id) {
        EntityManager em = JpaUtils.getEntityManager();
        return em.find(Show.class, id);
    }

    @Override
    public List<Show> buscarTodos(Circo circo) {
        EntityManager em = JpaUtils.getEntityManager();
        TypedQuery<Show> query = em.createQuery("SELECT s FROM Show s", Show.class);
        return query.getResultList();
    }


}
