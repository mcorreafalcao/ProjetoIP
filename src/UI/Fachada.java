package UI;

import pacoteClassesGrupo.Grupo;
import pacoteClassesGrupo.NegocioGrupo;
import pacoteClassesProduto.Jogo;
import pacoteClassesProduto.Produto;
import pacoteClassesProduto.NegocioProduto;
import pacoteClassesUsuario.NegocioUsuario;
import pacoteClassesUsuario.RepositorioUsuarios;
import pacoteClassesUsuario.Usuario;
import pacoteExcecoes.CIException;
import pacoteExcecoes.EIException;
import pacoteExcecoes.GJCException;
import pacoteExcecoes.GNEException;
import pacoteExcecoes.PJCException;
import pacoteExcecoes.PNCException;
import pacoteExcecoes.SMPCException;
import pacoteExcecoes.UJCException;
import pacoteExcecoes.UNCException;
import pacoteExcecoes.VNEDException;

public class Fachada {

	private NegocioProduto loja;
	private NegocioGrupo comunidade;
	private NegocioUsuario usuario;
	private Grupo categoria;

	public Fachada(int repositorio) throws EIException{

		this.loja = new NegocioProduto(repositorio);
		this.comunidade = new NegocioGrupo(repositorio);
		this.usuario = new NegocioUsuario(repositorio);
	}

	// ---------------------------------------------------------------------------------------
	// metodos usuario abaixo
	public void cadastrarUsuario(Usuario novoUsuario) throws UJCException, SMPCException {
		this.usuario.inserir(novoUsuario);

	}

	public boolean nickExiste(String usuario2) {
		return this.usuario.existe(usuario2);
	}

	public Usuario buscarUsuario(String usuario2) {
		return this.buscarUsuario(usuario2);
	}

	public void atualizarUsuario(Usuario novoUsuario) throws UNCException {
		// TODO Auto-generated method stub

	}

	// metodos usuario acima
	// ---------------------------------------------------------------------------
	// metodos produto abaixo
	public String listarProdutos() {
		String lista = "";
		lista = this.loja.listarProdutos();
		return lista;
		// Retorna uma String com o nome dos produtos separado por \n, lista os produtos
		// assim que acessamos a loja.
		/**
		 * será algo como: (jogo) zezin (jogo) falcaodemel (Demo) kimpissoble
		 */
	}

	public Produto buscarProduto(String nomeProduto) throws PNCException {
		return this.loja.procurar(nomeProduto);

	}

	public void cadastrarProduto(Produto novoProduto) throws PJCException, SMPCException {
		this.loja.inserir(novoProduto);

	}

	public void comprarProduto(Produto produtoSelecionado, Usuario usuarioLogado) throws CIException {
		if (produtoSelecionado instanceof Jogo) {
			if (usuarioLogado.getCarteira() >= ((Jogo) produtoSelecionado).getPreco()) {
				double carteira = usuarioLogado.getCarteira();
				double preco = ((Jogo) produtoSelecionado).getPreco();
				carteira -= preco;
				usuarioLogado.setCarteira(carteira);
				usuarioLogado.adicionarProduto(produtoSelecionado);//melissa ver isso aqui
			} else
				throw new CIException();
		}

	}

	public void removerProduto(Produto produtoSelecionado, Usuario usuarioSelecionado)
			throws PNCException, VNEDException {
		if (produtoSelecionado.getDev() == usuarioSelecionado) {
			this.loja.remover(produtoSelecionado);
		} else
			throw new VNEDException();
		/**
		 * remove da loja o produto caso o user logado seja dev do produto, levanta
		 * excecao caso coantrario
		 */

	}

	public void atualizarProduto(Produto produtoSelecionado, Produto produtoAlterado) throws PNCException {
		if (produtoSelecionado.getDev() == produtoAlterado.getDev()) {// implica que o user atual é o dono do jogo
																		// selecionado, pois o user atual é o dev do
																		// alterado
			this.loja.atualizarProduto(produtoAlterado);// procura e troca a referencia encontraada pela nova
		}

	}
	public String rodarProduto(Produto produtoSelecionado, Usuario usuarioLogado) {
		return produtoSelecionado.rodar(usuarioLogado);
	}

	// metodos produto acima
	// -------------------------------------------------------------------------------------------------------
	// metodos grupo abaixo
	public Grupo buscarGrupo(String nomeGrupo) throws GNEException {
		return this.comunidade.procurar(nomeGrupo);
		// procura o nome do grupo na parte de selecionar

	}

	public void cadastrarGrupo(Grupo novoGrupo) throws GJCException, SMPCException {
		this.comunidade.cadastrarGrupo(novoGrupo);
	}
	
	/**
	 * lembrar de dar uma checada em entrarGrupo e sairGrupo a seguir
	 * nao tenho certeza se tá certo
	 * @throws UJCException 
	 * @throws SMPCException 
	 */
	public void entrarGrupo(Usuario usuarioLogado, Grupo grupoSelecionado) throws UJCException, SMPCException {
		// retorna true se o usuario nao estava no grupo e pode entrar
		RepositorioUsuarios aux = grupoSelecionado.getMembros();
		aux.inserir(usuarioLogado);
	}

	public void sairGrupo(Usuario usuarioLogado, Grupo grupoSelecionado) throws UNCException {
		// retorna true se o usuario estava no grupo e pode sair
		RepositorioUsuarios auxRemover = grupoSelecionado.getMembros();
		auxRemover.remover(usuarioLogado.getNick());
	}

	public void atualizarGrupo(Grupo categoriaGrupo) throws GNEException {
		if (categoriaGrupo.getNomeGrupo() != categoria.getNomeGrupo()) {// ver se a categoria informada não é a mesma
																		// jaexistente
			this.comunidade.atualizarGrupo(categoriaGrupo);// procura e troca a referencia encontrada pela nova
		}
	}

	public void removerGrupo(Grupo grupoSelecionado) throws GNEException {
		if (grupoSelecionado.getNomeGrupo() == comunidade.getNomeGrupo()) {
			this.comunidade.removerGrupo(grupoSelecionado);
		}

	}

	// metodos grupo acima

}
