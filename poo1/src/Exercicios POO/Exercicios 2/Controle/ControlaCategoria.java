package controle;
import dominio.*;
import java.util.ArrayList;
import java.util.Scanner;
public class ControlaCategoria {
	 // Método utilitário para localizar uma categoria por ID
	   public static Categoria buscarCategoriaPorId(ArrayList<Categoria> categorias, int id) {
	       for (Categoria c : categorias) {
	           if (c.getId() == id) {
	               return c;
	           }
	       }
	       return null;
	   }
	   // Método utilitário para localizar um produto por código
	   public static Produto1 buscarProdutoPorCodigo(ArrayList<Produto1> produtos, String codigo) {
	       for (Produto1 p : produtos) {
	           if (p.getCodigo().equalsIgnoreCase(codigo.trim())) {
	               return p;
	           }
	       }
	       return null;
	   }
	   public static void main(String[] args) {
	       Scanner scanner = new Scanner(System.in);
	      
	       ArrayList<Categoria> listaCategorias = new ArrayList<>();
	       ArrayList<Produto1> listaGeralProdutos = new ArrayList<>();
	       // Dados iniciais para agilizar os testes
	       Categoria cat1 = new Categoria(1, "Informática");
	       Categoria cat2 = new Categoria(2, "Eletrodomésticos");
	       listaCategorias.add(cat1);
	       listaCategorias.add(cat2);
	       Produto1 p1 = new Produto1("INF01", "Teclado Mecânico", 250.00);
	       Produto1 p2 = new Produto1("INF02", "Mouse Sem Fio", 110.00);
	       Produto1 p3 = new Produto1("ELE01", "Cafeteira Elétrica", 189.90);
	       listaGeralProdutos.add(p1);
	       listaGeralProdutos.add(p2);
	       listaGeralProdutos.add(p3);
	       // Associações iniciais
	       cat1.adicionarProduto(p1);
	       cat1.adicionarProduto(p2);
	       cat2.adicionarProduto(p3);
	       int opcao = 0;
	       do {
	           System.out.println("\n========================================");
	           System.out.println("   GERENCIAMENTO DE CATEGORIAS E PRODUTOS");
	           System.out.println("========================================");
	           System.out.println("1 - Cadastrar Nova Categoria");
	           System.out.println("2 - Cadastrar Novo Produto");
	           System.out.println("3 - Associar Produto a uma Categoria");
	           System.out.println("4 - Remover Produto de uma Categoria");
	           System.out.println("5 - Listar Produtos por Categoria");
	           System.out.println("6 - Listar Todas as Categorias");
	           System.out.println("0 - Sair");
	           System.out.print("Escolha uma opção: ");
	           if (scanner.hasNextInt()) {
	               opcao = scanner.nextInt();
	               scanner.nextLine();
	           } else {
	               System.out.println("Entrada inválida! Digite um número.");
	               scanner.nextLine();
	               continue;
	           }
	           switch (opcao) {
	               case 1:
	                   System.out.println("\n--- Nova Categoria ---");
	                   System.out.print("ID da Categoria: ");
	                   int idCat = scanner.nextInt();
	                   scanner.nextLine();
	                   if (buscarCategoriaPorId(listaCategorias, idCat) != null) {
	                       System.out.println(">> Erro: Já existe uma categoria com este ID.");
	                       break;
	                   }
	                   System.out.print("Descrição da Categoria: ");
	                   String desc = scanner.nextLine();
	                   listaCategorias.add(new Categoria(idCat, desc));
	                   System.out.println(">> Categoria criada com sucesso!");
	                   break;
	               case 2:
	                   System.out.println("\n--- Novo Produto ---");
	                   System.out.print("Código: ");
	                   String cod = scanner.nextLine();
	                   if (buscarProdutoPorCodigo(listaGeralProdutos, cod) != null) {
	                       System.out.println(">> Erro: Já existe um produto com este código.");
	                       break;
	                   }
	                   System.out.print("Nome: ");
	                   String nome = scanner.nextLine();
	                   System.out.print("Preço: R$ ");
	                   double preco = scanner.nextDouble();
	                   scanner.nextLine();
	                   listaGeralProdutos.add(new Produto1(cod, nome, preco));
	                   System.out.println(">> Produto cadastrado no catálogo geral!");
	                   break;
	               case 3:
	                   System.out.println("\n--- Associar Produto a Categoria ---");
	                   System.out.print("Informe o ID da Categoria de destino: ");
	                   int idDestino = scanner.nextInt();
	                   scanner.nextLine();
	                   Categoria categoriaDestino = buscarCategoriaPorId(listaCategorias, idDestino);
	                   if (categoriaDestino == null) {
	                       System.out.println(">> Categoria não encontrada.");
	                       break;
	                   }
	                   System.out.print("Informe o Código do Produto a ser vinculado: ");
	                   String codProd = scanner.nextLine();
	                   Produto1 prodVincular = buscarProdutoPorCodigo(listaGeralProdutos, codProd);
	                   if (prodVincular == null) {
	                       System.out.println(">> Produto não encontrado no catálogo.");
	                       break;
	                   }
	                   categoriaDestino.adicionarProduto(prodVincular);
	                   break;
	               case 4:
	                   System.out.println("\n--- Remover Produto de Categoria ---");
	                   System.out.print("Informe o ID da Categoria: ");
	                   int idOrigem = scanner.nextInt();
	                   scanner.nextLine();
	                   Categoria catOrigem = buscarCategoriaPorId(listaCategorias, idOrigem);
	                   if (catOrigem == null) {
	                       System.out.println(">> Categoria não encontrada.");
	                       break;
	                   }
	                   System.out.print("Informe o Código do Produto a desvincular: ");
	                   String codRemover = scanner.nextLine();
	                   Produto1 prodRemover = buscarProdutoPorCodigo(catOrigem.getListaProdutos(), codRemover);
	                   if (prodRemover == null) {
	                       System.out.println(">> Produto não encontrado nesta categoria.");
	                       break;
	                   }
	                   catOrigem.removerProduto(prodRemover);
	                   break;
	               case 5:
	                   System.out.println("\n--- Consultar Categoria ---");
	                   System.out.print("Informe o ID da Categoria: ");
	                   int idConsulta = scanner.nextInt();
	                   scanner.nextLine();
	                   Categoria catConsulta = buscarCategoriaPorId(listaCategorias, idConsulta);
	                   if (catConsulta != null) {
	                       catConsulta.listarProdutos();
	                   } else {
	                       System.out.println(">> Categoria não encontrada.");
	                   }
	                   break;
	               case 6:
	                   System.out.println("\n=== Categorias Cadastradas ===");
	                   if (listaCategorias.isEmpty()) {
	                       System.out.println("Nenhuma categoria cadastrada.");
	                   } else {
	                       for (Categoria c : listaCategorias) {
	                           System.out.println("ID: " + c.getId() + " | Descrição: " + c.getDescricao() + " (" + c.getListaProdutos().size() + " produtos)");
	                       }
	                   }
	                   break;
	               case 0:
	                   System.out.println("\nEncerrando o sistema...");
	                   break;
	               default:
	                   System.out.println("\nOpção inválida!");
	                   break;
	           }
	       } while (opcao != 0);
	       scanner.close();
	   }
	}