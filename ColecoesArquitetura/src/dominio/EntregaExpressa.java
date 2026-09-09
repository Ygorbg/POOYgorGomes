package dominio;

public class EntregaExpressa implements Rastreavel {
	
	@Override
	public String getStatusRastreio() {
		return "Entrega expressa: Entrega prevista para hoje.";
	}

}
