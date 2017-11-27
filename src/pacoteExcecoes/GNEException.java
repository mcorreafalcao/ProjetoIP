package pacoteExcecoes;

public class GNEException extends Exception {
	

	public GNEException() {
		super("Grupo não encontrado. Favor informar o nome de um grupo existente.");
	}
}
