package pacoteClassesJogo;

/**
 * "Classe colecao de dados array". Classe que contem um array de jogos e
 * metodos da interface implementada.
 * 
 * @author Gabriel
 *
 */
public class RepositorioJogosArray implements RepositorioJogos {// colecao de
																// dados array
	private Jogo[] jogos;
	private int indice;// será sempre o primeiro indice vazio

	public RepositorioJogosArray() {
		/**
		 * construtor
		 */
		jogos = new Jogo[100];
		indice = 0;
	}

	@Override
	public void inserir(Jogo jogo) throws JogoJaCadastradoException {
		/**
		 * Insere o jogo no array, joga excecao caso o jogo ja exista
		 */
		if (!this.existe(jogo.nome)) {// insere no primeiro indice vazio
			this.jogos[indice] = jogo;
			this.indice++;

		} else {// excecao

			throw new JogoJaCadastradoException();

		}
	}

	@Override
	public boolean existe(String nomeJogo) {
		/**
		 * Retorna true se existe jogo no array com o mesmo nome.
		 */
		for (int i = 0; i <= indice; i++)
			if (this.jogos[i].getNome().equals(nomeJogo))
				return true;

		return false;// caso nao encontre
	}

	@Override
	public void remover(String nomeJogo) throws JogoNaoEncontradoException {
		/**
		 * Remove o jogo do array, joga excecao caso nao encontre o jogo
		 */
		boolean achou = false;
		for (int i = 0; i <= indice && !achou; i++) {
			if (this.jogos[i].getNome().equals(nomeJogo)) {
				for (int k = i; k <= indice - 1; k++) {// translada os jogos no
														// array por um indice
					this.jogos[k] = this.jogos[k + 1];

				}
				achou = true;
				indice--;
			}
		}
		if (!achou)
			throw new JogoNaoEncontradoException();

	}

	public int procurar(String nomeJogo) throws JogoNaoEncontradoException {
		/**
		 * Retorna o indice do jogo no array. Retorna -1 caso nao encontre (trocar esse
		 * caso por excecao)
		 */
		int i = 0;
		for (i = 0; i <= indice; i++) {
			if (this.jogos[i].nome.equals(nomeJogo))
				return i;
		}

		throw new JogoNaoEncontradoException();
	}

	@Override
	public void atualizar(Jogo jogo) throws JogoNaoEncontradoException {
		/**
		 * Procura pelo elemento no array cujo nome eh o mesmo que o jogo inserido na
		 * entrada. Ao encontrar, substitui seus atributos pelos atributos do jogo
		 * inserido na entrada. caso nao encontre, o int i será igual a -1 (tratar
		 * excecao nesse caso)
		 */
		int i = this.procurar(jogo.nome);
		if (i != -1) {// caso contrario (i==-1) significa que o metodo procurar
						// nao encontrou o jogo na lista
			this.jogos[i] = jogo;
			this.indice++;

		}

		else {

			throw new JogoNaoEncontradoException();
		}

	}

}
