package pacoteClassesProduto;

import pacoteClassesUsuario.Usuario;

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
	private Usuario dev;// desenvolvedor do jogo


	public Produto(String nome,String descricao,Usuario dev ) {// construtor
		this.nome = nome;
		this.descricao = descricao;
		this.dev = dev;
		
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

	
	public void setDev(Usuario dev) {
		this.dev = dev;
	}

	public Usuario getDev() {
		return this.dev;
	}

	
	public abstract String getInfo();//pegará as informacoes do produto (jogo ou demo) para mostrar após a tela de selecao da interface

	

}
