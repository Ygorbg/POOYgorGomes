package dominio;
public class Produto implements Comparable<Produto> {
   private String codigo;
   private String nome;
   private double preco;
   public Produto(String codigo, String nome, double preco) {
       this.codigo = codigo;
       this.nome = nome;
       this.preco = preco;
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
   public double getPreco() {
       return preco;
   }
   public void setPreco(double preco) {
       this.preco = preco;
   }
   // Implementação do contrato da interface Comparable
   @Override
   public int compareTo(Produto outro) {
       if (outro == null) {
           return 1;
       }
       // Delega para o compareToIgnoreCase da classe String (ordem alfabética)
       return this.nome.compareToIgnoreCase(outro.getNome());
   }
   @Override
   public String toString() {
       return String.format("Código: %-6s | Nome: %-20s | Preço: R$ %-7.2f", codigo, nome, preco);
   }
}
