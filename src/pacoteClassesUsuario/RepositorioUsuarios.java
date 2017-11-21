package pacoteClassesUsuario;

public interface RepositorioUsuarios {
	
	public void inserir(Usuario usuario);

	public void remover(String nomeUsuario);

	public void atualizar(Usuario usuario);

	public boolean existe(String nomeUsuario);
	
}
