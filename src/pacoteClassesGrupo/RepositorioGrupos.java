package pacoteClassesGrupo;
/**
 * "interface negocio-dades"
 * será implementada em RepositorioGruposArray e RepositoiroGruposLista
 * @author Gabriel
 *
 */
public interface RepositorioGrupos {
	public void inserir(Grupo grupo);
	
	public void atualizar(Grupo grupo);
	
	public void remover(String grupo);
	
	public Grupo procurar(String grupo);
	
	
}
