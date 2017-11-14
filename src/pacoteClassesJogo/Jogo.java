package pacoteClassesJogo;

public class Jogo extends Produto {//classe básica do projeto

	public Jogo() {
		super();
	}
	public void setNome(String nome){
		this.nome=nome;
	}
	public String getNome(){
		return this.nome;
	}
	public void setDescricao(String descricao){
		this.descricao=descricao;
	}
	public String getDescricao(){
		return this.descricao;
	}
	public void setPreco(double preco){
		this.preco=preco;
	}
	public double getPreco(){
		return this.preco;
	}
	public void setData(String data){
		this.dataLancamento=data;
	}
	public String getData(){
		return this.dataLancamento;
	}
	

}
