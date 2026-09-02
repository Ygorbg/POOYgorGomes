package dominio;
import java.util.ArrayList;
public class Produto {
   private String codigo;
   private String nome;
   private double precoBase;
   // Atributo de relacionamento N-ário (Item)
   private ArrayList<Item> listaItens;
   public Produto(String codigo, String nome, double precoBase) {
       this.codigo = codigo;
       this.nome = nome;
       this.precoBase = precoBase;
       this.listaItens = new ArrayList<>();
   }
   public String getCodigo() {
       return codigo;
   }
   public void setCodigo(String codigo) {
       this.codigo = codigo;
   }
   public String getNome() {
       return nome;
   }
   public void setNome(String nome) {
       this.nome = nome;
   }
   public double getPrecoBase() {
       return precoBase;
   }
   public void setPrecoBase(double precoBase) {
       this.precoBase = precoBase;
   }
   public ArrayList<Item> getListaItens() {
       return listaItens;
   }
   public void addItem(Item item) {
       if (item != null && !this.listaItens.contains(item)) {
           this.listaItens.add(item);
       }
   }
   public void removeItem(Item item) {
       if (item != null && this.listaItens.contains(item)) {
           this.listaItens.remove(item);
       }
   }
   @Override
   public String toString() {
       return String.format("Código: %-5s | Nome: %-15s | Preço Base: R$ %-7.2f", codigo, nome, precoBase);
   }
}
