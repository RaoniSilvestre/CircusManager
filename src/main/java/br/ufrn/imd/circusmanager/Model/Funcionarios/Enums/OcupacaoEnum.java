package br.ufrn.imd.circusmanager.Model.Funcionarios.Enums;

public enum Ocupacao {
    MAGICO,
    TRAPEZISTA,
    PALHACO;

    @Override
    public String toString() {
        return switch (this) {
            case MAGICO -> "Mágico";
            case PALHACO -> "Palhaço";
            case TRAPEZISTA -> "Trapezista";
        };
    }
}
