package br.ufrn.imd.circusmanager.Model.Itens.Enums;

public enum ItemEnum {
    ALGODAO_DOCE,
    PIPOCA,
    PALHACO_DE_BRINQUEDO,
    NARIZ_VERMELHO,
    TRAPEZIO,
    BOTA_GRANDE,
    CARTOLA,
    BARALHO;

    @Override
    public String toString() {
        return switch (this) {
            case ALGODAO_DOCE -> "Algodão doce";
            case PIPOCA -> "Pipoca";
            case NARIZ_VERMELHO -> "Nariz vermelho";
            case BOTA_GRANDE -> "Bota grande";
            case TRAPEZIO -> "Trapézio";
            case BARALHO -> "Baralho";
            case CARTOLA -> "Cartola";
            case PALHACO_DE_BRINQUEDO -> "Palhaço de brinquedo";
        };
    }
}
