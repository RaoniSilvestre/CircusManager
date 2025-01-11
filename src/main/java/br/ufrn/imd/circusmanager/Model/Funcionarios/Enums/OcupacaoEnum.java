package br.ufrn.imd.circusmanager.Model.Funcionarios.Enums;

public enum OcupacaoEnum {
    MAGICO,
    VENDEDOR,
    TRAPEZISTA,
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