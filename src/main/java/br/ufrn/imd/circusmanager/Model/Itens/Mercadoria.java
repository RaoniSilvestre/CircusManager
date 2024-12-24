package br.ufrn.imd.circusmanager.Model.Itens;

import br.ufrn.imd.circusmanager.Model.Itens.Enums.MecadoriaEnum;

public class Mercadoria extends Item {
    private MecadoriaEnum tipo;

    public Mercadoria(String nome, Long preco, MecadoriaEnum tipo) {
        super(nome, preco);
        this.tipo = tipo;
    }

    public MecadoriaEnum getTipo() {
        return tipo;
    }

    public void setTipo(MecadoriaEnum tipo) {
        this.tipo = tipo;
    }
}
