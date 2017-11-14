package pacoteClassesJogo;
/**
 * tava testando umas coisas aqui, nao funcionou :P
 * 
 * ignoremos essa classe por enquanto
 * */
public class CadastroJogo {
public static void main(String[] args) throws JogoNaoEncontradoException {
	Jogo jogo = new Jogo();
	RepositorioJogos lista = new RepositorioJogosArray(10);
	lista.atualizar(jogo);
}
}
