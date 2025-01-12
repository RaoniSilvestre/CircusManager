package br.ufrn.imd.circusmanager.Model.Funcionarios.Enums;

/**
 * The enum Trapezista enum.
 */
public enum TrapezistaEnum {
    /**
     * Fixo trapezista enum.
     */
    FIXO,
    /**
     * Voador trapezista enum.
     */
    VOADOR,
    /**
     * Castin trapezista enum.
     */
    CASTIN,
    /**
     * Multiplo trapezista enum.
     */
    MULTIPLO;

    /**
     * From string trapezista enum.
     *
     * @param s the s
     * @return the trapezista enum
     * @throws IllegalArgumentException the illegal argument exception
     */
    public static TrapezistaEnum fromString(String s) throws IllegalArgumentException {
        return switch (s) {
            case "Múltiplo" -> MULTIPLO;
            default -> TrapezistaEnum.valueOf(s.toUpperCase());
        };
    }

    @Override
    public String toString() {
        return switch (this) {
            case FIXO -> "Fixo";
            case VOADOR -> "Voador";
            case CASTIN -> "Castin";
            case MULTIPLO -> "Múltiplo";
        };
    }
}
