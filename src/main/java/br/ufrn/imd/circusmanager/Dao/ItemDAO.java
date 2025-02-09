package br.ufrn.imd.circusmanager.Dao;

import br.ufrn.imd.circusmanager.Model.Circus.Circo;
import br.ufrn.imd.circusmanager.Model.Itens.Item;
import br.ufrn.imd.circusmanager.Utils.JpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * The type Item dao.
 */
public class ItemDAO extends GenericDAO<Item> {
    @Override
    public Item buscarPorId(int id) {
        EntityManager em = JpaUtils.getEntityManager();
        return em.find(Item.class, id);
    }

    @Override
    public List<Item> buscarTodos(Circo circo) {
        EntityManager em = JpaUtils.getEntityManager();
        String sql = "SELECT i FROM Item i WHERE i.funcionario.circo = :circo";
        TypedQuery<Item> query = em.createQuery(sql, Item.class);
        query.setParameter("circo", circo);
        return query.getResultList();
    }

}
