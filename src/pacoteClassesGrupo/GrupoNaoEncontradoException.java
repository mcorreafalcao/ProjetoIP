package pacoteClassesGrupo;

public class GrupoNaoEncontradoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GrupoNaoEncontradoException() {
		super("Grupo n�o encontrado. Favor informar o nome de um grupo existente.");
	}
}
