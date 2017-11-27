package pacoteClassesUsuario;

import pacoteExcecoes.UJCException;
import pacoteExcecoes.UNCException;

/**
 * "classe colecao de dados array"
 * classe que contem um array de usuarios e metodos da interface implementada
 * 
 * @author Gabriel
 *
 */
public class RepositorioUsuariosArray implements RepositorioUsuarios {

	private Usuario[] usuarios;
	private int indice;

	public RepositorioUsuariosArray() {
		usuarios = new Usuario[20];
		indice = 0;
	}

	@Override
	public void inserir(Usuario usuario) throws UJCException {
		if (!this.existe(usuario.getNick()) && this.indice < this.usuarios.length - 1) {
			this.usuarios[indice] = usuario;
			this.indice++;
		} else {
			throw new UJCException();
		}

	}

	@Override
	public void remover(String nomeUsuario) throws UNCException {
		boolean encontrou = false;
		for (int i = 0; i <= indice && !encontrou; i++) {
			if (this.usuarios[i].getNick().equals(nomeUsuario)) {
				for (int k = i; k <= indice - 1; k++) {
					this.usuarios[k] = this.usuarios[k + 1];
				}
				encontrou = true;
				indice--;
			}
		}
		if (!encontrou) {
			throw new UNCException();
		}

	}

	@Override
	public void atualizar(Usuario usuario) throws UNCException {
		int i = this.procurar(usuario.getNick());
		this.usuarios[i] = usuario;
	}

	@Override
	public boolean existe(String nomeUsuario) {
		boolean encontrou = false;
		for (int i = 0; i < indice && !encontrou; i++) {
			if (this.usuarios[i].getNick().equals(nomeUsuario)) {
				encontrou = true;
			}
		}
		return encontrou;
	}

	public int procurar(String nomeUsuario) throws UNCException {
		int indicee = 0;
		boolean encontrou = false;
		for (int i = 0; i <= indice && !encontrou; i++) {
			if (this.usuarios[i].getNick().equals(nomeUsuario)) {
				encontrou = true;
				indicee = i;
			}
		}
		if (!encontrou) {
			throw new UNCException();
		}
		return indicee;
	}
	public 	Usuario procurarUsuario(String nomeUsuario) throws UNCException {
		int indicee = 0;
		boolean encontrou = false;
		for (int i = 0; i <= indice && !encontrou; i++) {
			if (this.usuarios[i].getNick().equals(nomeUsuario)) {
				encontrou = true;
				indicee = i;
			}
		}
		if (!encontrou) {
			throw new UNCException();
		}
		return this.usuarios[indicee];
	}

}
