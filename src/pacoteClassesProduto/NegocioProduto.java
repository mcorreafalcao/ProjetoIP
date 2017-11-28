package pacoteClassesProduto;

import pacoteClassesProduto.RepositorioProdutosArray;
import pacoteExcecoes.EIException;
import pacoteExcecoes.PJCException;
import pacoteExcecoes.PNCException;
import pacoteExcecoes.SMPCException;

/**
 * "Classe colecao de negocio". Ainda nao entendi pra que vai servir essa
 * classe.
 * 
 * @author Gabriel
 */
public class NegocioProduto {
	
	RepositorioProdutos loja;
	
	public NegocioProduto (int a) throws EIException {//construtor
		if(a==1)
			loja = new RepositorioProdutosArray();
		else if(a==2)
			loja = new RepositorioProdutosLista();
		else
			throw new EIException();
		/**
		 * caso tenhamos q ler o arquivo, pegar o input de tamanho antes de construir
		 */
		
	}
	
	
	public void inserir(Produto produto) throws PJCException, SMPCException {
		if(!this.loja.existe(produto.getNome()))
			this.loja.inserir(produto);//insere recursivamente caso seja lista, insere normal caso array
		
	}
	
	
	//metodos para remover abaixo
	public void remover(Produto produto) throws PNCException {//remove uma referencia da lista procurando pelo nome da referencia inserida
		/**
		 *usar esse para remover caso ele já possua a referencia do produto a remover
		 */
		this.loja.remover(produto.getNome());
		
	}
	public void remover2(String nomeProduto) throws PNCException{//remove uma referencia da lista procurando diretamente pelo nome
		/**
		 * usar esse para remover caso o usuario só precise dizer o nome para remover
		 */
		this.loja.remover(nomeProduto);
	}
	//metodos para remover acima
	
	
	
	public Produto procurar(String nomeProduto) throws PNCException{//retorna uma referencia de um produto procurado ou levanta excecao caso nao encontre
		Produto produto=null;
		if(this.loja.existe(nomeProduto)){
			if(this.loja instanceof RepositorioProdutosArray){//se for array, pega o indice e retorna o produto associado
				int indice = ((RepositorioProdutosArray) this.loja).procurar(nomeProduto);
				produto = ((RepositorioProdutosArray) this.loja).getProduto(indice);
			}else if(this.loja instanceof RepositorioProdutosLista ){//se for lista só procura e retorna o produto do objeto da lista
				RepositorioProdutosLista aux;
				aux=((RepositorioProdutosLista) this.loja).procurar(nomeProduto);
				produto = aux.getProduto();
			}
			
		}else{
			throw new PNCException();
		}
		return produto;
	}
	
	
	
	public void atualizarProduto(Produto produtoAlterado) throws PNCException{//procura na loja a referencia com o mesmo nome do produto inserido e substitui ela pela referencia inserida
		this.loja.atualizar(produtoAlterado);
	}
	public String listarProdutos(){
		return this.loja.listarProdutos();//metodo implementado nos repositorios
	}



	
	
	
}
