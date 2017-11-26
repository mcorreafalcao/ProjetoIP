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

	public Grupo(String nomeGrupo, String categoria) {
		this.nomeGrupo = nomeGrupo;
		this.categoria = categoria;
		this.membros = null;
	}

	public String getNomeGrupo() {
		return this.nomeGrupo;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public RepositorioUsuarios getMembros() {
		return this.membros;
	}

	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setMembros(RepositorioUsuarios membros) {
		this.membros = membros;
	}

}
