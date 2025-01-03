package br.ufrn.imd.circusmanager.Model.Itens;

import br.ufrn.imd.circusmanager.Model.Itens.Enums.MercadoriaEnum;

public class Mercadoria extends Item {
    private MercadoriaEnum tipo;

    public Mercadoria(String nome, Long preco, MercadoriaEnum tipo) {
        super(nome, preco);
        this.tipo = tipo;
    }

    public MercadoriaEnum getTipo() {
        return tipo;
    }

    public void setTipo(MercadoriaEnum tipo) {
        this.tipo = tipo;
    }
}
