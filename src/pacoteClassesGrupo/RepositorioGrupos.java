package pacoteClassesGrupo;
/**
 * "interface negocio-dades"
 * será implementada em RepositorioGruposArray e RepositoiroGruposLista
 * @author Gabriel
 *
 */
public interface RepositorioGrupos {
	public void inserir(Grupo grupo) throws Exception;
	
	public void atualizar(Grupo grupo) throws Exception;
	
	public void remover(Grupo grupo) throws Exception;
	
	//public int procurar(String grupo);
	
	public boolean existe(String grupo);
	
	
}
