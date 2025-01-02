package br.ufrn.imd.circusmanager.Model.Funcionarios.Enums;

public enum TrapezistaEnum {
    FIXO,
    VOADOR,
    CASTININ,
    MULTIPLO;

    @Override
    public String toString() {
        return switch (this) {
            case FIXO -> "Fixo";
            case CASTININ -> "Castinin";
            case MULTIPLO -> "Múltiplo";
            case VOADOR -> "Voador";
        };
    }
}
