package dominio;

import java.util.TreeSet;

public class Missao04 {

    public static void main(String[] args) {

        // ==========================================
        // ORDENAÇÃO NATURAL - PELO NOME
        // ==========================================

        TreeSet<Produto> catalogoNatural = new TreeSet<>();

        catalogoNatural.add(new Produto("Teclado", 150.00));
        catalogoNatural.add(new Produto("Mouse", 80.00));
        catalogoNatural.add(new Produto("Monitor", 900.00));
        catalogoNatural.add(new Produto("Headset", 250.00));

        System.out.println("Catálogo ordenado por nome:");

        for (Produto produto : catalogoNatural) {
            System.out.println(produto);
        }


        // ==========================================
        // ORDENAÇÃO PERSONALIZADA - PELO PREÇO
        // ==========================================

        TreeSet<Produto> catalogoPreco =
                new TreeSet<>(new ComparadorPorPreco());

        catalogoPreco.add(new Produto("Teclado", 150.00));
        catalogoPreco.add(new Produto("Mouse", 80.00));
        catalogoPreco.add(new Produto("Monitor", 900.00));
        catalogoPreco.add(new Produto("Headset", 250.00));

        System.out.println("\nCatálogo ordenado por preço:");

        for (Produto produto : catalogoPreco) {
            System.out.println(produto);
        }
    }
}