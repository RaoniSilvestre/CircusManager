package br.ufrn.imd.circusmanager.Model.Itens;

import br.ufrn.imd.circusmanager.Model.Itens.Enums.FerramentaEnum;

public class Ferramenta extends Item {
    private FerramentaEnum tipo;

    public Ferramenta(String nome, Long preco, FerramentaEnum tipo) {
        super(nome, preco);
        this.tipo = tipo;
    }

    public FerramentaEnum getTipo() {
        return tipo;
    }

    public void setTipo(FerramentaEnum tipo) {
        this.tipo = tipo;
    }
}
