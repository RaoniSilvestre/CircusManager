package br.ufrn.imd.circusmanager.Model.Funcionarios.Enums;

public enum TrapezistaEnum {
    FIXO("FIXO"),
    VOADOR("VOADOR"),
    CASTIN("CASTIN"),
    MULTIPLO("MULTIPLO");

    private final String descricao;

    TrapezistaEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TrapezistaEnum fromString(String value) {
        for (TrapezistaEnum trapezistaEnum : values()) {
            if (trapezistaEnum.descricao.equalsIgnoreCase(value)) {
                return trapezistaEnum;
            }
        }
        throw new IllegalArgumentException("Valor não encontrado: " + value);
    }
}
