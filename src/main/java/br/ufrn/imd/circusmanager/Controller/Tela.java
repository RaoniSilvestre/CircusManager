package br.ufrn.imd.circusmanager.Controller;

import br.ufrn.imd.circusmanager.Model.Circus.Circus;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public abstract class Tela {
    protected TelaManager manager;
    protected Circus circus;

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
        }
        else if (manager.telaAtual.contains("Tela")) {
            tela = "TelaCircoMenuView.fxml";
        }
        else if (manager.telaAtual.contains("Funcionario")) {
            tela = "TelaFuncionariosView.fxml";
        }
        else if (manager.telaAtual.contains("Anima")) {
            tela = "TelaZooView.fxml";
        }
        else if (manager.telaAtual.contains("Show")) {
            tela = "TelaShowView.fxml";
        }

        manager.trocarTela(tela, circus);
    }

    @FXML
    public void sairDoSistema() {
        // Sair do APP
        System.exit(0);
    }

    public void setManager(TelaManager manager) {
        this.manager = manager;
    }

    public Circus getCircus() {
        return circus;
    }

    public void setCircus(Circus circus) {
        this.circus = circus;
    }

}
