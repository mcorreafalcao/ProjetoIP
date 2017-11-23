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
		jogos = new Jogo[5];
		indice = 0;
		/**
		 * construtor
		 */
	}

	@Override
	public void inserir(Jogo jogo) throws JJCException, SMPCException {
		if (!this.existe(jogo.nome) && this.indice < this.jogos.length - 1) {// insere
																				// no
																				// primeiro
																				// indice
																				// vazio
			this.jogos[indice] = jogo;
			this.indice++;

		} else if (this.indice >= this.jogos.length - 1) {// excecao caso acabe
															// a memoria do
															// array
			throw new SMPCException();
		} else {// excecao caso o jogo ja exista
			throw new JJCException();
		}
		/**
		 * Insere o jogo no array, joga excecao caso o jogo ja exista
		 */
	}

	@Override
	public boolean existe(String nomeJogo) {
		boolean achou = false;
		for (int i = 0; i <= indice && !achou; i++)
			if (this.jogos[i].getNome().equals(nomeJogo))
				achou = true;// quebra o loop

		return achou;
		/**
		 * Retorna true se existe jogo no array com o nome desejado.
		 */
	}

	@Override
	public void remover(String nomeJogo) throws JNCException {
		boolean achou = false;
		for (int i = 0; i <= indice && !achou; i++) {
			if (this.jogos[i].getNome().equals(nomeJogo)) {
				for (int k = i; k <= indice - 1; k++) {// translada os jogos no
														// array por um indice
					this.jogos[k] = this.jogos[k + 1];

				}
				achou = true;// queba o loop
				indice--;
			}
		}
		if (!achou) {
			throw new JNCException();
		}

		/**
		 * Remove o jogo do array, joga excecao caso nao encontre o jogo
		 */
	}

	public int procurar(String nomeJogo) throws JNCException {
		int ind = 0;
		boolean achou = false;
		for (int i = 0; i <= indice && !achou; i++) {
			if (this.jogos[i].nome.equals(nomeJogo)) {
				achou = true;// quebra o loop
				ind = i;
			}

		}
		if (!achou)
			throw new JNCException();

		return ind;
		/**
		 * Retorna o indice do jogo no array ou excecao caso
		 */
	}

	@Override
	public void atualizar(Jogo jogo) throws JNCException {
		/**
		 * Procura pelo elemento no array cujo nome eh o mesmo que o jogo
		 * inserido na entrada. Ao encontrar, substitui seus atributos pelos
		 * atributos do jogo inserido na entrada. caso nao encontre, o int i
		 * será igual a -1 (tratar excecao nesse caso)
		 */
		int i = this.procurar(jogo.nome);// pode levantar excecao

		this.jogos[i] = jogo;

	}

}
