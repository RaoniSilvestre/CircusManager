package br.ufrn.imd.circusmanager;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

import br.ufrn.imd.circusmanager.Controller.TelaManager;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        TelaManager telaManager = new TelaManager(stage);

        telaManager.trocarTela("TelaInicialView.fxml");
    }


    public static void main(String[] args) {
        launch();
    }
}