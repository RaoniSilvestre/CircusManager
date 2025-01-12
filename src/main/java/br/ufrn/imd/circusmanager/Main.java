package br.ufrn.imd.circusmanager;

import br.ufrn.imd.circusmanager.Controller.TelaManager;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The type Main.
 */
public class Main extends Application {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch();
    }


    @Override
    public void start(Stage stage) throws IOException {
        TelaManager telaManager = new TelaManager(stage);

        telaManager.trocarTela("TelaInicialView.fxml");
    }
}