package model;

import java.util.Date;

public class LoteMercadoria {
	
	private int id;
    private String numeroLote;
    private String produto;
    private int quantidade;
    private Date dataValidade;
    private Armazem armazem;

    public LoteMercadoria(int id, String numeroLote,
            String produto, int quantidade,
            Date dataValidade, Armazem armazem) {

        this.id = id;
        this.numeroLote = numeroLote;
        this.produto = produto;
        this.quantidade = quantidade;
        this.dataValidade = dataValidade;
        this.armazem = armazem;
    }

    public int getId() {
        return id;
    }

    public String getNumeroLote() {
        return numeroLote;
    }

    public String getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public Armazem getArmazem() {
        return armazem;
    }

}
