package controller;

import java.util.Date;
import java.text.SimpleDateFormat;

import model.Armazem;
import model.LoteMercadoria;

public class Main {
	public static void main(String[] args) throws Exception {

        Armazem armazem = new Armazem(
            1, "ARM001", "Rio de Janeiro", 5000.0
        );
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        Date validade1 = formato.parse("18/11/2028");
        Date validade2 = formato.parse("18/11/2027");
        Date validade3 = formato.parse("18/05/2026");

        LoteMercadoria lote1 = new LoteMercadoria(
        	    1, "LOT001", "Arroz", 100,
        	    validade1, armazem
        	);

        	LoteMercadoria lote2 = new LoteMercadoria(
        	    2, "LOT002", "Feijao", 200,
        	    validade2, armazem
        	);

        	LoteMercadoria lote3 = new LoteMercadoria(
        	    3, "LOT003", "Carne", 100,
        	    validade3, armazem
        	);

        System.out.println("=== ARMAZEM ===");
        System.out.println("ID: " + armazem.getId());
        System.out.println("Codigo: " + armazem.getCodigo());
        System.out.println("Cidade: " + armazem.getCidade());
        System.out.println("Capacidade: " + armazem.getCapacidadeM3());

        System.out.println("\n=== LOTE 1 ===");
        System.out.println("ID: " + lote1.getId());
        System.out.println("Numero do lote: " + lote1.getNumeroLote());
        System.out.println("Produto: " + lote1.getProduto());
        System.out.println("Quantidade: " + lote1.getQuantidade());
        System.out.println("Data de Validade: " +
        	    formato.format(lote1.getDataValidade()));
        System.out.println("Armazem: " + lote1.getArmazem().getCodigo());

        System.out.println("\n=== LOTE 2 ===");
        System.out.println("ID: " + lote2.getId());
        System.out.println("Numero do lote: " + lote2.getNumeroLote());
        System.out.println("Produto: " + lote2.getProduto());
        System.out.println("Quantidade: " + lote2.getQuantidade());
        System.out.println("Data de Validade: " +
        	    formato.format(lote2.getDataValidade()));
        System.out.println("Armazem: " + lote2.getArmazem().getCodigo());
        
        System.out.println("\n=== LOTE 3 ===");
        System.out.println("ID: " + lote3.getId());
        System.out.println("Numero do lote: " + lote3.getNumeroLote());
        System.out.println("Produto: " + lote3.getProduto());
        System.out.println("Quantidade: " + lote3.getQuantidade());
        System.out.println("Data de Validade: " +
        	    formato.format(lote3.getDataValidade()));
        System.out.println("Armazem: " + lote3.getArmazem().getCodigo());
    }

}
