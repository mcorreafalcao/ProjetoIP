package pacoteClassesJogo;

import pacoteClassesUsuario.Usuario;

/**
 * Classe abstrata feita com a intencao de utilzar herança alguma vez. A classe
 * Jogo eh subclase desta classe.
 * 
 * @author Gabriel
 *
 */
public abstract class Produto {// jogo ou software vao herdar desta classe
	protected String nome;
	protected String descricao;
	protected double preco;
	protected Usuario dev;

	public Produto() {// construtor
		this.nome = null;
		this.descricao = null;
		this.preco = 0.0;
		this.dev=new Usuario();
	}

	protected abstract void setNome(String nome);

	protected abstract String getNome();

	protected abstract void setDescricao(String descricao);

	protected abstract String getDescricao();

	protected abstract void setPreco(double preco);

	protected abstract double getPreco();

	protected abstract void setDev(Usuario dev );

	protected abstract Usuario getDev();

}
