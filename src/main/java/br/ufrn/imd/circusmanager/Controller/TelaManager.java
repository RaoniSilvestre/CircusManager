package br.ufrn.imd.circusmanager.Controller;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import br.ufrn.imd.circusmanager.Main;
import br.ufrn.imd.circusmanager.Model.Circus.Circus;
import br.ufrn.imd.circusmanager.Storage.CircusStorage;


public class TelaManager {

    public String telaAtual;

    private StackPane root; // Contêiner de todas as telas

    private CircusStorage circusStorage = new CircusStorage();

    public TelaManager(Stage stage) {
        root = new StackPane();
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Circus Manager!");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void trocarTela(String caminho, Circus... circus) {
        try {
            // Carrega o novo arquivo FXML
            FXMLLoader loader = new FXMLLoader(Main.class.getResource(caminho));
            Parent novaTela = loader.load();

            // Limpa o root e adiciona a nova tela
            root.getChildren().clear();

            root.getChildren().add(novaTela);

            // Configura o controlador da nova tela
            Tela controller = loader.getController();
            controller.setManager(this);

            if (circus.length > 0) {
                controller.setCircus(circus[0]);
            }
            
            telaAtual = caminho;
            controller.atualizar();

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao carregar a tela: " + caminho);
        }
    }
        
    public void salvarCirco(Circus circo) {
        circusStorage.salvarCirco(circo);
    }

    public StackPane getRoot() {
        return root;
    }
}
