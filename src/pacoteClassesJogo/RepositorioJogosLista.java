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
		 * insere um jogo novo na lista. Por favor, chamar o metodo exixte antes deste metodo,
		 * assim evitando insercao de jogos repetidos, obrigado.
		 */
		if(this.jogo.nome==null){
			this.jogo=jogo;
			this.proximo=new RepositorioJogosLista();
		}
		else if(this.proximo!=null)
			this.proximo.inserir(jogo);
		else{
			this.proximo = new RepositorioJogosLista();
			this.jogo=jogo;
		}
		
		

	}

	@Override
	public void remover(String nomeJogo) throws JogoNaoEncontradoException {
		/**
		 * remove jogo da lista, nao faz nada caso o jogo nao exista.
		 * chamar o existe antes desse metodo, para evitar a tentativa de remover jogo inexistente
		 * ou fazer sem recursividade e chamar existir aqui dentro
		 */
		if(this.jogo!=null) {
			if(this.jogo.getNome().equals(nomeJogo)) {
				this.jogo.nome=this.proximo.jogo.nome;
				this.jogo.preco=this.proximo.jogo.preco;
				this.jogo.descricao=this.proximo.jogo.descricao;
				this.jogo.dataLancamento=this.proximo.jogo.dataLancamento;
			}else
				this.proximo.remover(nomeJogo);
			
		}

	}

	@Override
	public void atualizar(Jogo jogo) throws JogoNaoEncontradoException {
		

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
