package pacoteClassesJogo;

public interface RepositorioJogos {//interface negocio_dados
	public void inserir(Jogo jogo)
			throws JogoJaCadastradoException, Exception ;
	public void remover(String nomeJogo) 
			throws JogoNaoEncontradoException, Exception;
	public void atualizar(Jogo jogo)
			throws JogoNaoEncontradoException, Exception;
	public boolean existe(String nomeJogo);
}
