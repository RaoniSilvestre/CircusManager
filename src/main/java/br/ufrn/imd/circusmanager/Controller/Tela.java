package br.ufrn.imd.circusmanager.Controller;

import br.ufrn.imd.circusmanager.Main;
import br.ufrn.imd.circusmanager.Model.Circus.Circus;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public abstract class Tela {
    protected Main main;
    protected Circus circus;
    public abstract void atualizar();
    
    public void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void setCircus(Circus circus) {
        this.circus = circus;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    public void sairDoSistema() {
        // Sair do APP
        System.exit(0);
    }

    @FXML
    public void voltar() {
        if (main.telaAtual <= 3) {
            main.showScreen(main.telaAtual - 1);
        } 
        else if (main.telaAtual == 5 || main.telaAtual == 9) {
            main.showScreen(4);
        }
        else if (main.telaAtual <= 8) {
            main.showScreen(5);
        }
        else if (main.telaAtual <= 12) {
            main.showScreen(9);
        } 
        else {
            main.showScreen(4);
        }
    }
}
