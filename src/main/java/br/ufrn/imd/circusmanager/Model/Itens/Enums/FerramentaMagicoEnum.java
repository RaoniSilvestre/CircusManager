package br.ufrn.imd.circusmanager.Model.Itens.Enums;

public enum FerramentaMagicoEnum {
    CARTOLA,
    BARALHO;

    @Override
    public String toString() {
        return switch (this) {
            case BARALHO -> "Baralho";
            case CARTOLA -> "Cartola";
        };
    }
}
