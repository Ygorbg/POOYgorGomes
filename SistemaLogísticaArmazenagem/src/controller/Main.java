package controller;

import java.util.Date;

import model.Armazem;
import model.LoteMercadoria;

public class Main {
	public static void main(String[] args) {

        Armazem armazem = new Armazem(
            1, "ARM001", "Rio de Janeiro", 5000.0
        );

        LoteMercadoria lote1 = new LoteMercadoria(
            1, "LOT001", "Arroz", 100,
            new Date(), armazem
        );

        LoteMercadoria lote2 = new LoteMercadoria(
            2, "LOT002", "Feijao", 200,
            new Date(), armazem
        );

        System.out.println("Armazem: " +
            lote1.getArmazem().getCodigo());

        System.out.println("Produto: " +
            lote1.getProduto());

        System.out.println("Produto: " +
            lote2.getProduto());
    }

}
