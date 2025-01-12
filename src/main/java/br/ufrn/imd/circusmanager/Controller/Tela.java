package br.ufrn.imd.circusmanager.Controller;

import br.ufrn.imd.circusmanager.Model.Circus.Circo;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EntityManager;

/**
 * The type Tela.
 */
@Getter
@Setter
public abstract class Tela {
    static private TelaManager manager;
    static private Circo circo;
    static private EntityManager em;

    /**
     * Gets entity manager.
     *
     * @return the entity manager
     */
    static public EntityManager getEntityManager() {
        return Tela.em;
    }

    /**
     * Sets entity manager.
     *
     * @param em the em
     */
    static public void setEntityManager(EntityManager em) {
        Tela.em = em;
    }

    /**
     * Gets manager.
     *
     * @return the manager
     */
    static public TelaManager getManager() {
        return Tela.manager;
    }

    /**
     * Sets manager.
     *
     * @param manager the manager
     */
    static public void setManager(TelaManager manager) {
        Tela.manager = manager;
    }

    /**
     * Gets circo.
     *
     * @return the circo
     */
    static public Circo getCirco() {
        return Tela.circo;
    }

    /**
     * Sets circo.
     *
     * @param circo the circo
     */
    static public void setCirco(Circo circo) {
        Tela.circo = circo;
    }

    /**
     * Trocar tela.
     *
     * @param caminho the caminho
     */
    public void trocarTela(String caminho) {
        manager.trocarTela(caminho);
    }

    /**
     * Atualizar.
     */
    public abstract void atualizar();

    /**
     * Show alert.
     *
     * @param title   the title
     * @param message the message
     */
    public void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Voltar.
     */
    @FXML
    public void voltar() {

        String tela = "";

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

    /**
     * Sair do sistema.
     */
    @FXML
    public void sairDoSistema() {
        // Sair do APP
        System.exit(0);
    }
}
