package pacoteClassesProduto;

import pacoteExcecoes.PJCException;
import pacoteExcecoes.PNCException;
import pacoteExcecoes.SMPCException;

/**
 * "Classe colecao de dados array". Classe que contem um array de produtos e
 * metodos da interface implementada.
 * 
 * @author Gabriel
 *
 */
public class RepositorioProdutosArray implements RepositorioProdutos {// colecao de
																// dados array
	private Produto[] produtos;
	private int indice;// será sempre o primeiro indice vazio

	public RepositorioProdutosArray() {
		produtos = new Produto[100];
		indice = 0;//primeiro indice vazio
		/**
		 * construtor
		 */
	}

	@Override
	public void inserir(Produto produto) throws PJCException, SMPCException {
		if (!this.existe(produto.getNome()) && this.indice < this.produtos.length - 1) {// insere
																					// no
																					// primeiro
																					// indice
																					// vazio
			this.produtos[indice] = produto;
			this.indice++;

		} else if (this.indice >= this.produtos.length - 1) {// excecao caso acabe
															// a memoria do
															// array
			throw new SMPCException();
		} else {// excecao caso o produto ja exista
			throw new PJCException();
		}
		/**
		 * Insere o produto no array, joga excecao caso o produto ja exista
		 */
	}

	@Override
	public boolean existe(String nomeProduto) {
		boolean achou = false;
		for (int i = 0; i < indice && !achou; i++)
			if (this.produtos[i].getNome().equals(nomeProduto))
				achou = true;// quebra o loop

		return achou;
		/**
		 * Retorna true se existe produto no array com o nome desejado.
		 */
	}

	@Override
	public void remover(String nomeProduto) throws PNCException {
		int i = this.procurar(nomeProduto);// excecao pode ser levantada aqui

		for (int k = i; k < indice; k++) {// translada os produtos no
												// array por um indice
			this.produtos[k] = this.produtos[k + 1];

		}
		indice--;

		/**
		 * Remove o produto do array, joga excecao caso nao encontre o produto
		 */
	}

	public int procurar(String nomeProduto) throws PNCException {
		int ind = 0;
		boolean achou = false;
		for (int i = 0; i < indice && !achou; i++) {
			if (this.produtos[i].getNome().equals(nomeProduto)) {
				achou = true;// quebra o loop
				ind = i;
			}
		}
		if (!achou)
			throw new PNCException();

		return ind;
		/**
		 * Retorna o indice do produto no array ou excecao caso contrario
		 */
	}

	@Override
	public void atualizar(Produto produto) throws PNCException {
		/**
		 * Procura pelo elemento no array cujo nome eh o mesmo que o produto
		 * inserido na entrada. Ao encontrar, substitui seus atributos pelos
		 * atributos do produto inserido na entrada.
		 */
		int i = this.procurar(produto.getNome());// pode levantar excecao
		this.produtos[i] = produto;

	}
	
	public Produto getProduto(int indice){
		return this.produtos[indice];
	}

	@Override
	public String listarProdutos() {
		String lista = "\n";
		for(int i = 0; i<=this.indice-1;i++){
			if(this.produtos[i] instanceof Jogo)
				lista+="(Jogo) "+this.produtos[i].getNome()+"\n";
			else if(this.produtos[i] instanceof Jogo)
				lista+="(Demo) "+this.produtos[i].getNome()+"\n";
		}
		return lista;
		/**
		 * será algo como:
		 * (jogo) zezin
		 * (jogo) falcaodemel
		 * (Demo) kimpissoble
		 */
	}

}
