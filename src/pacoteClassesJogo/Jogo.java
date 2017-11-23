package pacoteClassesJogo;

import pacoteClassesUsuario.Usuario;

/**
 * "Classe basica"
 * 
 * @author Gabriel
 *
 */
public class Jogo extends Produto {// classe básica do projeto

	public Jogo() {
		super();
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

	@Override
	protected void setDev(Usuario dev) {
		this.dev=dev;
		
	}

	@Override
	protected Usuario getDev() {
		// TODO Auto-generated method stub
		return this.dev;
	}

}
