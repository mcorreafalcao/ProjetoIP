package pacoteClassesProduto;

import pacoteClassesUsuario.Usuario;

/**
 * "Classe basica"
 * 
 * @author Gabriel
 *
 */
public class Jogo extends Produto {// classe básica do projeto
	
	private double preco;
	public Jogo(String nome, String descricao, Usuario dev,double preco) {
		super(nome, descricao, dev);
		this.preco = preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getPreco() {
		return this.preco;
	}
	@Override
	public String getInfo() {
		String info = "Tísulo: "+this.getNome()+
				"\nDescrição: "+this.getDescricao()+
				"\nDesenvolvedor: "+this.getDev().getNick()+
				"\nPreço: "+this.preco;
		
		return info;
	}
	
}
