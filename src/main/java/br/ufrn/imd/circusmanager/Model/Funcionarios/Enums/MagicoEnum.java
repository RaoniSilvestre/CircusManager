package br.ufrn.imd.circusmanager.Model.Funcionarios.Enums;

import br.ufrn.imd.circusmanager.Model.Funcionarios.Magico;

public enum MagicoEnum {
    ILUSIONISTA,
    INFANTIL,
    CLASSICO;

    @Override
    public String toString() {
        return switch(this) {
            case CLASSICO -> "Clássico";
            case INFANTIL -> "Infantil";
            case ILUSIONISTA -> "Ilusionista";
        };
    }

    public static MagicoEnum fromString(String s) throws IllegalArgumentException {
        return switch (s) {
            case "Clássico" -> CLASSICO;
            default -> MagicoEnum.valueOf(s.toUpperCase());
        };
    }
}
