package br.ufrn.imd.circusmanager.Model.Itens;

import br.ufrn.imd.circusmanager.Model.Itens.Enums.ItemEnum;

import java.util.ArrayList;

/**
 * The type Item factory.
 */
public class ItemFactory {

    /**
     * Get palhaço itens array list.
     *
     * @return the array list
     */
    public static ArrayList<Item> getPalhaçoItens() {
        ArrayList<Item> itensPalhaço = new ArrayList<>();

        itensPalhaço.add(new Item(ItemEnum.NARIZ_VERMELHO, 15L));
        itensPalhaço.add(new Item(ItemEnum.BOTA_GRANDE, 40L));

        return itensPalhaço;
    }


    /**
     * Gets vendedor itens.
     *
     * @return the vendedor itens
     */
    public static ArrayList<Item> getVendedorItens() {
        ArrayList<Item> itens = new ArrayList<>();

        itens.add(new Item(ItemEnum.ALGODAO_DOCE, 5L));
        itens.add(new Item(ItemEnum.PALHACO_DE_BRINQUEDO, 40L));
        itens.add(new Item(ItemEnum.PIPOCA, 5L));

        return itens;
    }


    /**
     * Gets trapezista itens.
     *
     * @return the trapezista itens
     */
    public static ArrayList<Item> getTrapezistaItens() {
        ArrayList<Item> itens = new ArrayList<>();

        itens.add(new Item(ItemEnum.TRAPEZIO, 90L));

        return itens;
    }


    /**
     * Gets magico itens.
     *
     * @return the magico itens
     */
    public static ArrayList<Item> getMagicoItens() {
        ArrayList<Item> itens = new ArrayList<>();

        itens.add(new Item(ItemEnum.CARTOLA, 50L));
        itens.add(new Item(ItemEnum.BARALHO, 10L));

        return itens;
    }
}
