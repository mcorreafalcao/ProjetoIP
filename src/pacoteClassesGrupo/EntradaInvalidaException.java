package pacoteClassesGrupo;

public class EntradaInvalidaException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EntradaInvalidaException() {
		super("Favor inserir um n�mero entre 1 e 2.");
	}
}
