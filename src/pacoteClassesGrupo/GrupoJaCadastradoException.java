package pacoteClassesGrupo;

public class GrupoJaCadastradoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GrupoJaCadastradoException() {
		super("Nome de grupo j� cadastrado. Favor inserir um nome de grupo v�lido.");
	}
}
