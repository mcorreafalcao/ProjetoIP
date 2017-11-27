package pacoteClassesGrupo;

import pacoteClassesProduto.Produto;
import pacoteClassesProduto.RepositorioProdutosArray;
import pacoteClassesProduto.RepositorioProdutosLista;
import pacoteExcecoes.EIException;
import pacoteExcecoes.GJCException;
import pacoteExcecoes.GNEException;
import pacoteExcecoes.PNCException;
import pacoteExcecoes.SMPCException;

/**
 * "classe colecao de negocio" ainda nao entendi pra que vai servir essa classe
 * 
 * @author Gabriel
 *
 */
public class NegocioGrupo {
	RepositorioGrupos comunidade;

	public NegocioGrupo(int valor) throws EIException {
		if (valor == 1) {
			comunidade = new RepositorioGruposArray();
		} else if (valor == 2) {
			comunidade = new RepositorioGruposLista();
		} else {
			// Se o valor digitado for diferente de 1 ou 2 deverá ser jogado uma exceção
			// pedindo para informar um valor apenas entre 1 e 2
			throw new EIException();
		}
	}

	public void cadastrarGrupo(Grupo grupo) throws GJCException, SMPCException {
		this.comunidade.inserir(grupo);
	}

	public void removerGrupo(Grupo grupo) throws GNEException {
		this.comunidade.remover(grupo);
	}

	public Grupo procurar(String nomeGrupo) throws GNEException {// retorna exceção caso o grupo não exista
		Grupo grupo = null;
		if (this.comunidade instanceof RepositorioGruposArray) {// se for array, pega o indice e retorna o grupo
																// associado
			int indice = ((RepositorioGruposArray) this.comunidade).procurar(nomeGrupo);
			grupo = ((RepositorioGruposArray) this.comunidade).procurarInt(indice);
		} else if (this.comunidade instanceof RepositorioGruposLista) {// se for lista só procura e retorna o grupo do
																		// objeto da lista
			RepositorioGruposLista aux;
			aux = ((RepositorioGruposLista) this.comunidade).procurar(nomeGrupo);
			grupo = aux.getGrupo();
		}
		return grupo;
	}

	/**
	 * adicionei esse detalhe abaixo (como em RepoGruposLista) apenas para ver se o
	 * programa correspondia espero que não ocorra erros, rs rs
	 */
	public String getNomeGrupo() {
		return this.getNomeGrupo();
	}

	public void atualizarGrupo(Grupo grupo) throws GNEException {// procura na loja a referencia com o mesmo nome do produto inserido e substitui ela pela referencia inserida
		this.comunidade.atualizar(grupo);
	}

}
