package model;

public class Armazem {
	
	private int id;
    private String codigo;
    private String cidade;
    private double capacidadeM3;

    public Armazem(int id, String codigo,
                   String cidade, double capacidadeM3) {
        this.id = id;
        this.codigo = codigo;
        this.cidade = cidade;
        this.capacidadeM3 = capacidadeM3;
    }

    public int getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCidade() {
        return cidade;
    }

    public double getCapacidadeM3() {
        return capacidadeM3;
    }

}
