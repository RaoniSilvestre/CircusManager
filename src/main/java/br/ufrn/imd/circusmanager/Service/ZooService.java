package br.ufrn.imd.circusmanager.Service;

import br.ufrn.imd.circusmanager.Dao.AnimalDAO;
import br.ufrn.imd.circusmanager.Model.Animais.Animal;
import br.ufrn.imd.circusmanager.Model.Circus.Circo;

import java.util.List;

public class ZooService {
    private AnimalDAO animalDAO;

    public ZooService() {
        this.animalDAO = new AnimalDAO();
    }

    public void addAnimal(Animal animal, Circo circo) {
        animal.setCirco(circo);
        animalDAO.salvar(animal);
    }

    public List<Animal> listarAnimais(Circo circo) {
        return animalDAO.buscarTodos(circo);
    }

    public void deletarAnimal(Animal animal) {
        animalDAO.deletar(animal.getId());
    }

    public double getCustoTotalAnimal(Circo circo) {
        List<Animal> animals = animalDAO.buscarTodos(circo);

        return animals.stream().map(Animal::getCusto).reduce(0.0, Double::sum);
    }


}
