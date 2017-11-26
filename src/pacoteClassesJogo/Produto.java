package pacoteClassesJogo;

/**
 * Classe abstrata feita com a intencao de utilzar herança alguma vez. A classe
 * Jogo eh subclase desta classe.
 * 
 * @author Gabriel
 *
 */
public abstract class Produto {// jogo ou (outraclassebasica) vao herdar desta classe
	private String nome;
	private String descricao;
	private double preco;


	public Produto() {// construtor
		this.nome = null;
		this.descricao = null;
		this.preco = 0.0;
		
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getPreco() {
		return this.preco;
	}


	

}
