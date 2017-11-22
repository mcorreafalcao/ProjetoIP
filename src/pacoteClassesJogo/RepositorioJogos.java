package pacoteClassesJogo;

/**
 * "Interface negocio-dados". Interface implementada em RepositrioUsuariosJogos
 * e RepositorioUsuariosJogos.
 * 
 * @author Gabriel
 *
 */
public interface RepositorioJogos {// interface negocio_dados
	public void inserir(Jogo jogo) throws JJCException, SMPCException;

	public void remover(String nomeJogo) throws JNCException;

	public void atualizar(Jogo jogo) throws JNCException;

	public boolean existe(String nomeJogo);
}
