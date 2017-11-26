package pacoteClassesProduto;

import pacoteClassesUsuario.Usuario;

/**
 * "Classe basica"
 * 
 * @author Gabriel
 *
 */
public class Jogo extends Produto {// classe b�sica do projeto
	
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
		String info = "T�sulo: "+this.getNome()+
				"\nDescri��o: "+this.getDescricao()+
				"\nDesenvolvedor: "+this.getDev().getNick()+
				"\nPre�o: "+this.preco;
		
		return info;
	}
	
}
