package pacoteClassesProduto;

import pacoteClassesUsuario.Usuario;

/**
 * "Classe basica"
 * 
 * @author Gabriel
 *
 */
public class Jogo extends Produto {// classe b�sica do projeto
	double tamanhoMB;
	private double preco;
	public Jogo(String nome, String descricao, Usuario dev,double preco,double tamanhoMB) {
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
	@Override
	public String rodar(Usuario usuarioLogado) {
		usuarioLogado.setEspacoDisco(usuarioLogado.getEspacoDisco()-this.tamanhoMB);
		return "Voce jogou o jogo: " + this.getNome();
	}
}
