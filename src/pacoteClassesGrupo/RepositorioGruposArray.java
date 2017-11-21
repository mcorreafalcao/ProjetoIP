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
	
	public void RepositorioGruposArray() {
		grupos = new Grupo[100];
	}
	
	@Override
	public void inserir(Grupo grupo) throws Exception {
		if (!this.existe(grupo.nomeGrupo)) {
			this.grupos[this.indice] = grupo;
			this.indice++;
		}else {
			Exception GrupoJaCadastradoException = null;
			throw GrupoJaCadastradoException;
		}
	}

	@Override
	public void atualizar(Grupo grupo) throws Exception {
		if (this.existe(grupo.nomeGrupo)) {
			int proc = this.procurar(grupo.nomeGrupo);
			this.grupos[proc] = grupo;
		}else {
			Exception GrupoJaCadastradoException = null;
			throw GrupoJaCadastradoException;
		}
	}

	@Override
	public void remover(Grupo grupo) throws Exception {
		if (this.existe(grupo.nomeGrupo)) {
			int proc = this.procurar(grupo.nomeGrupo);
			for (int i = proc; i < indice - 1; i++) {
				this.grupos[i] = this.grupos[i + 1];
			}
			this.indice--;
		}else {
			Exception GrupoNaoEncontradoException = null;
			throw GrupoNaoEncontradoException;
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
	
	public boolean existe(String grupo) {
		for (int i = 0; i < 100; i++) {
			if (this.grupos[i].nomeGrupo.equals(grupo)) {
				return true;
			}
		}
		return false;
		
	}

}
