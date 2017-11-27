package pacoteExcecoes;

public class PJCException extends Exception {
	public PJCException() {
		super("produto já cadastrado");
	}
}
