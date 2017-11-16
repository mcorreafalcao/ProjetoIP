package pacoteClassesJogo;

public class RepositorioJogosLista implements RepositorioJogos {//colecao de dados lista
	
	private Jogo jogo;
	private RepositorioJogosLista proximo;
	
	public RepositorioJogosLista(){
		this.jogo=new Jogo();
		this.proximo=null;
	}
	@Override
	public void inserir(Jogo jogo) throws Exception {
		/**
		 * insere um jogo novo na lista, joga excecao caso ele já exista
		 */
		boolean existe = this.existe(jogo.getNome());
		if(existe){
			Exception JogoJaCadastradoException = null;
			throw JogoJaCadastradoException;
		}else {//insere o jogo na lista
			
		}
		
		

	}

	@Override
	public void remover(String nomeJogo) throws Exception {
		/**
		 * remove jogo da lista, joga escecao caso ele nao exista
		 */
		boolean existe = this.existe(nomeJogo);
		Exception JogoNaoEncontradoException = null;
		if(!existe)
			throw JogoNaoEncontradoException;
		else {//remove da lista
			
		}
	}

	@Override
	public void atualizar(Jogo jogo) throws Exception {
		/**
		 * troca os atributos do jogo com mesmo nome pelos atributos do jogo inserido como referencia
		 */
		boolean existe = this.existe(jogo.getNome());
		if(!existe) {
			Exception JogoNaoEncontradoException = null;
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
