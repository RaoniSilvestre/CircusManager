package br.ufrn.imd.circusmanager.Dao;

import br.ufrn.imd.circusmanager.Model.Itens.Item;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ItemDAO extends GenericDAO<Item> {


    protected ItemDAO(EntityManager em) {
        super(em);
    }

    @Override
    public Item buscarPorId(int id) {
        return em.find(Item.class, id);
    }

    @Override
    public List<Item> buscarTodos(int id) {
        TypedQuery<Item> query = em.createQuery("SELECT i FROM Item i", Item.class);
        return query.getResultList();
    }
}
