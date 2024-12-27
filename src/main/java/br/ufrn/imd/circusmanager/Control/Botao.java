package br.ufrn.imd.circusmanager.Control;

import br.ufrn.imd.circusmanager.Main;
import javafx.fxml.FXML;

public class Botao {
    public Main main;

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
        // Voltar para a tela anterior
        if (main != null) {
            main.showScreen(main.telaAtual - 1);
        }
    }
}
