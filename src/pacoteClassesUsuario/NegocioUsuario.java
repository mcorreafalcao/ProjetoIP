package pacoteClassesUsuario;

import pacoteClassesJogo.EIException;

public class NegocioUsuario {
	RepositorioUsuarios usuarios;

	public NegocioUsuario(int a) throws EIException{
		this.usuarios = usuarios;
		
		if (a == 1) {
			usuarios = new RepositorioUsuariosArray();
		} else (a == 2) {
			usuarios = new RepositorioUsuariosLista();
			
		}
	}
	

}
