package pacoteClassesUsuario;

public interface RepositorioUsuarios {
	
	public void inserir(Usuario usuario) throws UNCException;

	public void remover(String nomeUsuario) throws UNCException;

	public void atualizar(Usuario usuario) throws UNCException;

	public boolean existe(String nomeUsuario);
	
}
