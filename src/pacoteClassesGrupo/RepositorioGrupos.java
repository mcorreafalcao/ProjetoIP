package pacoteClassesGrupo;



import pacoteExcecoes.GJCException;
import pacoteExcecoes.GNEException;
import pacoteExcecoes.SMPCException;

/**
 * "interface negocio-dades"
 * será implementada em RepositorioGruposArray e RepositoiroGruposLista
 * @author Gabriel
 *
 */
public interface RepositorioGrupos {
	public void inserir(Grupo grupo) throws GJCException, SMPCException;
	
	public void atualizar(Grupo novoGrupo, String categoriaGrupo) throws GNEException;
	
	public void remover(Grupo grupo) throws GNEException;
	
	public boolean existe(String grupo);
	
	
}
