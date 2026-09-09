package dominio;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Missao5 {

    public static void main(String[] args) {

        Map<String, Produtos> mapaEstoque = new HashMap<>();

        // Cadastro dos produtos
        mapaEstoque.put(
                "A001",
                new Produtos("A001", "Teclado", 150.00)
        );

        mapaEstoque.put(
                "A002",
                new Produtos("A002", "Mouse", 80.00)
        );

        mapaEstoque.put(
                "A003",
                new Produtos("A003", "Monitor", 900.00)
        );

        mapaEstoque.put(
                "A004",
                new Produtos("A004", "Headset", 250.00)
        );


        // ==========================================
        // CONSULTA POR CÓDIGO
        // ==========================================

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o código do produto: ");
        String codigo = scanner.nextLine();

        Produtos produto = mapaEstoque.get(codigo);

        if (produto != null) {
            System.out.println("Produto encontrado:");
            System.out.println(produto);
        } else {
            System.out.println("Produto não encontrado.");
        }


        // ==========================================
        // EXIBINDO AS CHAVES
        // ==========================================

        Set<String> chaves = mapaEstoque.keySet();

        System.out.println("\nCódigos cadastrados:");

        for (String chave : chaves) {
            System.out.println(chave);
        }


        // ==========================================
        // EXIBINDO OS VALORES
        // ==========================================

        Collection<Produtos> produtos = mapaEstoque.values();

        System.out.println("\nProdutos cadastrados:");

        for (Produtos p : produtos) {
            System.out.println(p);
        }

        scanner.close();
    }
}