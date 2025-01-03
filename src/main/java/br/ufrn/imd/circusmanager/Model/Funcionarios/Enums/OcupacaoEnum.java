package br.ufrn.imd.circusmanager.Model.Funcionarios.Enums;

import br.ufrn.imd.circusmanager.Model.Funcionarios.Magico;

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