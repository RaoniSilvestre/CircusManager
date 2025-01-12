package br.ufrn.imd.circusmanager.Model.Funcionarios.Enums;

/**
 * The enum Palhaco enum.
 */
public enum PalhacoEnum {
    /**
     * Augusto palhaco enum.
     */
    AUGUSTO,
    /**
     * Branco palhaco enum.
     */
    BRANCO,
    /**
     * Contra augusto palhaco enum.
     */
    CONTRA_AUGUSTO,
    /**
     * Mimico palhaco enum.
     */
    MIMICO;


    /**
     * From string palhaco enum.
     *
     * @param s the s
     * @return the palhaco enum
     * @throws IllegalArgumentException the illegal argument exception
     */
    public static PalhacoEnum fromString(String s) throws IllegalArgumentException {
        return switch (s) {
            case "Contra Augusto" -> CONTRA_AUGUSTO;
            case "Augusto" -> AUGUSTO;
            case "Mímico" -> MIMICO;
            case "Branco" -> BRANCO;
            default -> throw new IllegalArgumentException();
        };
    }

    @Override
    public String toString() {
        return switch (this) {
            case CONTRA_AUGUSTO -> "Contra Augusto";
            case AUGUSTO -> "Augusto";
            case MIMICO -> "Mímico";
            case BRANCO -> "Branco";
        };
    }
}

