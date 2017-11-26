package UI;

import pacoteClassesGrupo.EntradaInvalidaException;
import pacoteClassesGrupo.Grupo;
import pacoteClassesGrupo.GrupoJaCadastradoException;
import pacoteClassesGrupo.GrupoNaoEncontradoException;
import pacoteClassesGrupo.NegocioGrupo;
import pacoteClassesProduto.EIException;
import pacoteClassesProduto.Jogo;
import pacoteClassesProduto.PNCException;
import pacoteClassesProduto.Produto;
import pacoteClassesProduto.SMPCException;
import pacoteClassesProduto.NegocioProduto;
import pacoteClassesProduto.PJCException;
import pacoteClassesUsuario.NegocioUsuario;
import pacoteClassesUsuario.UJCException;
import pacoteClassesUsuario.UNCException;
import pacoteClassesUsuario.Usuario;

public class Fachada {

	private NegocioProduto loja;
	private NegocioGrupo comunidade;
	private NegocioUsuario usuario;

	public Fachada(int repositorio) throws EIException, EntradaInvalidaException {

		this.loja = new NegocioProduto(repositorio);
		this.comunidade = new NegocioGrupo(repositorio);
		this.usuario = new NegocioUsuario(repositorio);
	}
//---------------------------------------------------------------------------------------
//metodos usuario abaixo
	public void cadastrarUsuario(Usuario novoUsuario) throws UJCException {
		// TODO Auto-generated method stub

	}

	public boolean nickExiste(String usuario2) {
		// TODO Auto-generated method stub
		return false;
	}

	public Usuario buscarUsuario(String usuario2) {
		// TODO Auto-generated method stub
		return null;
	}
	public void atualizarUsuario(Usuario novoUsuario) throws UNCException {
		// TODO Auto-generated method stub
		
	}
//metodos usuario acima
//---------------------------------------------------------------------------
//metodos produto abaixo
	public String listarProdutos() {
		String lista ="";
		lista = this.loja.listarProdutos();
		return lista;
		// Retorna uma String com o nome dos produtos separado por \n, lista os produtos assim que acessamos a loja.
		/**
		 * será algo como:
		 * (jogo) zezin
		 * (jogo) falcaodemel
		 * (Demo) kimpissoble
		 */
	}

	public Produto buscarProduto(String nomeProduto) throws PNCException {
		return this.loja.procurar(nomeProduto);
		
	}
	public void cadastrarProduto(Produto novoProduto) throws PJCException, SMPCException {
		this.loja.inserir(novoProduto);
		
	}
	public void comprarProduto(Produto produtoSelecionado, Usuario usuarioLogado) throws CIException {
		if(produtoSelecionado instanceof Jogo){
			if(usuarioLogado.getCarteira()>=((Jogo) produtoSelecionado).getPreco()){
				double carteira = usuarioLogado.getCarteira();
				double preco = ((Jogo) produtoSelecionado).getPreco();
				carteira-=preco;
				usuarioLogado.setCarteira(carteira);
			}else
				throw new CIException();
		}
		
	}
	public void removerProduto(Produto produtoSelecionado, Usuario usuarioSelecionado) throws PNCException, VNEDException {
		if(produtoSelecionado.getDev()==usuarioSelecionado){
			this.loja.remover(produtoSelecionado);
		}else
			throw new VNEDException();
		/**
		 * remove da loja o produto caso o user logado seja dev do produto, levanta excecao caso coantrario
		 */
		
	}
	public void atualizarProduto(Produto produtoSelecionado, Produto produtoAlterado) throws PNCException {
		if(produtoSelecionado.getDev()==produtoAlterado.getDev()){//implica que o user atual é o dono do jogo selecionado, pois o user atual é o dev do alterado
			this.loja.atualizarProduto(produtoAlterado);//procura e troca a referencia encontraada pela nova
		}
		
	}
//metodos produto acima
//-------------------------------------------------------------------------------------------------------
//metodos grupo abaixo
	public Grupo buscarGrupo(String nomeGrupo)throws GrupoNaoEncontradoException {
		// TODO Auto-generated method stub
		// procura o nome do grupo na parte de selecionar

		return null;
	}

	public void cadastrarGrupo(Grupo novoGrupo) throws GrupoJaCadastradoException {
		// TODO Auto-generated method stub

	}

	public boolean entrarGrupo(Usuario usuarioLogado, Grupo grupoSelecionado) {
		// TODO Auto-generated method stub
		// retorna true se o usuario nao estava no grupo e pode entrar
		return false;
	}

	public boolean sairGrupo(Usuario usuarioLogado, Grupo grupoSelecionado) {
		// TODO Auto-generated method stub
		// retorna true se o usuario estava no grupo e pode sair
		return false;
	}

	public void atualizarGrupo(Grupo novoGrupo) throws GrupoNaoEncontradoException {
		// TODO Auto-generated method stub

	}

	public void removerGrupo(Grupo grupoSelecionado) throws GrupoNaoEncontradoException {
		// TODO Auto-generated method stub

	}

//metodos grupo acima

}
