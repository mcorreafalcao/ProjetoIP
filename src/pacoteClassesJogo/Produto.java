package pacoteClassesJogo;

public abstract class Produto {//jogo ou software vao herdar desta classe
	protected String nome;
	protected String descricao;
	protected double preco;
	protected String dataLancamento;
	//private String nomeDistribuidora;
	//private String nomeDesenvolvedora;
	//private Lista categorias;//ou tags 
	
	public Produto() {//construtor
		this.nome=null;
		this.descricao=null;
		this.preco=0.0;
		this.dataLancamento=null;
	}
	protected abstract void setNome(String nome);
	protected abstract String getNome();
	protected abstract void setDescricao(String descricao);
	protected abstract String getDescricao();
	protected abstract void setPreco(double preco);
	protected abstract double getPreco();
	protected abstract void setData(String data);
	protected abstract String getData();

	
}
