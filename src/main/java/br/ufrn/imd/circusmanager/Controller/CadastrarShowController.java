package br.ufrn.imd.circusmanager.Controller;

import br.ufrn.imd.circusmanager.Model.Circus.Show;
import br.ufrn.imd.circusmanager.Model.ContaBancaria.Transacao;
import br.ufrn.imd.circusmanager.Model.ContaBancaria.Enums.TransacaoEnum;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.stream.IntStream;

public class CadastrarShowController extends Tela {

    @FXML
    private TextField totalVisitantesField;

    @FXML
    private TextField pipocasVendidasField;

    @FXML
    private TextField algodoesDocesVendidosField;

    @FXML
    private TextField brinquedosVendidosField;

    @FXML
    private TextField custosTotaisField;

    @FXML
    private TextField lucroField;

    @FXML
    private ComboBox<Integer> diaComboBox;

    @FXML
    private ComboBox<String> mesComboBox;

    @FXML
    private ComboBox<Integer> anoComboBox;

    @FXML
    public void initialize() {
        // Preencher os dias (1 a 31)
        ObservableList<Integer> dias = FXCollections.observableArrayList(
            IntStream.rangeClosed(1, 31).boxed().toList()
        );
        diaComboBox.setItems(dias);

        // Preencher os meses (1 a 12)
        ObservableList<String> meses = FXCollections.observableArrayList(
            "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", 
            "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
        );
        mesComboBox.setItems(meses);

        // Preencher os anos (1925 a 2025)
        ObservableList<Integer> anos = FXCollections.observableArrayList(
        IntStream.rangeClosed(1925, 2025).boxed().toList()
        );
        Collections.reverse(anos);
        anoComboBox.setItems(anos);
    }

    @FXML
    private void registrar() {
        try {
            // Nome do show baseado no tamanho da lista
            String nomeDoShow = "Show" + main.getCircoAtual().getListaDeShows().getShows().size();

            // Conversão dos campos numéricos
            int totalVisitantes = Integer.parseInt(totalVisitantesField.getText());
            int pipocasVendidas = Integer.parseInt(pipocasVendidasField.getText());
            int algodoesDocesVendidos = Integer.parseInt(algodoesDocesVendidosField.getText());
            int brinquedosVendidos = Integer.parseInt(brinquedosVendidosField.getText());
            double custosTotais = Double.parseDouble(custosTotaisField.getText());
            double lucro = Double.parseDouble(lucroField.getText());

            // Extração e validação da data
            Integer dia = diaComboBox.getValue();
            Integer mes = mesComboBox.getSelectionModel().getSelectedIndex() + 1; // Index começa em 0
            Integer ano = anoComboBox.getValue();

            if (dia == null || mes == null || ano == null) {
                showAlert("Erro na Data", "Por favor, selecione Dia, Mês e Ano.");
                return;
            }

            // Conversão para LocalDate
            LocalDate data = LocalDate.of(ano, mes, dia);

            // Criação do objeto Show
            Show show = new Show(nomeDoShow, totalVisitantes, pipocasVendidas, algodoesDocesVendidos, brinquedosVendidos, custosTotais, lucro, data);
            main.getCircoAtual().getListaDeShows().addShow(show);

            Transacao transacao = new Transacao(nomeDoShow, TransacaoEnum.APRESENTACOES, lucro);
            main.circoAtual.getConta().addTransacao(transacao);
            // Exibir mensagem de sucesso
            showAlert("Show registrado", "O show foi registrado com sucesso.");

            // Limpar os campos após o registro
            limpar();
            voltar();
        } catch (NumberFormatException e) {
            showAlert("Erro de Formato", "Verifique se todos os campos numéricos estão preenchidos corretamente.");
        } catch (DateTimeException e) {
            showAlert("Erro na Data", "Data inválida! Verifique os campos Dia, Mês e Ano.");
        }
    }

    private void limpar() {
        // Limpa todos os campos de entrada
        totalVisitantesField.clear();
        pipocasVendidasField.clear();
        algodoesDocesVendidosField.clear();
        brinquedosVendidosField.clear();
        custosTotaisField.clear();
        lucroField.clear();
        diaComboBox.getSelectionModel().clearSelection();
        mesComboBox.getSelectionModel().clearSelection();
        anoComboBox.getSelectionModel().clearSelection();
    }

    @Override
    public void atualizar() {
        limpar();
    }
}
