package br.ufrn.imd.circusmanager.Model.Funcionarios.Enums;

public enum PalhacosEnum {
    AUGUSTO("Augusto"),
    BRANCO("Branco"),
    CONTRA_AUGUSTO("Contra augusto"),
    MIMICO("Mimico");

    private final String descricao;

    PalhacosEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static PalhacosEnum fromString(String value) {
        for (PalhacosEnum palhacoEnum : values()) {
            if (palhacoEnum.descricao.equalsIgnoreCase(value)) {
                return palhacoEnum;
            }
        }
        throw new IllegalArgumentException("Valor não encontrado: " + value);
    }
}

