package pacoteClassesUsuario;

import pacoteClassesJogo.JJCException;

/**
 * "classe colecao de dados array"
 * classe que contem um array de usuarios e metodos da interface implementada
 * @author Gabriel
 *
 */
public class RepositorioUsuariosArray implements RepositorioUsuarios {

	private Usuario[] usuarios;
	private int indice;
	
	public RepositorioUsuariosArray (int tamanho) {
		usuarios = new Usuario[tamanho];
		indice = 0;
	}
	@Override
	public void inserir(Usuario usuario) {
		if (!this.existe(usuario.getNick()) && this.indice < this.usuarios.length - 1) {
			this.usuarios[indice] = usuario;
			this.indice++;
		} else {
			// throw new UJCException();
		}
		
	}

	@Override
	public void remover(String nomeUsuario) {
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
			//throw new UNCException();
		}
		
	}

	@Override
	public void atualizar(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existe(String nomeUsuario) {
		// TODO Auto-generated method stub
		return false;
	}                     
	
	public int procurar(String nomeUsuario) {
		int indicee = 0;
		boolean encontrou = false;
		for (int i = 0; i <= indice && !encontrou; i++) {
			if (this.usuarios[i].getNick().equals(nomeUsuario)) {
				encontrou = true;
				indicee = i;
			}
		}
		return indicee;
	}

}
