package br.ufrn.imd.circusmanager.Dao;

import br.ufrn.imd.circusmanager.Model.Animais.Animal;

import java.util.ArrayList;

public class AnimalDAO {
    private ArrayList<Animal> animais;

    public AnimalDAO() {
        this.animais = new ArrayList<>();
    }

    public void addAnimal(Animal a) {
        this.animais.add(a);
    }

    public void deleteAnimal(Animal a) {
        this.animais.remove(a);
    }
}
