package br.ufrn.imd.circusmanager.Controller;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

/**
 * The type Tela com imagem.
 */
public abstract class TelaComImagem extends Tela {
    /**
     * The Caminho.
     */
    protected String caminho = "/br/ufrn/imd/circusmanager/Imagens/CircoMenu.png";
    @FXML
    private ImageView imagemFundo;

    /**
     * Initialize.
     */
    @FXML
    public void initialize() {
        // Carregar a imagem de fundo
        try {
            System.out.println(caminho);
            Image imagem = new Image(Objects.requireNonNull(getClass().getResourceAsStream(caminho)));
            imagemFundo.setImage(imagem);

            // Ajustar para preencher toda a tela
            imagemFundo.setFitWidth(800);
            imagemFundo.setFitHeight(600);
            imagemFundo.setPreserveRatio(false);
        } catch (NumberFormatException e) {
            System.err.println("Erro ao carregar imagem no caminho: " + caminho);
        }
    }
}
