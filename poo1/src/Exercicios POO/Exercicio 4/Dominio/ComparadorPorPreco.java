package dominio;
import java.util.Comparator;
public class ComparadorPorPreco implements Comparator<Produto> {
   @Override
   public int compare(Produto p1, Produto p2) {
       // Double.compare retorna:
       // negativo se p1 < p2, zero se p1 == p2, positivo se p1 > p2
       return Double.compare(p1.getPreco(), p2.getPreco());
   }
}
