package pacoteClassesJogo;

/**
 * "Classe colecao de negocio". Ainda nao entendi pra que vai servir essa
 * classe.
 * 
 * @author Gabriel
 */
public class NegocioJogo {
	
	RepositorioJogos loja;
	
	public NegocioJogo (int a, int tam) {
		if(a==1)
			loja = new RepositorioJogosArray(tam);
		else
			loja = new RepositorioJogosLista();
		/**
		 * caso tenhamos q ler o arquivo, pegar o input de tamanho antes de construir
		 */
		
	}
	public void cadastrarJogo(Jogo jogo) throws JJCException, SMPCException {
		this.loja.inserir(jogo);
		
	}
	public void descadastrarJogo(Jogo jogo) throws JNCException {
		this.loja.remover(jogo.getNome());
		
	}
	
	
	
	
	
	
}
