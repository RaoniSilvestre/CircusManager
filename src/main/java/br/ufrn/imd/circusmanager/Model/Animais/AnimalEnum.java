package br.ufrn.imd.circusmanager.Model.Animais;

public enum AnimalEnum {
    GIRAFA,
    LEAO,
    ORNITORRINCO, // PERRY!
    ELEFANTE,;

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
