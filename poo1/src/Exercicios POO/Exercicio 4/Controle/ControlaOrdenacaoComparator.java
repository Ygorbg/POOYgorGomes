package controle;
import dominio.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ControlaOrdenacaoComparator {

    public static void exibirLista(ArrayList<Produto> lista, String titulo) {
        System.out.println("\n=== " + titulo + " ===");
        if (lista.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            for (int i = 0; i < lista.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + lista.get(i));
            }
            System.out.println("Total de itens: " + lista.size());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Produto> listaProdutos = new ArrayList<>();

        // Produtos de teste inseridos fora de ordem
        listaProdutos.add(new Produto("C09", "Monitor 24pol", 899.90));
        listaProdutos.add(new Produto("A02", "Cabo HDMI 2.0", 29.90));
        listaProdutos.add(new Produto("B05", "Teclado Mecânico", 250.00));
        listaProdutos.add(new Produto("D01", "Mouse Gamer", 120.00));
        listaProdutos.add(new Produto("A01", "Mousepad Speed", 45.00));

        int opcao = 0;
        do {
            System.out.println("\n========================================");
            System.out.println("    ORDENAÇÃO DINÂMICA COM COMPARATOR   ");
            System.out.println("========================================");
            System.out.println("1 - Inserir Novo Produto");
            System.out.println("2 - Listar Produtos (Ordem Atual)");
            System.out.println("3 - Ordenar por Menor Preço (Preço Crescente)");
            System.out.println("4 - Ordenar por Maior Preço (Preço Decrescente)");
            System.out.println("5 - Ordenar por Código (A-Z)");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Entrada inválida!");
                scanner.nextLine();
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("\nInforme o Código: ");
                    String cod = scanner.nextLine().trim();

                    System.out.print("Informe o Nome: ");
                    String nome = scanner.nextLine().trim();

                    System.out.print("Informe o Preço: R$ ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine();

                    listaProdutos.add(new Produto(cod, nome, preco));
                    System.out.println(">> Produto adicionado com sucesso!");
                    break;

                case 2:
                    exibirLista(listaProdutos, "LISTAGEM ATUAL DA LISTA");
                    break;

                case 3:
                    if (listaProdutos.isEmpty()) {
                        System.out.println(">> Lista vazia.");
                    } else {
                        // Ordenação pelo Comparador customizado de Preço
                        Collections.sort(listaProdutos, new ComparadorPorPreco());
                        System.out.println(">> Lista ordenada por Preço Crescente!");
                        exibirLista(listaProdutos, "PRODUTOS DO MAIS BARATO AO MAIS CARO");
                    }
                    break;

                case 4:
                    if (listaProdutos.isEmpty()) {
                        System.out.println(">> Lista vazia.");
                    } else {
                        // Inverte a regra do Comparador usando Collections.reverseOrder()
                        Collections.sort(listaProdutos, Collections.reverseOrder(new ComparadorPorPreco()));
                        System.out.println(">> Lista ordenada por Preço Decrescente!");
                        exibirLista(listaProdutos, "PRODUTOS DO MAIS CARO AO MAIS BARATO");
                    }
                    break;

                case 5:
                    if (listaProdutos.isEmpty()) {
                        System.out.println(">> Lista vazia.");
                    } else {
                        // Ordenação pelo Comparador customizado de Código
                        Collections.sort(listaProdutos, new ComparadorPorCodigo());
                        System.out.println(">> Lista ordenada por Código!");
                        exibirLista(listaProdutos, "PRODUTOS ORDENADOS POR CÓDIGO");
                    }
                    break;

                case 0:
                    System.out.println("\nEncerrando o programa...");
                    break;

                default:
                    System.out.println("\nOpção inválida!");
                    break;
            }

        } while (opcao != 0);

        scanner.close();
    }
}

