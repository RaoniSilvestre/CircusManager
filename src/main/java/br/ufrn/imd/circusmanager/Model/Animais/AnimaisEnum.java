package br.ufrn.imd.circusmanager.Model.Animais;

public enum AnimaisEnum {
    GIRAFA,
    LEAO,
    ORNITORRINCO, // PERRY!
    ELEFANTE,;

    public static AnimaisEnum fromString(String especieSelecionada) {
        if (especieSelecionada.equals("GIRAFA")) return GIRAFA;
        if (especieSelecionada.equals("LEÃO")) return LEAO;
        if (especieSelecionada.equals("ORNITORRINCO")) return ORNITORRINCO;
        return ELEFANTE;

    }
}
