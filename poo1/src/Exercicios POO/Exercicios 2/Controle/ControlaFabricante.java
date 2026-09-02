package controle;
import dominio.*;
import java.util.ArrayList;
import java.util.Scanner;
public class ControlaFabricante {
   public static Fabricante buscarFabricantePorCnpj(ArrayList<Fabricante> lista, String cnpj) {
       for (Fabricante f : lista) {
           if (f.getCnpj().equalsIgnoreCase(cnpj.trim())) {
               return f;
           }
       }
       return null;
   }
   public static Produto1 buscarProdutoPorCodigo(ArrayList<Produto1> lista, String codigo) {
       for (Produto1 p : lista) {
           if (p.getCodigo().equalsIgnoreCase(codigo.trim())) {
               return p;
           }
       }
       return null;
   }
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       ArrayList<Fabricante> listaFabricantes = new ArrayList<>();
       ArrayList<Produto1> listaGeralProdutos = new ArrayList<>();
       // Dados de teste iniciais
       Fabricante f1 = new Fabricante("111.222.333/0001-01", "Dell");
       Fabricante f2 = new Fabricante("444.555.666/0001-02", "Logitech");
       listaFabricantes.add(f1);
       listaFabricantes.add(f2);
       Produto1 p1 = new Produto1("P01", "Teclado K120", 89.90);
       Produto1 p2 = new Produto1("P02", "Monitor 27pol", 1250.00);
       listaGeralProdutos.add(p1);
       listaGeralProdutos.add(p2);
       // Vinculação inicial
       p1.setFabricante(f2);
       p2.setFabricante(f1);
       int opcao = 0;
       do {
           System.out.println("\n========================================");
           System.out.println("   ASSOCIAÇÃO BIDIRECIONAL FABRICANTE/PROD");
           System.out.println("========================================");
           System.out.println("1 - Cadastrar Fabricante");
           System.out.println("2 - Cadastrar Produto");
           System.out.println("3 - Alterar/Definir Fabricante de um Produto (setFabricante)");
           System.out.println("4 - Desvincular Fabricante de um Produto (setFabricante(null))");
           System.out.println("5 - Listar Produtos de um Fabricante");
           System.out.println("6 - Listar Todos os Produtos do Sistema");
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
                   System.out.print("\nInforme o CNPJ: ");
                   String cnpj = scanner.nextLine().trim();
                   if (buscarFabricantePorCnpj(listaFabricantes, cnpj) != null) {
                       System.out.println(">> CNPJ já cadastrado.");
                       break;
                   }
                   System.out.print("Informe o Nome do Fabricante: ");
                   String nomeFab = scanner.nextLine().trim();
                   listaFabricantes.add(new Fabricante(cnpj, nomeFab));
                   System.out.println(">> Fabricante cadastrado com sucesso!");
                   break;
               case 2:
                   System.out.print("\nInforme o Código do Produto: ");
                   String codProd = scanner.nextLine().trim();
                   if (buscarProdutoPorCodigo(listaGeralProdutos, codProd) != null) {
                       System.out.println(">> Código já existente.");
                       break;
                   }
                   System.out.print("Informe o Nome do Produto: ");
                   String nomeProd = scanner.nextLine().trim();
                   System.out.print("Informe o Preço: R$ ");
                   double preco = scanner.nextDouble();
                   scanner.nextLine();
                   listaGeralProdutos.add(new Produto1(codProd, nomeProd, preco));
                   System.out.println(">> Produto cadastrado (sem fabricante vinculado)!");
                   break;
               case 3:
                   System.out.print("\nInforme o Código do Produto a ser alterado: ");
                   String codAlvo = scanner.nextLine().trim();
                   Produto1 prodAlvo = buscarProdutoPorCodigo(listaGeralProdutos, codAlvo);
                   if (prodAlvo == null) {
                       System.out.println(">> Produto não localizado.");
                       break;
                   }
                   System.out.print("Informe o CNPJ do novo Fabricante: ");
                   String cnpjAlvo = scanner.nextLine().trim();
                   Fabricante fabAlvo = buscarFabricantePorCnpj(listaFabricantes, cnpjAlvo);
                   if (fabAlvo == null) {
                       System.out.println(">> Fabricante não localizado.");
                       break;
                   }
                   // A chamada abaixo orquestra a remoção do fabricante anterior e a inclusão no novo
                   prodAlvo.setFabricante(fabAlvo);
                   System.out.println(">> Associação atualizada com sucesso via produto.setFabricante()!");
                   break;
               case 4:
                   System.out.print("\nInforme o Código do Produto para desvincular: ");
                   String codDesvincular = scanner.nextLine().trim();
                   Produto1 prodDesvincular = buscarProdutoPorCodigo(listaGeralProdutos, codDesvincular);
                   if (prodDesvincular == null) {
                       System.out.println(">> Produto não localizado.");
                       break;
                   }
                   prodDesvincular.setFabricante(null);
                   System.out.println(">> Fabricante desvinculado com sucesso!");
                   break;
               case 5:
                   System.out.print("\nInforme o CNPJ do Fabricante: ");
                   String cnpjConsulta = scanner.nextLine().trim();
                   Fabricante fabConsulta = buscarFabricantePorCnpj(listaFabricantes, cnpjConsulta);
                   if (fabConsulta != null) {
                       fabConsulta.listarProdutos();
                   } else {
                       System.out.println(">> Fabricante não encontrado.");
                   }
                   break;
               case 6:
                   System.out.println("\n=== Catálogo Geral de Produtos ===");
                   if (listaGeralProdutos.isEmpty()) {
                       System.out.println("Nenhum produto cadastrado.");
                   } else {
                       for (Produto1 p : listaGeralProdutos) {
                           System.out.println(p);
                       }
                   }
                   break;
               case 0:
                   System.out.println("\nEncerrando sistema...");
                   break;
               default:
                   System.out.println("\nOpção inválida.");
                   break;
           }
       } while (opcao != 0);
       scanner.close();
   }
}


