package dominio;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Missao3 {

    public static void limparCupons(Set<CupomDesconto> conjuntoCupons) {

        // Iterator permite percorrer e remover com segurança
        Iterator<CupomDesconto> it = conjuntoCupons.iterator();

        while (it.hasNext()) {

            CupomDesconto cupom = it.next();

            if (cupom.getPorcentagem() == 0) {
                it.remove();
            }
        }
    }

    public static void main(String[] args) {

        Set<CupomDesconto> conjuntoCupons = new HashSet<>();

        CupomDesconto cupom1 = new CupomDesconto("PROMO10", 10);
        CupomDesconto cupom2 = new CupomDesconto("PROMO20", 20);

        // Mesmo código do cupom1
        CupomDesconto cupom3 = new CupomDesconto("PROMO10", 50);

        // Cupom com porcentagem igual a zero
        CupomDesconto cupom4 = new CupomDesconto("PROMO0", 0);

        System.out.println("Adicionando cupom 1: "
                + conjuntoCupons.add(cupom1));

        System.out.println("Adicionando cupom 2: "
                + conjuntoCupons.add(cupom2));

        System.out.println("Adicionando cupom 3: "
                + conjuntoCupons.add(cupom3));

        System.out.println("Adicionando cupom 4: "
                + conjuntoCupons.add(cupom4));

        System.out.println("\nCupons cadastrados:");
        for (CupomDesconto cupom : conjuntoCupons) {
            System.out.println(cupom);
        }

        limparCupons(conjuntoCupons);

        System.out.println("\nApós a limpeza:");
        for (CupomDesconto cupom : conjuntoCupons) {
            System.out.println(cupom);
        }
    }
}