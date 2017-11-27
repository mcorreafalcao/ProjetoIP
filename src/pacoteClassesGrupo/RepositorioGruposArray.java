package pacoteClassesGrupo;

import pacoteClassesProduto.PJCException;
import pacoteClassesProduto.Produto;
import pacoteClassesProduto.SMPCException;

/**
 * "classe colecao de dados lista" classe que contem um lista de grupos e
 * metodos da interface implementada
 * 
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
		if (!this.existe(grupo.getNomeGrupo())) {
			this.grupos[this.indice] = grupo;
			this.indice++;
		} else {
			throw new GrupoJaCadastradoException();
		}
	}

	@Override
	public void atualizar(Grupo grupo) throws GrupoJaCadastradoException {
		if (this.existe(grupo.getNomeGrupo())) {
			int proc = this.procurar(grupo.getNomeGrupo());
			this.grupos[proc] = grupo;
		} else {
			throw new GrupoJaCadastradoException();
		}
	}

	@Override
	public void remover(Grupo grupo) throws GrupoNaoEncontradoException {
		if (this.existe(grupo.getNomeGrupo())) {
			int proc = this.procurar(grupo.getNomeGrupo());
			for (int i = proc; i < indice - 1; i++) {
				this.grupos[i] = this.grupos[i + 1];
			}
			this.indice--;
		} else {
			throw new GrupoNaoEncontradoException();
		}

	}

	public int procurar(String nomeg) {
		for (int i = 0; i < 100; i++) {
			if (this.grupos[i].equals(nomeg)) {
				return i;
			}
		}
		// Nunca vai chegar nesse return
		return 0;
	}
	
	//Isso e tipo um getGrupo
	public Grupo procurarInt(int grupo) {
		return this.grupos[grupo];
	}

	@Override
	public boolean existe(String grupo) {
		for (int i = 0; i < 100; i++) {
			if (this.grupos[i].getNomeGrupo().equals(grupo)) {
				return true;
			}
		}
		return false;
	}
}
