package pacoteClassesUsuario;

import pacoteExcecoes.SMPCException;
import pacoteExcecoes.UJCException;
import pacoteExcecoes.UNCException;

public interface RepositorioUsuarios {

	public void inserir(Usuario usuario) throws UJCException, SMPCException;

	public void remover(String nomeUsuario) throws UNCException;

	public void atualizar(Usuario usuario) throws UNCException;

	public boolean existe(String nomeUsuario);

}
