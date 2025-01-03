package br.ufrn.imd.circusmanager.Model.Funcionarios.Enums;

public enum PalhacoEnum {
    AUGUSTO,
    BRANCO,
    CONTRA_AUGUSTO,
    MIMICO;


    @Override
    public String toString() {
        return switch (this) {
            case CONTRA_AUGUSTO -> "Contra Augusto";
            case AUGUSTO -> "Augusto";
            case MIMICO -> "Mímico";
            case BRANCO -> "Branco";
        };
    }

    public static PalhacoEnum fromString(String s) throws IllegalArgumentException {
         return switch (s) {
            case "Contra Augusto" ->  CONTRA_AUGUSTO;
            case "Augusto" -> AUGUSTO;
            case "Mímico" -> MIMICO;
            case "Branco" -> BRANCO;
            default -> throw new IllegalArgumentException();
        };
    }
}

