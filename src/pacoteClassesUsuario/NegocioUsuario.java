package pacoteClassesUsuario;

public class NegocioUsuario {
	//negocio

	RepositorioUsuarios usuarios;

	public NegocioUsuario(int a) {
		if (a == 1) {
			usuarios = new RepositorioUsuariosArray();
		} else if (a == 2) {
			usuarios = new RepositorioUsuariosLista();
		}
	}

	public void inserir(Usuario usuario) throws UJCException {
		this.usuarios.inserir(usuario);
	}

	public void remover(String nomeUsuario) throws UNCException {
		this.usuarios.remover(nomeUsuario);
	}

	public void atualizar(Usuario usuario) throws UNCException {
		this.usuarios.atualizar(usuario);
	}
}
