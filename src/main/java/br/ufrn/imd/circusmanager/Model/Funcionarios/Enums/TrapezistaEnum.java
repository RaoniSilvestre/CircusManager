package br.ufrn.imd.circusmanager.Model.Funcionarios.Enums;

public enum TrapezistaEnum {
    FIXO,
    VOADOR,
    CASTIN,
    MULTIPLO;

    @Override
    public String toString() {
        return switch (this) {
            case FIXO -> "Fixo";
            case VOADOR -> "Voador";
            case CASTIN -> "Castin";
            case MULTIPLO -> "Múltiplo";
        };
    }
}
