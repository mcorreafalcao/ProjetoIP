package pacoteClassesGrupo;

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
			//Se o valor digitado for diferente de 1 ou 2 deverá ser jogado uma exceção pedindo para informar um valor apenas entre 1 e 2
			throw new EntradaInvalidaException();
		}	
	}
	
	public void cadastrarGrupo(Grupo grupo) throws GrupoJaCadastradoException {
		this.comunidade.inserir(grupo);
	}
	
	public void removerGrupo(Grupo grupo) throws GrupoNaoEncontradoException {
		this.comunidade.remover(grupo);
	}
	
}
