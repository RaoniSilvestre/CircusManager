package br.ufrn.imd.circusmanager.Controller;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class TelaComImagem extends Tela {
    protected String caminho = "/br/ufrn/imd/circusmanager/Imagens/CircoMenu.png";
    @FXML
    private ImageView imagemFundo;

    @FXML
    public void initialize() {
        // Carregar a imagem de fundo
        try {
        Image imagem = new Image(getClass().getResourceAsStream(caminho));
        imagemFundo.setImage(imagem);

        // Ajustar para preencher toda a tela
        imagemFundo.setFitWidth(800);  // Largura da tela (ajuste conforme necessário)
        imagemFundo.setFitHeight(600); // Altura da tela (ajuste conforme necessário)
        imagemFundo.setPreserveRatio(false); // Preencher todo o espaço, sem manter proporção
        }
        catch (NumberFormatException e) {
            System.err.println("Erro ao carregar imagem no caminho: " + caminho);
        }
    }
}
