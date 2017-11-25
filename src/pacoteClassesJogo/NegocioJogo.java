package pacoteClassesJogo;

/**
 * "Classe colecao de negocio". Ainda nao entendi pra que vai servir essa
 * classe.
 * 
 * @author Gabriel
 */
public class NegocioJogo {
	
	RepositorioJogos loja;
	
	public NegocioJogo (int a) throws EIException {//construtor
		if(a==1)
			loja = new RepositorioJogosArray();
		else if(a==2)
			loja = new RepositorioJogosLista();
		else
			throw new EIException();
		/**
		 * caso tenhamos q ler o arquivo, pegar o input de tamanho antes de construir
		 */
		
	}
	
	
	public void cadastrarJogo(Jogo jogo) throws JJCException, SMPCException {
		this.loja.inserir(jogo);
		
	}
	
	
	//metodos para remover abaixo
	public void descadastrarJogo(Jogo jogo) throws JNCException {//remove uma referencia da lista procurando pelo nome da referencia inserida
		/**
		 *usar esse para remover caso ele já possua a referencia do jogo a remover
		 */
		this.loja.remover(jogo.getNome());
		
	}
	public void descadastrarJogo2(String nomeJogo) throws JNCException{//remove uma referencia da lista procurando diretamente pelo nome
		/**
		 * usar esse para remover caso o usuario só precise dizer o nome para remover
		 */
		this.loja.remover(nomeJogo);
	}
	//metodos para remover acima
	
	
	
	public Jogo procurarJogo(String nomeJogo) throws JNCException{//retorna uma referencia de um jogo procurado ou levanta excecao caso nao encontre
		Jogo jogo = new Jogo();
		if(this.loja instanceof RepositorioJogosArray){//se for array, pega o indice e retorna o jogo associado
			int indice = ((RepositorioJogosArray) this.loja).procurar(nomeJogo);
			jogo = ((RepositorioJogosArray) this.loja).getJogo(indice);
		}else if(this.loja instanceof RepositorioJogosLista ){//se for lista só procura e retorna o jogo do objeto da lista
			RepositorioJogosLista aux;
			aux=((RepositorioJogosLista) this.loja).procurar(nomeJogo);
			jogo = aux.getJogo();
		}
		return jogo;
	}
	
	
	
	public void atualizarJogo(Jogo jogo) throws JNCException{//procura na loja a referencia com o mesmo nome do jogo inserido e substitui ela pela referencia inserida
		this.loja.atualizar(jogo);
	}
	
	
	
	
	
}
