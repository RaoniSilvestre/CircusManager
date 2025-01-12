package br.ufrn.imd.circusmanager.Model.Itens.Enums;

/**
 * The enum Item enum.
 */
public enum ItemEnum {
    /**
     * Algodao doce item enum.
     */
    ALGODAO_DOCE,
    /**
     * Pipoca item enum.
     */
    PIPOCA,
    /**
     * Palhaco de brinquedo item enum.
     */
    PALHACO_DE_BRINQUEDO,
    /**
     * Nariz vermelho item enum.
     */
    NARIZ_VERMELHO,
    /**
     * Trapezio item enum.
     */
    TRAPEZIO,
    /**
     * Bota grande item enum.
     */
    BOTA_GRANDE,
    /**
     * Cartola item enum.
     */
    CARTOLA,
    /**
     * Baralho item enum.
     */
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
