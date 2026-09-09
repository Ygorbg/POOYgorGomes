package dominio;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Missão2 {
	
	public static void main(String[] args) {
		
		List<String> fila = new LinkedList<>();
		
		fila.add("Pedido 001");
		fila.add("Pedido 002");
		fila.add("Pedido 003");
		
		fila.add(0, "Pedido 000");
		
		System.out.println("\nPrimeiro pedido: "+fila.get(0));
		System.out.println("\nSegundo pedido: "+fila.get(1));
		
		/*
         * A LinkedList apresenta vantagem em operações frequentes
         * de inserção e remoção no início da lista porque seus
         * elementos são armazenados em nós ligados entre si.
         *
         * Para inserir no início, basta ajustar as referências
         * dos nós, sem precisar deslocar todos os elementos.
         *
         * Já o ArrayList utiliza um vetor interno. Ao inserir
         * no início, os elementos posteriores precisam ser
         * deslocados para abrir espaço.
         */
		
		//Registrador de Eventos
		
		Vector<String> logs = new Vector<>();
		
		logs.add("Usuário realizou login.");
		logs.add("Produto adicionado ao carrinho.");
		logs.add("Pedido finalizdo.");
		
		System.out.println("\nLogs de auditoria:");
		
		for (String log : logs) {
			System.out.println(log);
		}
		 /*
         * Vector é uma classe synchronized, ou seja, seus
         * principais métodos são sincronizados para oferecer
         * maior segurança quando várias threads acessam a
         * estrutura simultaneamente.
         *
         * O ArrayList, por padrão, não possui essa sincronização.
         * Portanto, em situações de concorrência, o Vector pode
         * ser mais seguro para acessos simultâneos.
         *
         * Essa segurança, porém, pode gerar um custo de desempenho,
         * pois as operações sincronizadas precisam controlar o
         * acesso entre as threads.
         */
	}

}
