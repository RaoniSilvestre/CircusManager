package br.ufrn.imd.circusmanager.Controller.ShowController;

import br.ufrn.imd.circusmanager.Controller.Tela;
import br.ufrn.imd.circusmanager.Model.Circus.Show;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class TelaListaShowController extends Tela {
    @FXML
    private ListView<String> listashows;

    // Método chamado para preencher a lista de funcionários
    public void inicializarLista() {
        listashows.getItems().clear();
    
        for (Show show : circus.getListaDeShows().getShows()) {
            listashows.getItems().add(show.getDescricao());
        }
    }


    public void atualizar() {
        inicializarLista();
    }
}
