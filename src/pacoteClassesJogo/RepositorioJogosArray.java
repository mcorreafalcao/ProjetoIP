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

	public RepositorioJogosArray(int tam) {
		/**
		 * construtor
		 */
		jogos = new Jogo[tam];
		indice = 0;
	}

	@Override
	public void inserir(Jogo jogo) throws Exception {
		/**
		 * Insere o jogo no array, joga excecao caso o jogo ja exista
		 */
		if (!this.existe(jogo.nome)) {// insere no primeiro indice vazio
			this.jogos[this.indice + 1].nome = jogo.getNome();
			this.jogos[this.indice + 1].dataLancamento = jogo.getData();
			this.jogos[this.indice + 1].descricao = jogo.getDescricao();
			this.jogos[this.indice + 1].preco = jogo.getPreco();
			this.indice++;

		} else {// excecao
			Exception JogoJaCadastradoException = null;
			/**
			 * inicializar excecao aqui?
			 */
			throw JogoJaCadastradoException;

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
	public void remover(String nomeJogo) throws Exception {
		/**
		 * Remove o jogo do array, joga excecao caso nao encontre o jogo
		 */
		boolean achou = false;
		for (int i = 0; i <= indice && !achou; i++) {
			if (this.jogos[i].getNome().equals(nomeJogo)) {
				for (int k = i; k <= indice - 1; k++) {// translada os jogos no
														// array por um indice
					this.jogos[k].nome = this.jogos[k + 1].nome;
					this.jogos[k].preco = this.jogos[k + 1].preco;
					this.jogos[k].dataLancamento = this.jogos[k + 1].dataLancamento;
					this.jogos[k].descricao = this.jogos[k + 1].descricao;
				}
				achou = true;
				indice--;
				return;
			}
		}
		Exception JogoNaoEncontradoException = null;
		/**
		 * inicializar excecao aqui?
		 */
		throw JogoNaoEncontradoException;

	}

	public int procurar(String nomeJogo) throws Exception {
		/**
		 * Retorna o indice do jogo no array. Retorna -1 caso nao encontre
		 * (trocar esse caso por excecao)
		 */
		int i = 0;
		for (i = 0; i <= indice; i++) {
			if (this.jogos[i].nome.equals(nomeJogo))
				return i;
		}
		Exception JogoNaoEncontradoException = null;
		/**
		 * inicializar excecao aqui?
		 */
		throw JogoNaoEncontradoException;
	}

	@Override
	public void atualizar(Jogo jogo) throws Exception {
		/**
		 * Procura pelo elemento no array cujo nome eh o mesmo que o jogo
		 * inserido na entrada. Ao encontrar, substitui seus atributos pelos
		 * atributos do jogo inserido na entrada. caso nao encontre, o int i
		 * será igual a -1 (tratar excecao nesse caso)
		 */
		int i = this.procurar(jogo.nome);
		if (i != -1) {// caso contrario (i==-1) significa que o metodo procurar
						// nao encontrou o jogo na lista
			this.jogos[i].setData(jogo.dataLancamento);
			this.jogos[i].setDescricao(jogo.descricao);
			this.jogos[i].setPreco(jogo.preco);
			this.indice++;
			return;

		}

		else {

			Exception JogoNaoEncontradoException = null;
			/**
			 * inicializar excecao aqui?
			 */
			throw JogoNaoEncontradoException;
		}

	}

}
