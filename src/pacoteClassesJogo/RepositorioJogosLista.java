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
	public void inserir(Jogo jogo) throws JJCException {
		boolean existe = this.existe(jogo.getNome());
		if (existe) {
			throw new JJCException();
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

		/**
		 * insere um jogo novo na lista, joga excecao caso ele já exista
		 */
	}

	@Override
	public void remover(String nomeJogo) throws JNCException {
		boolean existe = this.existe(nomeJogo);
		if (!existe) {

			throw new JNCException();
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
		/**
		 * remove jogo da lista, joga escecao caso ele nao exista
		 */
	}

	@Override
	public void atualizar(Jogo jogo) throws JNCException {

		if (!this.existe(jogo.getNome())) {
			throw new JNCException();
		} else {// procura e troca os valores ao encontrar
			boolean achou=false;
			RepositorioJogosLista aux = this;
			while(aux!=null&&!achou){
				if(aux.jogo.getNome().equals(jogo.getNome())){
					aux.jogo=jogo;//atualiza a referencia da lista com o jogo novo
					achou = true;//quebra o loop
				}
			}
		}
		/**
		 * troca os atributos do jogo com mesmo nome pelos atributos do jogo inserido
		 * como referencia
		 */

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
