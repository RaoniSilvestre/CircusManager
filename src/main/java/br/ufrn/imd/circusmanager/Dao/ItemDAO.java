package br.ufrn.imd.circusmanager.Dao;

import br.ufrn.imd.circusmanager.Model.Circus.Circo;
import br.ufrn.imd.circusmanager.Model.Itens.Item;
import br.ufrn.imd.circusmanager.Utils.JpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ItemDAO extends GenericDAO<Item> {
    @Override
    public Item buscarPorId(int id) {
        EntityManager em = JpaUtils.getEntityManager();
        return em.find(Item.class, id);
    }

    @Override
    public List<Item> buscarTodos(Circo circo) {
        EntityManager em = JpaUtils.getEntityManager();
        TypedQuery<Item> query = em.createQuery("SELECT i FROM Item i", Item.class);
        return query.getResultList();
    }
}
