package br.ufrn.imd.circusmanager.Model.Circus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * The type Show.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "circo_id", referencedColumnName = "id")
    private Circo circo;

    private String nome;

    private int totalVisitantes;
    private int pipocasVendidas;
    private int algodoesDocesVendidos;
    private int brinquedosVendidos;
    private double custosTotais;
    private double lucroTotal;

    private String data;


    /**
     * Instantiates a new Show.
     */
    public Show() {
    }

    /**
     * Instantiates a new Show.
     *
     * @param nomeDoShow            the nome do show
     * @param totalVisitantes       the total visitantes
     * @param pipocasVendidas       the pipocas vendidas
     * @param algodoesDocesVendidos the algodoes doces vendidos
     * @param brinquedosVendidos    the brinquedos vendidos
     * @param custosTotais          the custos totais
     * @param lucro                 the lucro
     * @param data                  the data
     */
    public Show(
            String nomeDoShow,
            int totalVisitantes,
            int pipocasVendidas,
            int algodoesDocesVendidos,
            int brinquedosVendidos,
            double custosTotais,
            double lucro,
            LocalDate data
    ) {
        this.nome = nomeDoShow;
        this.totalVisitantes = totalVisitantes;
        this.pipocasVendidas = pipocasVendidas;
        this.algodoesDocesVendidos = algodoesDocesVendidos;
        this.brinquedosVendidos = brinquedosVendidos;
        this.custosTotais = custosTotais;
        this.lucroTotal = lucro;
        this.data = data.toString();
    }

    @Override
    public String toString() {
        return String.format("Nome do Show: %s ;\nTotal de visitantes: %d;\nCusto Total: R$ %.2f ; Lucro: R$ %.2f ;\nData: %s",
                nome, totalVisitantes, custosTotais, lucroTotal, data);
    }

}
