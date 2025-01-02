package br.ufrn.imd.circusmanager.Model.Funcionarios.Enums;

public enum MagicoEnum {
    CLASSICO,
    ILUSIONISTA,
    INFANTIL;

    @Override
    public String toString() {
        return switch (this) {
            case CLASSICO -> "Clássico";
            case ILUSIONISTA -> "Ilusionista";
            case INFANTIL -> "Infantil";
        };
    }
}
