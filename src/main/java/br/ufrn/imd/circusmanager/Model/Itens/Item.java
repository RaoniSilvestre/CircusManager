package br.ufrn.imd.circusmanager.Model.Itens;

import br.ufrn.imd.circusmanager.Model.Itens.Enums.ItemEnum;

public class Item {
    private ItemEnum tipo;
    private Long valor;

    protected Item(ItemEnum tipo, Long valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public ItemEnum getTipo() {
        return tipo;
    }

    public void setTipo(ItemEnum tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return tipo.toString() + " (R$ " + valor + ")";
    }
}
