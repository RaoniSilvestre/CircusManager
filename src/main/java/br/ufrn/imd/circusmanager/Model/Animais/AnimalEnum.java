package br.ufrn.imd.circusmanager.Model.Animais;

/**
 * The enum Animal enum.
 */
public enum AnimalEnum {
    /**
     * Girafa animal enum.
     */
    GIRAFA,
    /**
     * Leao animal enum.
     */
    LEAO,
    /**
     * Ornitorrinco animal enum.
     */
    ORNITORRINCO, // PERRY!
    /**
     * Elefante animal enum.
     */
    ELEFANTE,
    ;

    @Override
    public String toString() {
        return switch (this) {
            case ORNITORRINCO -> "Ornitorrinco";
            case ELEFANTE -> "Elefante";
            case GIRAFA -> "Girafa";
            case LEAO -> "Leão";
        };
    }
}
