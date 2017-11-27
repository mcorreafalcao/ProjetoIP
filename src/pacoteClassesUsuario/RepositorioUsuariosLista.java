package pacoteClassesUsuario;

import pacoteExcecoes.UJCException;
import pacoteExcecoes.UNCException;

/**
 * "classe colecao de dados lista"
 * classe que contem um lista de usuarios e metodos da interface implementada
 * 
 * @author Gabriel
 *
 */
public class RepositorioUsuariosLista implements RepositorioUsuarios {

	private Usuario atual;
	private RepositorioUsuariosLista proximo;

	public RepositorioUsuariosLista() {
		this.atual = null;
		this.proximo = null;
	}

	public void remover(String elemento) throws UNCException {
		if (this.atual != null) {
			if (this.atual.getNick().equals(elemento)) {
				this.atual = this.proximo.atual;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(elemento);
			}
		} else {
			throw new UNCException();
		}
	}

	public boolean existe(String elemento) {
		boolean existe = false;

		if (this.atual != null) {
			if (this.atual.getNick().equals(elemento)) {
				existe = true;
			} else {
				existe = this.proximo.existe(elemento);
			}
		}

		return existe;
	}

	@Override
	public void inserir(Usuario usuario) throws UJCException {
		if (this.atual == null) {
			this.atual = usuario;
			this.proximo = new RepositorioUsuariosLista();
		} else {
			this.proximo.inserir(usuario);
		}
	}

	@Override
	public void atualizar(Usuario usuario) throws UNCException {
		// TODO Auto-generated method stub
		if (this.atual != null) {
			if (this.atual.getNick().equals(usuario.getNick())) {
				this.atual = usuario;
			} else {
				this.proximo.atualizar(usuario);
			}
		} else {
			throw new UNCException();
		}
	}
}
