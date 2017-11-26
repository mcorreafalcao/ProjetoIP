package pacoteClassesProduto;

import pacoteClassesProduto.PJCException;
import pacoteClassesProduto.PNCException;

/**
 * "Classe colecao de dados lista". Classe que contem um lista de produtos e
 * metodos da interface implementada.
 * 
 * @author Gabriel
 *
 */

public class RepositorioProdutosLista implements RepositorioProdutos {// colecao de
																// dados lista

	private Produto produto;
	private RepositorioProdutosLista proximo;

	public RepositorioProdutosLista() {
		this.produto = null;
		this.proximo = null;
	}

	@Override
	public void inserir(Produto produto) throws PJCException {
		boolean existe = this.existe(produto.getNome());
		if (existe) {
			throw new PJCException();
		} else {// insere o produto na ultima posicao da lista
			RepositorioProdutosLista aux = this;// referencia para percorrer a
												// lista
			if (this.produto.getNome() == null) {// lista vazia
				this.produto = produto;
				this.proximo = new RepositorioProdutosLista();
				return;
			} else {// lista nao vazia
				while (aux != null) {// percorre a lista
					if (aux.proximo == null) {
						aux.proximo = new RepositorioProdutosLista();
						aux.proximo.produto = produto;
						return;
					}
					aux = aux.proximo;// passa para o proximo

				}
			}

		}

		/**
		 * insere um produto novo na lista, joga excecao caso ele já exista
		 */
	}

	@Override
	public void remover(String nomeProduto) throws PNCException {
		boolean existe = this.existe(nomeProduto);
		if (!existe) {
			throw new PNCException();
		} else {// remove da lista
			RepositorioProdutosLista aux = this.procurar(nomeProduto);// nao retorna
																// null pois só
																// e chamado se
																// existe() for
																// true
			if (aux.proximo == null) {// significa que só tem um elemento e sera
										// removido
				aux.produto = null;
			} else {// existem elementos
				aux.produto = aux.proximo.produto;
				aux.proximo = aux.proximo.proximo;
			}
		}
		/**
		 * remove produto da lista, joga escecao caso ele nao exista
		 */
	}

	@Override
	public void atualizar(Produto produto) throws PNCException {

		if (!this.existe(produto.getNome())) {
			throw new PNCException();
		} else {// procura e troca os valores ao encontrar
			boolean achou = false;
			RepositorioProdutosLista aux = this;
			while (aux != null && !achou) {
				if (aux.produto.getNome().equals(produto.getNome())) {
					aux.produto = produto;// atualiza a referencia da lista com o produto
									// novo
					achou = true;// quebra o loop
				}
			}
		}
		/**
		 * troca os atributos do produto com mesmo nome pelos atributos do produto
		 * inserido como referencia
		 */

	}

	@Override
	public boolean existe(String nomeProduto) {
		if (this.produto.getNome().equals(nomeProduto)) {// caso tenha encontrado
			return true;
		} else if (this.proximo != null) // caso nao tenha encontrado e existam
											// outros
			return this.proximo.existe(nomeProduto);
		else// caso nao seja o atual e nem exista outros
			return false;
	}

	public RepositorioProdutosLista procurar(String nomeProduto) {
		if (this.produto.getNome().equals(nomeProduto)) {
			return this;
		} else if (this.proximo != null)
			return this.proximo.procurar(nomeProduto);
		return null;// nunca retorna null, pois o existe é chamado antes dele
	}
	public Produto getProduto(){
		return this.produto;
	}

	@Override
	public String listarProdutos() {
		String lista ="\n";
		RepositorioProdutosLista aux = this;
		while(aux!=null){
			if(aux.produto instanceof Jogo)
				lista+="(Jogo) "+aux.produto.getNome()+"\n";
			else if(aux.produto instanceof Jogo)
				lista+="(Demo) "+aux.produto.getNome()+"\n";
			
			
			aux=aux.proximo;
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
