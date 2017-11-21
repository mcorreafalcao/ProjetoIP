package pacoteClassesJogo;

/**
 * "Interface negocio-dados". Interface implementada em RepositrioUsuariosJogos
 * e RepositorioUsuariosJogos.
 * 
 * @author Gabriel
 *
 */
public interface RepositorioJogos {// interface negocio_dados
	public void inserir(Jogo jogo) throws JogoJaCadastradoException;

	public void remover(String nomeJogo) throws JogoNaoEncontradoException;

	public void atualizar(Jogo jogo) throws JogoNaoEncontradoException;

	public boolean existe(String nomeJogo);
}
