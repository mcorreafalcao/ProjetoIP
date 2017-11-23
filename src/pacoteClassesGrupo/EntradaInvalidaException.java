package pacoteClassesGrupo;

public class EntradaInvalidaException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EntradaInvalidaException() {
		super("Favor inserir um número entre 1 e 2.");
	}
}
