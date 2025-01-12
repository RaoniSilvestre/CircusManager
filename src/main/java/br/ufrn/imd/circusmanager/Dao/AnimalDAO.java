package br.ufrn.imd.circusmanager.Dao;

import br.ufrn.imd.circusmanager.Model.Animais.Animal;
import br.ufrn.imd.circusmanager.Model.Circus.Circo;

import java.util.List;

public class AnimalDAO extends GenericDAO<Animal> {
    @Override
    public Animal buscarPorId(int id) {
        return null;
    }

    @Override
    public List<Animal> buscarTodos(Circo circo) {
        return List.of();
    }


}
