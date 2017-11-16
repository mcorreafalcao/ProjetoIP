package pacoteClassesJogo;

public class RepositorioJogosArray implements RepositorioJogos {// colecao de
																// dados array
	private Jogo[] jogos;
	private int indice;

	public RepositorioJogosArray(int tam) {
		/**oioioi
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
		if (!this.existe(jogo.nome)) {
			this.jogos[this.indice+1].nome = jogo.nome;
			this.jogos[this.indice+1].dataLancamento = jogo.dataLancamento;
			this.jogos[this.indice+1].descricao = jogo.descricao;
			this.jogos[this.indice+1].preco = jogo.preco;
			this.indice++;

		}  else {
			Exception JogoJaCadastradoException = null;
			throw JogoJaCadastradoException;
			
		}
	}

	@Override
	public boolean existe(String nomeJogo) {
		/**
		 * Retorna true se existe jogo no array com o mesmo nome.
		 */
		for (int i = 0; i <= indice; i++)
			if (this.jogos[i].nome.equals(nomeJogo))
				return true;

		return false;
	}

	@Override
	public void remover(String nomeJogo) throws Exception {
		/**
		 * Remove o jogo do array, joga excecao caso nao encontre o jogo
		 */
		boolean achou = false;
		for (int i = 0; i <= indice && !achou; i++) {
			if (this.jogos[i].nome.equals(nomeJogo)) {
				for (int k = i; k <= indice - 1; k++) {
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
			//caso nao tenha encontrado o jogo na lista, o metodo joga excecao
			throw JogoNaoEncontradoException;

	}
	public int procurar(String nomeJogo) {
		/**
		 * Retorna o indice do jogo no array. Retorna -1 caso nao encontre (trocar esse caso por excecao)
		 */
		int i=0;
		for(i=0;i<=indice;i++) {
			if(this.jogos[i].nome.equals(nomeJogo))
				return i;
		}
		return -1;
	}
	@Override
	public void atualizar(Jogo jogo) throws Exception {
		/**
		 * Procura pelo elemento no array cujo nome eh o mesmo que o jogo inserido na entrada.
		 * Ao encontrar, substitui seus atributos pelos atributos do jogo inserido na entrada.
		 * caso nao encontre, o int i será igual a -1 (tratar excecao nesse caso)
		 */
			int i = this.procurar(jogo.nome);
			if(i!=-1) {//caso contrario (i==-1) significa que o metodo procurar nao encontrou o jogo na lista 
				this.jogos[i].setData(jogo.dataLancamento);
				this.jogos[i].setDescricao(jogo.descricao);
				this.jogos[i].setPreco(jogo.preco);
				this.indice++;
				return;
				
			}

		  
			 Exception JogoNaoEncontradoException = null;
			throw JogoNaoEncontradoException;

	}
	

}
