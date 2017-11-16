package pacoteClassesJogo;

public class RepositorioJogosLista implements RepositorioJogos {//colecao de dados lista
	
	private Jogo jogo;
	private RepositorioJogosLista proximo;
	
	public RepositorioJogosLista(){
		this.jogo=new Jogo();
		this.proximo=null;
	}
	@Override
	public void inserir(Jogo jogo) throws JogoJaCadastradoException {
		/**
		 * insere um jogo novo na lista, joga excecao caso ele já exista
		 */
		boolean existe = this.existe(this.getNome())
		if(existe){
			throw JogoJaCadastradoException;
		}else {//insere o jogo na lista
			
		}
		
		

	}

	@Override
	public void remover(String nomeJogo) throws JogoNaoEncontradoException {
		/**
		 * remove jogo da lista, joga escecao caso ele nao exista
		 */
		boolean existe = this.existe(nomeJogo);
		if(!existe)
			throw JogoNaoEncontradoException;
		else {//remove da lista
			
		}
	}

	@Override
	public void atualizar(Jogo jogo) throws JogoNaoEncontradoException {
		/**
		 * troca os atributos do jogo com mesmo nome pelos atributos do jogo inserido como referencia
		 */
		boolean existe = this.existe(nomeJogo);
		if(!existe) {
			throw JogoNaoEncontradoException;
		}else {//procura e troca os valores ao encontrar
			
		}
		
		

	}

	@Override
	public boolean existe(String nomeJogo) {
		if(this.jogo.getNome().equals(nomeJogo)){//caso tenha encontrado
			return true;
		}else if(this.proximo!=null)//caso nao tenha encontrado e existam outros
			return this.proximo.existe(nomeJogo);
		else//caso nao seja o atual e nem exista outros
			return false;
	}

}
