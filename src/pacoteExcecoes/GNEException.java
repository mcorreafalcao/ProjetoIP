package pacoteExcecoes;

public class GNEException extends Exception {
	

	public GNEException() {
		super("Grupo n�o encontrado. Favor informar o nome de um grupo existente.");
	}
}
