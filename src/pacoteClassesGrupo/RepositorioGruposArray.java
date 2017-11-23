package pacoteClassesGrupo;
/**
 * "classe colecao de dados array"
 * classe que contem um array de grupos e metodos da interface implementada
 * @author Gabriel
 *
 */
public class RepositorioGruposArray implements RepositorioGrupos {
	private Grupo[] grupos;
	private int indice = 0;
	
	public RepositorioGruposArray() {
		grupos = new Grupo[5];
	}
	
	@Override
	public void inserir(Grupo grupo) throws GrupoJaCadastradoException {
		if (!this.existe(grupo.nomeGrupo)) {
			this.grupos[this.indice] = grupo;
			this.indice++;
		}else {
			throw new GrupoJaCadastradoException();
		}
	}

	@Override
	public void atualizar(Grupo grupo) throws GrupoJaCadastradoException {
		if (this.existe(grupo.nomeGrupo)) {
			int proc = this.procurar(grupo.nomeGrupo);
			this.grupos[proc] = grupo;
		}else {
			throw new GrupoJaCadastradoException();
		}
	}

	@Override
	public void remover(Grupo grupo) throws GrupoNaoEncontradoException {
		if (this.existe(grupo.nomeGrupo)) {
			int proc = this.procurar(grupo.nomeGrupo);
			for (int i = proc; i < indice - 1; i++) {
				this.grupos[i] = this.grupos[i + 1];
			}
			this.indice--;
		}else {
			throw new GrupoNaoEncontradoException();
		}
		
	}

	public int procurar(String nomeg) {
		for (int i = 0; i < 100; i++) {
			if (this.grupos[i].equals(nomeg)) {
				return i;
			}
		}
		//Nunca vai chegar nesse return
		return 0;
	}
	
	@Override
	public boolean existe(String grupo) {
		for (int i = 0; i < 100; i++) {
			if (this.grupos[i].nomeGrupo.equals(grupo)) {
				return true;
			}
		}
		return false;
		
	}

}
