package poo1;

public class Exercicio4 {

    public static void main(String[] args) {

        String texto = "abc";

        try {
            int numero = converterParaInteiro(texto);

            System.out.println("Número convertido: " + numero);

        } catch (NumberFormatException e) {
            System.out.println("Erro: O texto informado não pode ser convertido para inteiro.");
        }
    }

    public static int converterParaInteiro(String texto)
            throws NumberFormatException {

        return Integer.parseInt(texto);
    }
}