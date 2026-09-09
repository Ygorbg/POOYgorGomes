package dominio;

public class CupomDesconto {
	
	private String codigo;
	private double porcentagem;
	
	public CupomDesconto(String codigo, double porcentagem) {
		this.codigo=codigo;
		this.porcentagem=porcentagem;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public double getPorcentagem() {
		return porcentagem;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this==obj) {
			return true;
		}
		
		if (obj==null || getClass() != obj.getClass()) {
			return false;
		}
		
		CupomDesconto outro = (CupomDesconto) obj;
		
		return codigo.equals(outro.codigo);
	}
	
	@Override
	public int hashCode() {
		return codigo.hashCode();
	}
	
	@Override
	public String toString() {
		return "Cupom: " + codigo + "-" + porcentagem + "%";
	}

}
