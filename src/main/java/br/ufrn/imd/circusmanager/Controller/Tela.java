package br.ufrn.imd.circusmanager.Controller;

import br.ufrn.imd.circusmanager.Model.Circus.Circo;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EntityManager;

@Getter
@Setter
public abstract class Tela {
    static private TelaManager manager;
    static private Circo circo;
    static private EntityManager em;

    static public EntityManager getEntityManager() {
        return Tela.em;
    }

    static public void setEntityManager(EntityManager em) {
        Tela.em = em;
    }

    static public TelaManager getManager() {
        return Tela.manager;
    }

    static public void setManager(TelaManager manager) {
        Tela.manager = manager;
    }

    static public Circo getCirco() {
        return Tela.circo;
    }

    static public void setCirco(Circo circo) {
        Tela.circo = circo;
    }

    public void trocarTela(String caminho) {
        manager.trocarTela(caminho);
    }

    public abstract void atualizar();

    public void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    public void voltar() {

        String tela = new String();

        if (manager.telaAtual.equals("CriarCircoView.fxml")) {
            manager.trocarTela("LoginView.fxml");
            return;
        } else if (manager.telaAtual.contains("Tela")) {
            tela = "TelaCircoMenuView.fxml";
        } else if (manager.telaAtual.contains("Funcionario")) {
            tela = "TelaFuncionariosView.fxml";
        } else if (manager.telaAtual.contains("Anima")) {
            tela = "TelaZooView.fxml";
        } else if (manager.telaAtual.contains("Show")) {
            tela = "TelaShowView.fxml";
        }

        manager.trocarTela(tela);
    }

    @FXML
    public void sairDoSistema() {
        // Sair do APP
        System.exit(0);
    }
}
