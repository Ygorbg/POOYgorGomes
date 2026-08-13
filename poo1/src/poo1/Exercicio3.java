package poo1;

import java.util.Scanner;

public class Exercicio3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite sua idade: ");
            int idade = scanner.nextInt();

            validarIdade(idade);

            System.out.println("Idade válida: " + idade);

        } catch (IdadeInvalidaException e) {
            System.out.println("Erro: " + e.getMessage());

        } finally {
            scanner.close();
        }
    }

    public static void validarIdade(int idade) {

        if (idade < 0 || idade > 150) {
            throw new IdadeInvalidaException(
                "A idade deve estar entre 0 e 150 anos."
            );
        }
    }
}