package br.ufrn.imd.circusmanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import br.ufrn.imd.circusmanager.Storage.*;

import java.io.IOException;
import java.util.ArrayList;

import br.ufrn.imd.circusmanager.Control.Botao;
import br.ufrn.imd.circusmanager.Model.Circus.Circus;

public class Main extends Application {
    private StackPane root; // Contêiner contendo todas as telas

    private CircusStorage circusStorage = new CircusStorage();
    public Circus circoAtual;

    public int telaAtual = 0;

    public Parent[] telas = new Parent[11];
    public ArrayList<Botao> controles = new ArrayList<>();

    @Override
    public void start(Stage stage) throws IOException {
    
        // Loop para carregar as telas
        for (int i = 0; i < 11; i++) {
            String caminho = ("tela"+(i+1)+".fxml");

            FXMLLoader loader = new FXMLLoader(Main.class.getResource(caminho));
            telas[i] = loader.load();
    
            // Configurar o controlador
            Botao controller = loader.getController();
            controles.add(controller);
            controller.setMain(this);
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

        root.getChildren().forEach(node -> {
            node.setVisible(false);
            node.setDisable(true);
        });

        if (circo.length > 0) {
            setCircoAtual(circo[0]);
        }

        if (tela >= 4) {
            controles.get(tela-1).setCircus(circoAtual);
            controles.get(tela-1).atualizar();
        } else {
            setCircoAtual(null);
        }

        telas[tela-1].setVisible(true);
        telas[tela-1].setDisable(false);

        telaAtual = tela;
    }

    
    public void salvarCirco(Circus circo) {
        circusStorage.salvarCirco(circo);
    }

    public static void main(String[] args) {
        launch();
    }
    
    public void setCircoAtual(Circus circoAtual) {
        this.circoAtual = circoAtual;
    }

    public Circus getCircoAtual() {
        return circoAtual;
    }
}
