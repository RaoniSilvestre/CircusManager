package br.ufrn.imd.circusmanager.Dao;

import br.ufrn.imd.circusmanager.Model.Animais.Animal;

import javax.persistence.EntityManager;
import java.util.List;

public class AnimalDAO extends GenericDAO<Animal> {

    public AnimalDAO(EntityManager em) {
        super(em);
    }

    @Override
    public Animal buscarPorId(int id) {
        return null;
    }

    @Override
    public List<Animal> buscarTodos(int id) {
        return List.of();
    }


}
