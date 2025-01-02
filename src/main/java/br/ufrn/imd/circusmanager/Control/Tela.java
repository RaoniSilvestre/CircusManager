package br.ufrn.imd.circusmanager.Control;

import java.util.Map;

import br.ufrn.imd.circusmanager.Main;
import br.ufrn.imd.circusmanager.Model.Circus.Circus;
import br.ufrn.imd.circusmanager.Model.Funcionarios.*;
import br.ufrn.imd.circusmanager.Model.Funcionarios.Enums.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public abstract class Tela {
    protected Main main;
    protected Circus circus;

    public abstract void atualizar();

    Map<String, MagicoEnum> magicoMap = Map.of(
        "ILUSIONISTA", MagicoEnum.ILUSIONISTA,
        "INFANTIL", MagicoEnum.INFANTIL,
        "CLASSICO", MagicoEnum.CLASSICO
    );
        

    Map<String, PalhacosEnum> palhacoMap = Map.of(
        "AUGUSTO", PalhacosEnum.AUGUSTO,
        "BRANCO", PalhacosEnum.BRANCO,
        "CONTRA_AGUSTO", PalhacosEnum.CONTRA_AUGUSTO,
        "MIMICO", PalhacosEnum.MIMICO
    );
        
        
     Map<String, TrapezistaEnum> trapezistaMap = Map.of(
        "FIXO", TrapezistaEnum.FIXO,
        "VOADOR", TrapezistaEnum.VOADOR,
        "CASTIN", TrapezistaEnum.CASTININ,
        "MULTIPLO", TrapezistaEnum.MULTIPLO
    );
    
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

    // O que djabo é isso
    @FXML
    public void voltar() {
        if (main.telaAtual < 4) {
            main.showScreen(main.telaAtual - 1);
        } 
        else if (main.telaAtual > 8) {
            main.showScreen(8);
        } 
        else {
            main.showScreen(4, main.circoAtual);
        }
    }

    public String getFuncionarioDescricao(Funcionario funcionario) {
        return String.format("%s - Ocupação: %s - Tipo: %s",
                funcionario.getNome(),
                funcionario.getOcupacao(),
                funcionario.getTipo());
    }
}
