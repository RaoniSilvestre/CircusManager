package br.ufrn.imd.circusmanager.Control;

import br.ufrn.imd.circusmanager.Model.Animais.Animal;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class TelaListaAnimaisController extends Tela {
    @FXML
    private ListView<String> listaAnimais;

    // Método chamado para preencher a lista de funcionários
    public void inicializarLista() {
        listaAnimais.getItems().clear();
    
        for (Animal animal : main.circoAtual.getListaDeAnimais().getAnimais()) {
            listaAnimais.getItems().add(animal.getDescricao());
        }
    }


    public void atualizar() {
        inicializarLista();
    }
}
