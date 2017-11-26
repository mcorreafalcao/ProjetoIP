package pacoteClassesProduto;

public class SMPCException extends Exception {// excecao para o caso de acabar a
												// memoria do array e houver
												// tentativa de inserir
	public SMPCException() {
		super("sem memoria para cadastro");
	}
}
