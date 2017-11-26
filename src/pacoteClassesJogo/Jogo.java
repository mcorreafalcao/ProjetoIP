package pacoteClassesJogo;

import pacoteClassesUsuario.Usuario;

/**
 * "Classe basica"
 * 
 * @author Gabriel
 *
 */
public class Jogo extends Produto {// classe básica do projeto
	private Usuario dev;//desenvolvedor do jogo
	
	public Jogo() {//metodo com comportamento diferente da classe abstrata
		super();
		this.dev=new Usuario();
	}

	public void setDev(Usuario dev) {
		this.dev=dev;
	}
	
	public Usuario getDev() {
		return this.dev;
	}

}
