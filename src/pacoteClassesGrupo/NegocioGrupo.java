package pacoteClassesGrupo;

import pacoteClassesProduto.PNCException;
import pacoteClassesProduto.Produto;
import pacoteClassesProduto.RepositorioProdutosArray;
import pacoteClassesProduto.RepositorioProdutosLista;

/**
 * "classe colecao de negocio" ainda nao entendi pra que vai servir essa classe
 * 
 * @author Gabriel
 *
 */
public class NegocioGrupo {
	RepositorioGrupos comunidade;
	
	public NegocioGrupo(int valor) throws EntradaInvalidaException {
		if (valor == 1) {
			comunidade = new RepositorioGruposArray();
		}else if (valor == 2) {
			comunidade = new RepositorioGruposLista();
		}else {
			//Se o valor digitado for diferente de 1 ou 2 dever� ser jogado uma exce��o pedindo para informar um valor apenas entre 1 e 2
			throw new EntradaInvalidaException();
		}	
	}
	
	public void cadastrarGrupo(Grupo grupo) throws GrupoJaCadastradoException {
		this.comunidade.inserir(grupo);
	}
	
	public void removerGrupo(Grupo grupo) throws GrupoNaoEncontradoException {
		this.comunidade.remover(grupo);
	}
	
	public Grupo procurar(String nomeGrupo) throws GrupoNaoEncontradoException{//retorna exce��o caso o grupo n�o exista
		Grupo grupo = null;
		if(this.comunidade instanceof RepositorioGruposArray){//se for array, pega o indice e retorna o grupo associado
			int indice = ((RepositorioGruposArray) this.comunidade).procurar(nomeGrupo);
			grupo = ((RepositorioGruposArray) this.comunidade).procurarInt(indice);
		}else if(this.comunidade instanceof RepositorioGruposLista ){//se for lista s� procura e retorna o grupo do objeto da lista
			RepositorioGruposLista aux;
			aux=((RepositorioGruposLista) this.comunidade).procurar(nomeGrupo);
			grupo = aux.getNomeGrupo();
		}
		return grupo;
	}
	
	/**
	 * adicionei esse detalhe abaixo (como em RepoGruposLista) apenas para ver se o programa correspondia
	 * espero que n�o ocorra erros, rs rs
	 */
	public String getNomeGrupo() {
		return this.getNomeGrupo();
	}
	
	public void atualizarGrupo(Grupo grupo) throws GrupoJaCadastradoException{//procura na loja a referencia com o mesmo nome do produto inserido e substitui ela pela referencia inserida
		this.comunidade.atualizar(grupo);
	}

	
}
