package pacoteClassesJogo;

/**
 * "Classe colecao de dados lista". Classe que contem um lista de jogos e
 * metodos da interface implementada.
 * 
 * @author Gabriel
 *
 */

public class RepositorioJogosLista implements RepositorioJogos {// colecao de
																// dados lista

	private Jogo jogo;
	private RepositorioJogosLista proximo;

	public RepositorioJogosLista() {
		this.jogo = new Jogo();
		this.proximo = null;
	}

	@Override
	public void inserir(Jogo jogo) throws Exception {
		/**
		 * insere um jogo novo na lista, joga excecao caso ele já exista
		 */
		boolean existe = this.existe(jogo.getNome());
		if (existe) {
			Exception JogoJaCadastradoException = null;
			/**
			 * inicializar excecao aqui?
			 */
			throw JogoJaCadastradoException;
		} else {// insere o jogo na ultima posicao da lista
			RepositorioJogosLista aux = this;// referencia para percorrer a
												// lista
			if (this.jogo.getNome() == null) {// lista vazia
				this.jogo = jogo;
				this.proximo = new RepositorioJogosLista();
				return;
			} else {// lista nao vazia
				while (aux != null) {// percorre a lista
					if (aux.proximo == null) {
						aux.proximo = new RepositorioJogosLista();
						aux.proximo.jogo = jogo;
						return;
					}
					aux = aux.proximo;// passa para o proximo

				}
			}

		}

	}

	@Override
	public void remover(String nomeJogo) throws Exception {
		/**
		 * remove jogo da lista, joga escecao caso ele nao exista
		 */
		boolean existe = this.existe(nomeJogo);
		if (!existe) {
			Exception JogoNaoEncontradoException = null;
			/**
			 * inicializar excecao aqui?
			 */
			throw JogoNaoEncontradoException;
		} else {// remove da lista
			RepositorioJogosLista aux = this;
			if (this.jogo.getNome().equals(nomeJogo)) {// primeiro elemento
				if (this.proximo == null) {// so exixte um elemento e ele sera
											// removido
					aux = new RepositorioJogosLista();
					this.jogo = aux.jogo;
					this.proximo = aux.proximo;
					return;
				} else {// faz o primeiro elemento virar referencia pro segundo
					this.jogo = this.proximo.jogo;
					this.proximo = this.proximo.proximo;
					return;
				}
			} else {
				while (aux.proximo.proximo != null) {
					if (aux.proximo.jogo.getNome().equals(nomeJogo)) {
						aux.proximo = aux.proximo.proximo;
						return;
					}
					aux = aux.proximo;
				}
			}
		}
	}

	@Override
	public void atualizar(Jogo jogo) throws Exception {
		/**
		 * troca os atributos do jogo com mesmo nome pelos atributos do jogo
		 * inserido como referencia
		 */
		boolean existe = this.existe(jogo.getNome());
		if (!existe) {
			Exception JogoNaoEncontradoException = null;
			/**
			 * inicializar excecao aqui?
			 */
			throw JogoNaoEncontradoException;
		} else {// procura e troca os valores ao encontrar

		}

	}

	@Override
	public boolean existe(String nomeJogo) {
		if (this.jogo.getNome().equals(nomeJogo)) {// caso tenha encontrado
			return true;
		} else if (this.proximo != null) // caso nao tenha encontrado e existam
											// outros
			return this.proximo.existe(nomeJogo);
		else// caso nao seja o atual e nem exista outros
			return false;
	}

}
