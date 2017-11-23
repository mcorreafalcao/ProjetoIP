package pacoteClassesGrupo;
/**
 * "interface negocio-dades"
 * será implementada em RepositorioGruposArray e RepositoiroGruposLista
 * @author Gabriel
 *
 */
public interface RepositorioGrupos {
	public void inserir(Grupo grupo) throws GrupoJaCadastradoException;
	
	public void atualizar(Grupo grupo) throws GrupoJaCadastradoException;
	
	public void remover(Grupo grupo) throws GrupoNaoEncontradoException;
	
	public boolean existe(String grupo);
	
	
}
