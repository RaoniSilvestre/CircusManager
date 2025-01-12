package br.ufrn.imd.circusmanager.Controller.ShowController;

import br.ufrn.imd.circusmanager.Controller.Tela;
import br.ufrn.imd.circusmanager.Model.Circus.Show;
import br.ufrn.imd.circusmanager.Service.ShowService;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.List;

/**
 * The type Lista show controller.
 */
public class ListaShowController extends Tela {
    /**
     * The Show service.
     */
    ShowService showService;


    @FXML
    private ListView<Show> listashows;

    /**
     * Initialize.
     */
    @FXML
    public void initialize() {
        this.showService = new ShowService();
    }

    /**
     * Inicializar lista.
     */
// Método chamado para preencher a lista de funcionários
    public void inicializarLista() {
        listashows.getItems().clear();

        List<Show> shows = showService.listarShow(Tela.getCirco());


        for (Show show : shows) {
            listashows.getItems().add(show);
        }
    }


    public void atualizar() {
        inicializarLista();
    }
}
