package pacoteClassesGrupo;

/**
 * "classe colecao de dados lista" classe que contem um lista de grupos e
 * metodos da interface implementada
 * 
 * @author Gabriel
 *
 */
public class RepositorioGruposLista implements RepositorioGrupos {
	private Grupo prim;
	private RepositorioGruposLista prox;

	public RepositorioGruposLista() {
		this.prim = null;
		this.prox = null;
	}

	@Override
	public void inserir(Grupo grupo) throws GrupoJaCadastradoException {
		if (!this.existe(grupo.nomeGrupo)) {
			this.prim = grupo;
			this.prox = new RepositorioGruposLista();
		} else {
			throw new GrupoJaCadastradoException();
			
		}
	}

	@Override
	public void atualizar(Grupo grupo) throws GrupoJaCadastradoException {
		if (this.existe(grupo.nomeGrupo)) {
			RepositorioGruposLista proc = this.procurar(grupo.nomeGrupo);
			proc.prim.nomeGrupo = grupo.nomeGrupo;
		} else {
			throw new GrupoJaCadastradoException();
		}
	}

	@Override
	public void remover(Grupo grupo) throws GrupoNaoEncontradoException {
		if (this.existe(grupo.nomeGrupo)) {
			RepositorioGruposLista proc = this.procurar(grupo.nomeGrupo);
			if (proc.prox == null) {
				proc.prim = null;
			} else {
				proc.prim = proc.prox.prim;
				proc.prox = proc.prox.prox;
			}
		} else {
			throw new GrupoNaoEncontradoException();
		}
	}

	public RepositorioGruposLista procurar(String grupo) {
		if (this.prim.nomeGrupo.equals(grupo)) {
			return this;
		} else if (this.prox != null)
			return this.prox.procurar(grupo);
		return null;
	}

	@Override
	public boolean existe(String grupo) {
		if (this.prim != null) {
			if (this.prim.equals(grupo)) {
				return true;
			}
		} else
			return false;
		// Supomos que ele não chegará aqui
		return false;
	}

}
