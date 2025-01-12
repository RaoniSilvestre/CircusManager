package br.ufrn.imd.circusmanager.Controller.ZooController;

import br.ufrn.imd.circusmanager.Controller.Tela;
import br.ufrn.imd.circusmanager.Model.Animais.Animal;
import br.ufrn.imd.circusmanager.Service.ZooService;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.List;

/**
 * The type Lista animais controller.
 */
public class ListaAnimaisController extends Tela {

    /**
     * The Zoo service.
     */
    ZooService zooService;

    @FXML
    private ListView<Animal> listaAnimais;

    /**
     * Initialize.
     */
    @FXML
    public void initialize() {
        this.zooService = new ZooService();
    }

    /**
     * Inicializar lista.
     */
    public void inicializarLista() {
        listaAnimais.getItems().clear();

        List<Animal> animais = this.zooService.listarAnimais(Tela.getCirco());

        for (Animal animal : animais) {
            listaAnimais.getItems().add(animal);
        }
    }


    public void atualizar() {
        inicializarLista();
    }
}
