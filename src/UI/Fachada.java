package UI;

import pacoteClassesGrupo.EntradaInvalidaException;
import pacoteClassesGrupo.Grupo;
import pacoteClassesGrupo.GrupoJaCadastradoException;
import pacoteClassesGrupo.NegocioGrupo;
import pacoteClassesJogo.EIException;
import pacoteClassesJogo.JNCException;
import pacoteClassesJogo.Jogo;
import pacoteClassesJogo.NegocioJogo;
import pacoteClassesUsuario.NegocioUsuario;
import pacoteClassesUsuario.UJCException;
import pacoteClassesUsuario.Usuario;

public class Fachada {

	private NegocioJogo loja;
	private NegocioGrupo comunidade;
	private NegocioUsuario usuario;

	public Fachada(int repositorio) throws EIException, EntradaInvalidaException {

		this.loja = new NegocioJogo(repositorio);
		this.comunidade = new NegocioGrupo(repositorio);
		this.usuario = new NegocioUsuario(repositorio);
	}

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

	public String listarJogos() {
		// TODO Auto-generated method stub
		// Retornar uma String com o nome dos jogos separado por \n, lista os jogos assim que acessamos a loja.
		return null;
	}

	public Jogo buscarJogo(String nomeJogo) throws JNCException {
		// TODO Auto-generated method stub
		// parei com os metodos do jogo pq tu tem q ajeitar a parte de heranca
		return null;
	}

	public Grupo buscarGrupo(String nomeGrupo) {
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

}
