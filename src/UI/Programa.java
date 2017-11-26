package UI;

/**
 * lembrar de colocar todas as atribuicoes de op em um try catch, pois pode gerar InputMismatchEsception
 */
import java.util.Scanner;

import pacoteClassesGrupo.EntradaInvalidaException;
import pacoteClassesGrupo.Grupo;
import pacoteClassesGrupo.GrupoJaCadastradoException;
import pacoteClassesGrupo.GrupoNaoEncontradoException;
import pacoteClassesProduto.EIException;
import pacoteClassesProduto.JNCException;
import pacoteClassesProduto.Jogo;
import pacoteClassesProduto.PNCException;
import pacoteClassesProduto.Produto;
import pacoteClassesUsuario.UJCException;
import pacoteClassesUsuario.UNCException;
import pacoteClassesUsuario.Usuario;

public class Programa {

	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		boolean logado = false, Tprincipal = false, Tloja = false, Tloja1 = false, Tgrupo = false, Tgrupo1 = false, Tperfil = false, Tperfil1 = false, sair = false;// telas
		int op;
		Usuario usuarioLogado;
		Produto produtoSelecionado;
		Grupo grupoSelecionado;

		System.out.println("Escolha em que tipo de repositório o programa irá rodar!");
		System.out.println("Digite 1 array");
		System.out.println("Ou 2 para lista encadeada");
		int escolhaRepositorio = in.nextInt();
		in.nextLine();
		Fachada fachada = null;
		try {
			fachada = new Fachada(escolhaRepositorio);
		} catch (EIException e) {
			System.out.println("O tipo de repositório escolhido não é válido.");
		} catch (EntradaInvalidaException e) {
			System.out.println("O tipo de repositório escolhido não é válido.");
		}

		while (!sair) {// programa

			while (!logado) {// tela inicial
				System.out.println("Bem vindo � Steam! O que deseja fazer?");
				System.out.println("1 - Fazer login");
				System.out.println("2 - Crie sua conta");
				System.out.println("0 - Sair");

				op = in.nextInt();
				in.nextLine();

				if (op == 0) {
					logado = true;
					sair = true;
				} else if (op == 2) {
					System.out.println("CADASTRO \n");
					System.out.println("Digite um novo usu�rio e senha");
					System.out.println("Usuario: ");
					String usuario = in.nextLine();
					System.out.println("Senha: ");
					String senha = in.nextLine();
					System.out.println("Digite o seu email:");
					String email = in.nextLine();

					Usuario novoUsuario = new Usuario(usuario, senha, email);
					try {
						fachada.cadastrarUsuario(novoUsuario);
						System.out.println("Cadastro efetuado com sucesso!");
					} catch (UJCException e) {
						System.out.println("Este usuário já foi cadastrado. Tente novamente com um novo nick.");
					}
				} else if (op == 1) {
					System.out.println("LOGIN \n");
					System.out.println("Digite seu usu�rio:");
					String usuario = in.nextLine();
					System.out.println("Digite sua senha:");
					String senha = in.nextLine();
					// se conseguir logar
					if (fachada.nickExiste(usuario)) {
						usuarioLogado = fachada.buscarUsuario(usuario);
						if (usuarioLogado.getSenha().equals(senha)) {
							logado = true;
							Tprincipal = true;
							System.out.println("Bem vindo, " + usuario + ".");
						} else {
							System.out.println("Senha inválida.");
						}
					} else {
						System.out.println("O usuário não existe.");
					}
				} else {
					System.out.println("Entrada invalida, tente outra vez");
				}
			} // fim da tela inicial

			while (!sair && logado) {
				while (Tprincipal) {// tela principal
					System.out.println("O que deseja fazer?");
					System.out.println("1 - Acessar a loja");
					System.out.println("2 - Acessar a comunidade");
					System.out.println("3 - Acessar seu perfil");
					System.out.println("0 - Deslogar");
					op = in.nextInt();
					in.nextLine();
					if (op == 0) {// volta pra tela de login
						logado = false;// isso faz ele voltar pra tela de login
						Tprincipal = false;// sai da tela principal
					} else if (op == 1) {
						Tprincipal = false;
						Tloja = true;
					} else if (op == 2) {
						Tprincipal = false;
						Tgrupo = true;
					} else if (op == 3) {
						Tprincipal = false;
						Tperfil = true;
					} else {
						System.out.println("Entrada invalida, tente outra vez");
					}
				}

				while (Tloja) {// menu da loja
					System.out.println("Estes sao os jogos dispon�veis:");
					System.out.println(fachada.listarProdutos());
					System.out.println("Bem vindo a nossa loja. Escolha uma das op��es abaixo!");
					System.out.println("1 - Selecionar Jogo no Catalogo");
					System.out.println("2 - Cadastrar Jogo");
					System.out.println("0 - Voltar");
					op = in.nextInt();
					in.nextLine();
					if (op == 0) {// sair do menu de loja
						Tloja = false;
						Tprincipal = true;
					} else if (op == 1) {// selecionar jogo do catalogo
						System.out.println("Digite o nome do jogo selecionado:");
						String nomeProduto = in.nextLine();
						try {
							produtoSelecionado = fachada.buscarProduto(nomeProduto);
							Tloja1 = true;// caso procurar funcione
							Tloja = false;// caso procurar funcione
						} catch (PNCException e) {
							System.out.println("Produto não encontrado.");
						}

					} else if (op == 2) {// cadastrar jogo
						System.out.println("Digite o nome do jogo a ser cadastrado:");
						String nomeJogo = in.nextLine();
						System.out.println("Digite o valor do jogo a ser cadastrado:");
						double precoJogo = in.nextDouble();
						in.nextLine();
						System.out.println("Insira uma breve descri��o do jogo cadastrado:");
						String descricao = in.nextLine();
						// cria nova referencia de jogo a ser adicionada na lista, capturando escecao de jogo ja cadastrado
						Produto novoJogo = new Produto();
						try {
							fachada.cadastrarProduto(novoJogo);
							System.out.println("Cadastro efetuado com sucesso!");
						} catch (UJCException e) {
							System.out.println("Este jogo já foi cadastrado. Tente novamente com um novo nome.");
						}
					}
				}
				while (Tloja1) {// encontrou o jogo procurado
					// informacoes do jogo
					System.out.println("1 - Comprar");
					System.out.println("2 - Remover");
					System.out.println("3 - Atualizar");
					System.out.println("0 - Voltar");
					op = in.nextInt();
					in.nextLine();
					if (op == 0) {
						Tloja1 = false;
						Tloja = true;
					} else if (op == 1) {
						System.out.println("Tem certeza?\n1 - Sim\n2 - Nao");
						op = in.nextInt();
						in.nextLine();
						if (op == 1) {
							// ver se ele ja possui o jogo na lista de jogos dele
							// adicionar na lista de jogo do usuario e debitar da carteira capturando excecoes
							System.out.println("Jogo comprado!");
						}
					} else if (op == 2) {
						// metodo que confere se o usuario � o dev do jogo. Se for, remove do catalogo, se nao, captura excecao (voce nao � o criador)
						// se remover, voltar para a Tloja, pois em Tloja1 a referencia do jogo nao existir� mais
						Tloja1 = false;
						Tloja = true;
					} else if (op == 3) {
						// try catch inputmismatchexception aqui
						System.out.println("Digite o nome do jogo a ser alterado: ");
						String nome = in.nextLine();
						System.out.println("Digite a nova descricao do jogo: ");
						String descricao = in.nextLine();
						System.out.println("digite o novo preco: ");
						double preco = in.nextDouble();
						// cria nova referencia para jogo que substituir� a referencia atual
						// metodo que confere se o usuario � o dev do jogo. Se for, troca a referencia pela nova criada neste if

					} else {
						System.out.println("Entrada invalida, tente novamente");
					}
				}

				while (Tgrupo) {
					// Imprimir a lista de grupos dispon�veis
					// Se n�o tiver grupos, apenas exibir N�o h� grupos disponiveis
					System.out.println(
							"Bem vindo a nossa comunidade. Onde voc� pode interagir com outros usu�rios sobre seus jogos favoritos. \n Escolha uma das op��es abaixo!");
					System.out.println("1 - Selecionar Grupo");
					System.out.println("2 - Cadastrar Grupo");
					System.out.println("0 - Voltar");
					int op2 = in.nextInt();
					in.nextLine();

					if (op2 == 0) {
						Tgrupo = false;
						Tprincipal = true;
					} else if (op2 == 1) {// abrir grupo selecionado
						System.out.println("Digite o nome do grupo selecionado:");
						String nomeGrupo = in.nextLine();
						try {
							grupoSelecionado = fachada.buscarGrupo(nomeGrupo);
							Tgrupo1 = true;// caso procurar funcione
							Tgrupo = false;// caso procurar funcione
						} catch (GrupoNaoEncontradoException e) {
							System.out.println("Grupo não encontrado.");
						}
					} else if (op2 == 2) {
						System.out.println("Digite o nome do grupo a ser cadastrado:");
						String nomeGrupo = in.nextLine();
						System.out.println("Digite a categoria do grupo a ser cadastrado:");
						String categoriaGrupo = in.nextLine();
						Grupo novoGrupo = new Grupo(nomeGrupo, categoriaGrupo);
						try {
							fachada.cadastrarGrupo(novoGrupo);
							System.out.println("Cadastro efetuado com sucesso!");
						} catch (GrupoJaCadastradoException e) {
							System.out.println("Este grupo já foi cadastrado. Tente novamente com um novo nome.");
						}

					} else {
						System.out.println("Entrada invalida, tente novamente");
					}

				}
				while (Tgrupo1) {// opcoes para o grupo encontrado em "selecionar"
					// info do grupo
					System.out.println("1 - Entrar");
					System.out.println("2 - Sair do grupo");
					System.out.println("3 - Atualizar informacoes");
					System.out.println("4 - Apagar grupo");
					System.out.println("0 - Sair");
					op = in.nextInt();
					in.nextLine();
					if (op == 0) {
						Tgrupo1 = false;
						Tgrupo = true;
					} else if (op == 1) {// entrar em grupo
						if (fachada.entrarGrupo(usuarioLogado, grupoSelecionado)) {

						}
					} else if (op == 2) {
						if (fachada.sairGrupo(usuarioLogado, grupoSelecionado)) {

						}
					} else if (op == 3) {
						System.out.println("Digite a categoria do grupo a ser atualizado:");
						String categoriaGrupo = in.nextLine();
						Grupo novoGrupo = new Grupo(grupoSelecionado.getNomeGrupo(), categoriaGrupo);
						try {
							fachada.atualizarGrupo(novoGrupo);
							System.out.println("Grupo atualizado com sucesso!");
						} catch (GrupoNaoEncontradoException e) {
							System.out.println("Este grupo já foi atualizado. Tente novamente com um novo grupo.");
						}

					} else if (op == 4) {
						try {
							fachada.removerGrupo(grupoSelecionado);
						} catch (GrupoNaoEncontradoException e) {
							System.out.println("O grupo a ser removido nao existe.");
						}
					} else {
						System.out.println("Entrada invalida, tente novamente");
					}
				}

				while (Tperfil) {// tela do usuario atual
					System.out.println("Escolha uma das op��es abaixo:");
					System.out.println("1 - Atualizar informacoes");
					System.out.println("0 - Voltar");

					op = in.nextInt();
					in.nextLine();

					if (op == 0) {
						Tperfil = false;
						Tprincipal = true;
					} else if (op == 1) {
						System.out.println("Digite as novas informacoes a serem atualizadas");
						System.out.println("Senha: ");
						String senha = in.nextLine();
						System.out.println("Digite o seu email:");
						String email = in.nextLine();

						Usuario novoUsuario = new Usuario(usuarioLogado.getNick(), senha, email);
						try {
							fachada.atualizarUsuario(novoUsuario);
							System.out.println("Informacoes atualizadas com sucesso!");
						} catch (UNCException e) {
							System.out.println("Nao foi encontrado usuario com este nome.");
						}
						Tperfil = false;
					}
				}

			}
			System.out.println("Programa Encerrado! Obrigado pela visita.\n\n\t\t\tVolte Sempre!!!");
		}

	}
}
