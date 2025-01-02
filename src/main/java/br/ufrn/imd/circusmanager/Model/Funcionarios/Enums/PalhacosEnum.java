package br.ufrn.imd.circusmanager.Model.Funcionarios.Enums;

public enum PalhacosEnum {
    AUGUSTO,
    BRANCO,
    CONTRA_AUGUSTO,
    MIMICO;

    @Override
    public String toString() {
        return switch (this) {
            case BRANCO -> "Branco";
            case MIMICO -> "Mímico";
            case AUGUSTO -> "Augusto";
            case CONTRA_AUGUSTO -> "Contra augusto";
        };
    }
}

