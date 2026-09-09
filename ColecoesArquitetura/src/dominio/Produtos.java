package dominio;

public class Produtos {
	private String codigo;
    private String nome;
    private double preco;

    public Produtos(String codigo, String nome, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return codigo + " - " + nome + " - R$ " + preco;
    }
}