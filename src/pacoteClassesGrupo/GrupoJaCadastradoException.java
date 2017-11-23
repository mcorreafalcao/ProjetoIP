package pacoteClassesGrupo;

public class GrupoJaCadastradoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GrupoJaCadastradoException() {
		super("Nome de grupo já cadastrado. Favor inserir um nome de grupo válido.");
	}
}
