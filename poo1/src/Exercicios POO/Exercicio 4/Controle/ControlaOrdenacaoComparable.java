package controle;
import dominio.Produto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class ControlaOrdenacaoComparable {
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
	       // Produtos inseridos propositalmente fora de ordem alfabética para teste
	       listaProdutos.add(new Produto("P01", "Webcam Full HD", 210.00));
	       listaProdutos.add(new Produto("P02", "Cadeira Gamer", 890.00));
	       listaProdutos.add(new Produto("P03", "Mousepad Speed", 45.00));
	       listaProdutos.add(new Produto("P04", "Teclado Mecânico", 320.00));
	       listaProdutos.add(new Produto("P05", "Adaptador Bluetooth", 35.00));
	       int opcao = 0;
	       do {
	           System.out.println("\n========================================");
	           System.out.println("    ORDENAÇÃO NATURAL COM COMPARABLE    ");
	           System.out.println("========================================");
	           System.out.println("1 - Inserir Novo Produto");
	           System.out.println("2 - Listar Produtos (Ordem Atual de Inserção)");
	           System.out.println("3 - Ordenar Produtos Alfabeticamente (Collections.sort)");
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
	                   System.out.println(">> Produto cadastrado com sucesso!");
	                   break;
	               case 2:
	                   exibirLista(listaProdutos, "LISTA DE PRODUTOS (ESTADO ATUAL)");
	                   break;
	               case 3:
	                   if (listaProdutos.isEmpty()) {
	                       System.out.println(">> A lista está vazia.");
	                   } else {
	                       // O método sort invoca internamente o compareTo definido na classe Produto
	                       Collections.sort(listaProdutos);
	                       System.out.println(">> Coleção reordenada com sucesso via Comparable!");
	                       exibirLista(listaProdutos, "PRODUTOS EM ORDEM ALFABÉTICA (A-Z)");
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


