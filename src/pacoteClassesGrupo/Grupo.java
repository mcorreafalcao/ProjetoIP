package pacoteClassesGrupo;

import pacoteClassesUsuario.RepositorioUsuarios;

/**
 * "classe basica"
 * 
 * @author Gabriel
 *
 */
public class Grupo {

	private String nomeGrupo;
	private String categoria;
	private RepositorioUsuarios membros;

	public Grupo(String nomeGrupo, String categoria, RepositorioUsuarios membros) {
		this.nomeGrupo = nomeGrupo;
		this.categoria = categoria;
		this.membros = membros;
	}

}
