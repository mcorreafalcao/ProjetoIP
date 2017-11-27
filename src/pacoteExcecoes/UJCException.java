package pacoteExcecoes;

public class UJCException extends Exception {
	public UJCException() {
		super("usuário já cadastrado");
	}
}
