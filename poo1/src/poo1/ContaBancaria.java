package poo1;

public class ContaBancaria {

    private double saldo;

    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public void sacar(double valor) {

        if (valor > saldo) {
            throw new SaldoInsuficienteException(
                "Saldo insuficiente para realizar o saque."
            );
        }

        saldo -= valor;

        System.out.println("Saque realizado com sucesso.");
    }
}