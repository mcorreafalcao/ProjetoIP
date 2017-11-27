package pacoteExcecoes;

public class GJCException extends Exception {


	public GJCException() {
		super("Nome de grupo já cadastrado. Favor inserir um nome de grupo válido.");
	}
}
