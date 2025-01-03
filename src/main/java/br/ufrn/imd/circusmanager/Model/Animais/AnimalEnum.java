package br.ufrn.imd.circusmanager.Model.Animais;

public enum AnimalEnum {
    GIRAFA,
    LEAO,
    ORNITORRINCO, // PERRY!
    ELEFANTE,;

    public static AnimalEnum fromString(String especieSelecionada) {
        if (especieSelecionada.equals("GIRAFA")) return GIRAFA;
        if (especieSelecionada.equals("LEÃO")) return LEAO;
        if (especieSelecionada.equals("ORNITORRINCO")) return ORNITORRINCO;
        return ELEFANTE;
        
    }
}
