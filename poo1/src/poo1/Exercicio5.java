package poo1;

public class Exercicio5 {

    public static void main(String[] args) {

        ContaBancaria conta = new ContaBancaria(1000.0);

        try {

            System.out.println("Saldo inicial: R$ " + conta.getSaldo());

            // Saque válido
            conta.sacar(500.0);

            System.out.println(
                "Saldo após o saque: R$ " + conta.getSaldo()
            );

            // Saque inválido
            conta.sacar(700.0);

        } catch (SaldoInsuficienteException e) {

            System.out.println("Erro: " + e.getMessage());

        }
    }
}
