package br.ufrn.imd.circusmanager.Service;

import br.ufrn.imd.circusmanager.Dao.AnimalDAO;
import br.ufrn.imd.circusmanager.Model.Animais.Animal;
import br.ufrn.imd.circusmanager.Model.Circus.Circo;

import java.util.List;

/**
 * The type Zoo service.
 */
public class ZooService {
    private final AnimalDAO animalDAO;

    /**
     * Instantiates a new Zoo service.
     */
    public ZooService() {
        this.animalDAO = new AnimalDAO();
    }

    /**
     * Add animal.
     *
     * @param animal the animal
     * @param circo  the circo
     */
    public void addAnimal(Animal animal, Circo circo) {
        animal.setCirco(circo);
        animalDAO.salvar(animal);
    }

    /**
     * Listar animais list.
     *
     * @param circo the circo
     * @return the list
     */
    public List<Animal> listarAnimais(Circo circo) {
        return animalDAO.buscarTodos(circo);
    }

    /**
     * Deletar animal.
     *
     * @param animal the animal
     */
    public void deletarAnimal(Animal animal) {
        animalDAO.deletar(animal.getId());
    }

    /**
     * Gets custo total animal.
     *
     * @param circo the circo
     * @return the custo total animal
     */
    public double getCustoTotalAnimal(Circo circo) {
        List<Animal> animals = animalDAO.buscarTodos(circo);

        return animals.stream().map(Animal::getCusto).reduce(0.0, Double::sum);
    }


}
