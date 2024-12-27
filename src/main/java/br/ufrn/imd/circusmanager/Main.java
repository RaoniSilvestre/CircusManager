package br.ufrn.imd.circusmanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.ufrn.imd.circusmanager.Control.Botao;
import br.ufrn.imd.circusmanager.Model.Circus.Circus;

public class Main extends Application {
    private StackPane root; // Contêiner contendo todas as telas

    Parent tela1;
    Parent tela2;
    Parent tela3;
    Parent tela4;
    Parent tela5;
    Parent tela6;
    Parent tela7;

    public int telaAtual = 0;
    public Parent[] telas = new Parent[7];

    @Override
    public void start(Stage stage) throws IOException {
    
        // Loop para carregar as telas
        for (int i = 0; i < 7; i++) {
            String caminho = ("tela"+(i+1)+".fxml");

            FXMLLoader loader = new FXMLLoader(Main.class.getResource(caminho));
            telas[i] = loader.load();
    
            // Configurar o controlador
            Object controller = loader.getController();
            if (controller instanceof Botao) {
                ((Botao) controller).setMain(this);
            }
        }
    
        // Pai de todas as telas
        root = new StackPane();
        root.getChildren().addAll(telas);
    
        // Exibir a primeira tela
        showScreen(1);
    
        // Configurações da janela
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Circus Manager!");
        stage.setScene(scene);
        stage.show();
    }
    


    public void showScreen(int tela, Circus... circo) {
        tela -= 1;

        root.getChildren().forEach(node -> {
            node.setVisible(false);
            node.setDisable(true);
        });
        telas[tela].setVisible(true);
        telas[tela].setDisable(false);
        telaAtual = tela+1;
    }

    public static void main(String[] args) {
        launch();
    }
}
