package br.ufrn.imd.circusmanager.Model.Funcionarios.Enums;

/**
 * The enum Magico enum.
 */
public enum MagicoEnum {
    /**
     * Ilusionista magico enum.
     */
    ILUSIONISTA,
    /**
     * Infantil magico enum.
     */
    INFANTIL,
    /**
     * Classico magico enum.
     */
    CLASSICO;

    /**
     * From string magico enum.
     *
     * @param s the s
     * @return the magico enum
     * @throws IllegalArgumentException the illegal argument exception
     */
    public static MagicoEnum fromString(String s) throws IllegalArgumentException {
        return switch (s) {
            case "Clássico" -> CLASSICO;
            default -> MagicoEnum.valueOf(s.toUpperCase());
        };
    }

    @Override
    public String toString() {
        return switch (this) {
            case CLASSICO -> "Clássico";
            case INFANTIL -> "Infantil";
            case ILUSIONISTA -> "Ilusionista";
        };
    }
}
