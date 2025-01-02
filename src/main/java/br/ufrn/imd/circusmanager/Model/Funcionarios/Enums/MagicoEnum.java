package br.ufrn.imd.circusmanager.Model.Funcionarios.Enums;

public enum MagicoEnum {
    ILUSIONISTA("Ilusionista"),
    INFANTIL("Infantil"),
    CLASSICO("Classico");

    private final String descricao;

    MagicoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static MagicoEnum fromString(String value) {
        for (MagicoEnum magicoEnum : values()) {
            if (magicoEnum.descricao.equalsIgnoreCase(value)) {
                return magicoEnum;
            }
        }
        throw new IllegalArgumentException("Valor não encontrado: " + value);
    }
}
