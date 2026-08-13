package poo1;
import java.util.Scanner;

public class Exercicio2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] cidades = {
            "Rio de Janeiro",
            "São Paulo",
            "Niterói",
            "Belo Horizonte",
            "Salvador"
        };

        try {
            System.out.print("Digite um número de 0 a 4: ");
            int indice = scanner.nextInt();

            System.out.println("Cidade escolhida: " + cidades[indice]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro: Índice inválido. Digite um número entre 0 e 4.");

        } finally {
            scanner.close();
        }
    }
}