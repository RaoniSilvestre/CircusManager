package br.ufrn.imd.circusmanager.Controller;

import br.ufrn.imd.circusmanager.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import lombok.Getter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;


public class TelaManager {

    @Getter
    private final StackPane root;
    public String telaAtual;

    public TelaManager(Stage stage) {
        root = new StackPane();
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Circus Manager!");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("circus-manager-pu");
        EntityManager em = emf.createEntityManager();

        Tela.setManager(this);
        Tela.setEntityManager(em);
    }

    public void trocarTela(String caminho) {
        try {
            // Carrega o novo arquivo FXML
            FXMLLoader loader = new FXMLLoader(Main.class.getResource(caminho));
            Parent novaTela = loader.load();

            // Limpa o root e adiciona a nova tela
            root.getChildren().clear();
            root.getChildren().add(novaTela);

            // Configura o controlador da nova tela
            Tela controller = loader.getController();

            telaAtual = caminho;
            controller.atualizar();

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao carregar a tela: " + caminho);
        }
    }

}
