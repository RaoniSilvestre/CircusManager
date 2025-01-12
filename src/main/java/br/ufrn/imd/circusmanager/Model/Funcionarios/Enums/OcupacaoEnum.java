package br.ufrn.imd.circusmanager.Model.Funcionarios.Enums;

/**
 * The enum Ocupacao enum.
 */
public enum OcupacaoEnum {
    /**
     * Magico ocupacao enum.
     */
    MAGICO,
    /**
     * Vendedor ocupacao enum.
     */
    VENDEDOR,
    /**
     * Trapezista ocupacao enum.
     */
    TRAPEZISTA,
    /**
     * Palhaco ocupacao enum.
     */
    PALHACO;

    @Override
    public String toString() {
        return switch (this) {
            case VENDEDOR -> "Vendedor";
            case MAGICO -> "Mágico";
            case PALHACO -> "Palhaço";
            case TRAPEZISTA -> "Trapezista";
        };
    }
}