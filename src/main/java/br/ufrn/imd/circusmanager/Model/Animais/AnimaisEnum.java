package br.ufrn.imd.circusmanager.Model.Animais;

public enum AnimaisEnum {
    GIRAFA,
    LEAO,
    ORNITORRINCO, // PERRY!
    ELEFANTE;

    public static AnimaisEnum fromString(String especieSelecionada) {
        if (especieSelecionada.equals("GIRAFA")) return GIRAFA;
        if (especieSelecionada.equals("LEÃO")) return LEAO;
        if (especieSelecionada.equals("ELEFANTE")) return ELEFANTE;
        if (especieSelecionada.equals("ORNITORRINCO")) return ORNITORRINCO;

        throw new IllegalArgumentException("Animal desconhecido");
    }

    @Override
    public String toString() {
        return switch (this) {
            case LEAO -> "Leão";
            case GIRAFA -> "Girafa";
            case ELEFANTE -> "Elefante";
            case ORNITORRINCO -> "Ornitorrinco";
        };
    }
}
