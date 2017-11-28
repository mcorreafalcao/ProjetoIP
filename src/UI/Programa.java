package UI;

/**
 *	VER COMENTARIO ABAIXO
 * 
 * Lembrar de colocar todas as atribuicoes de op em um try catch, pois pode gerar InputMismatchEsception.
 * Ou isso é desnecessário??
 */

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

import pacoteClassesGrupo.Grupo;
import pacoteClassesProduto.Demo;
import pacoteClassesProduto.Jogo;
import pacoteClassesProduto.Produto;
import pacoteClassesProduto.RepositorioProdutos;
import pacoteClassesUsuario.Usuario;
import pacoteExcecoes.CIException;
import pacoteExcecoes.EIException;
import pacoteExcecoes.GJCException;
import pacoteExcecoes.GNEException;
import pacoteExcecoes.PJCException;
import pacoteExcecoes.PJOException;
import pacoteExcecoes.PNCException;
import pacoteExcecoes.SMPCException;
import pacoteExcecoes.UJCException;
import pacoteExcecoes.UNCException;
import pacoteExcecoes.VNEDException;

public class Programa {

	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) throws PJCException, UNCException {
		boolean logado = false, Tprincipal = false, Tloja = false, Tloja1 = false, Tgrupo = false, Tgrupo1 = false,
				Tperfil = false, sair = false;// telas
		String op;
		Usuario usuarioLogado = null;
		Produto produtoSelecionado = null;
		Grupo grupoSelecionado = null;

		System.out.println("Escolha em que tipo de repositorio o programa ira rodar!");
		System.out.println("Digite 1 array");
		System.out.println("Ou 2 para lista encadeada");
		int escolhaRepositorio = in.nextInt();
		in.nextLine();
		Fachada fachada = null;
		try {
			fachada = new Fachada(escolhaRepositorio);
		} catch (EIException e) {
			System.out.println("O tipo de repositorio escolhido nao e valido.");
		} 

		while (!sair) {// programa

			while (!logado) {// tela inicial
				System.out.println("Bem vindo a Steam! O que deseja fazer?");
				System.out.println("1 - Fazer login");
				System.out.println("2 - Crie sua conta");
				System.out.println("0 - Sair");

				op = in.nextLine();

				if (op.equals("0")) {
					logado = true;
					sair = true;
				} else if (op.equals("2")) {
					System.out.println("CADASTRO \n");
					System.out.println("Digite um novo usuario e senha");
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
						System.out.println("Este usuario ja foi cadastrado. Tente novamente com um novo nick.");
					} catch (SMPCException e) {
						System.out.println("Não há memória para cadastro.");
					}
				} else if (op.equals("1")) {
					System.out.println("LOGIN \n");
					System.out.println("Digite seu usuario:");
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
							System.out.println("Senha invalida.");
						}
					} else {
						System.out.println("O usuario nao existe.");
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
					op = in.nextLine();
					if (op.equals("0")) {// volta pra tela de login
						logado = false;// isso faz ele voltar pra tela de login
						Tprincipal = false;// sai da tela principal
					} else if (op.equals("1")) {
						Tprincipal = false;
						Tloja = true;
					} else if (op.equals("2")) {
						Tprincipal = false;
						Tgrupo = true;
					} else if (op.equals("3")) {
						Tprincipal = false;
						Tperfil = true;
					} else {
						System.out.println("Entrada invalida, tente outra vez");
					}
				}

				while (Tloja) {// menu da loja
					System.out.println("Estes sao os produtos disponiveis:");
					System.out.println(fachada.listarProdutos());
					System.out.println("Bem vindo a nossa loja. Escolha uma das opcoes abaixo!");
					System.out.println("1 - Selecionar Jogo no Catalogo");
					System.out.println("2 - Cadastrar Jogo");
					System.out.println("0 - Voltar");
					op = in.nextLine();
			
					if (op.equals("0")) {// sair do menu de loja
						Tloja = false;
						Tprincipal = true;
					} else if (op.equals("1")) {// selecionar jogo do catalogo
						System.out.println("Digite o nome do jogo selecionado:");
						String nomeProduto = in.nextLine();
						try {
							produtoSelecionado = fachada.buscarProduto(nomeProduto);// implementado
							Tloja1 = true;// caso procurar funcione
							Tloja = false;// caso procurar funcione
						} catch (PNCException e) {
							System.out.println("Produto nao encontrado.");
						}

					} else if (op.equals("2")) {// cadastrar jogo
						System.out.println("Digite o nome do jogo a ser cadastrado:");
						String nomeProduto = in.nextLine();
						System.out.println("Digite o valor do jogo a ser cadastrado (insira 0 caso seja uma demo):");
						double precoProduto = in.nextDouble();
						in.nextLine();
						System.out.println("Insira uma breve descricao do jogo cadastrado:");
						String descricao = in.nextLine();
						System.out.println("Qual o tamanho do jogo");
						double tamanhoMB = in.nextDouble();
						in.nextLine();
						// cria nova referencia de jogo a ser adicionada na lista, capturando escecao de
						// jogo ja cadastrado
						Produto novoProduto;
						if (precoProduto == 0.0) {// será demo
							novoProduto = new Demo(nomeProduto, descricao, usuarioLogado);
						} else {// será jogo
							novoProduto = new Jogo(nomeProduto, descricao, usuarioLogado, precoProduto,tamanhoMB);
						}
						try {
							fachada.cadastrarProduto(novoProduto);// implementado
							System.out.println("Cadastro efetuado com sucesso!");
						} catch (PJCException e) {
							System.out.println("Este jogo ja foi cadastrado. Tente novamente com um novo nome.");
						} catch (SMPCException e) {
							System.out.println("Não ha mais espaco para cadastro nos nossos servidores, desculpe");
							e.printStackTrace();
						}
					}
				}
				while (Tloja1) {// encontrou o jogo procurado (menu de selecao)
					System.out.println(produtoSelecionado.getInfo());// informacoes do produto
					System.out.println("1 - Comprar");
					System.out.println("2 - Remover");
					System.out.println("3 - Atualizar");
					System.out.println("4 - rodar");
					System.out.println("0 - Voltar");
					op = in.nextLine();
				
					if (op.equals("0")) {
						Tloja1 = false;
						Tloja = true;
					} else if (op.equals("1")) {
						System.out.println("Tem certeza?\n1 - Sim\n2 - Nao");
						op = in.nextLine();
						if (op.equals("1")) {
							
								try {
									fachada.comprarProduto(produtoSelecionado, usuarioLogado);
									System.out.println("Produto comprado");//chega aqui se n levantar nenhuma excecao
								} catch (PJOException e) {
									System.out.println("Produto já obtidor");
								} catch (CIException e) {
									System.out.println("Credito insuficiente");
								} catch (SMPCException e) {
									System.out.println("Sem memoria para download");
								}
							
						}
					} else if (op.equals("2")) {
						// metodo que confere se o usuario ï¿½ o dev do jogo. Se for, remove do
						// catalogo, se nao, captura excecao (voce nao ï¿½ o criador)
						// se remover, voltar para a Tloja, pois em Tloja1 a referencia do jogo nao
						// existirï¿½ mais
						try {
							fachada.removerProduto(produtoSelecionado, usuarioLogado);
							System.out.println("Produto removido com sucesso.");
						} catch (PNCException e) {
							System.out.println("Produto nao cadastrado");
						} catch (VNEDException e) {
							System.out.println("Voce nao eh o desenvolvedor");
						}
						Tloja1 = false;
						Tloja = true;
					} else if (op.equals("3")) {
						// try catch inputmismatchexception aqui
						//System.out.println("Digite o nome do produto a ser alterado: ");
						//String nome = in.nextLine();
						System.out.println("Digite a nova descricao do produto: ");
						String descricao = in.nextLine();
						System.out.println("digite o novo preco: ");
						double preco = in.nextDouble();
						Produto produtoAlterado = null;
						// cria nova referencia para produto que substituirï¿½ a referencia atual
						if (preco == 0.0) {// nova demo
							produtoAlterado = new Demo(produtoSelecionado.getNome(), descricao, usuarioLogado);
						} else {// novo jogo
							produtoAlterado = new Jogo(produtoSelecionado.getNome(), descricao, usuarioLogado, preco,((Jogo) produtoSelecionado).getTamanho());
						}
						try {
							// abaixo metodo que confere se o usuario ï¿½ o dev do jogo. Se for, troca a
							// referencia pela nova criada neste if
							fachada.atualizarProduto(produtoSelecionado, produtoAlterado);// implementado
						} catch (PNCException e) {
							System.out.println("Produto nao cadastrado");
						}

					} else if(op.equals("4")){//rodar produto
						String aux = fachada.rodarProduto(produtoSelecionado, usuarioLogado);
						System.out.println(aux);
					}
					else {
						System.out.println("Entrada invalida, tente novamente");
					}
				}

				while (Tgrupo) {
					// Imprimir a lista de grupos disponï¿½veis
					// Se nï¿½o tiver grupos, apenas exibir Nï¿½o hï¿½ grupos disponiveis
					System.out.println(
							"Bem vindo a nossa comunidade. Onde voce pode interagir com outros usuarios sobre seus jogos favoritos. \n Escolha uma das opcoes abaixo!");
					System.out.println("1 - Selecionar Grupo");
					System.out.println("2 - Cadastrar Grupo");
					System.out.println("0 - Voltar");
				    op = in.nextLine();
				    in.nextLine();

					if (op.equals("0")) {
						Tgrupo = false;
						Tprincipal = true;
					} else if (op.equals("1")) {// abrir grupo selecionado
						System.out.println("Digite o nome do grupo selecionado:");
						String nomeGrupo = in.nextLine();
						try {
							grupoSelecionado = fachada.buscarGrupo(nomeGrupo);
							Tgrupo1 = true;// caso procurar funcione
							Tgrupo = false;// caso procurar funcione
						} catch (GNEException e) {
							System.out.println("Grupo nao encontrado.");
						}
					} else if (op.equals("2")) {
						System.out.println("Digite o nome do grupo a ser cadastrado:");
						String nomeGrupo = in.nextLine();
						System.out.println("Digite a categoria do grupo a ser cadastrado:");
						String categoriaGrupo = in.nextLine();
						Grupo novoGrupo = new Grupo(nomeGrupo, categoriaGrupo);
						try {
							fachada.cadastrarGrupo(novoGrupo);
							System.out.println("Cadastro efetuado com sucesso!");
						} catch (GJCException e) {
							System.out.println("Este grupo ja foi cadastrado. Tente novamente com um novo nome.");
						}catch(SMPCException e) {
							e.printStackTrace();
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
					op = in.nextLine();
					if (op.equals("0")) {
						Tgrupo1 = false;
						Tgrupo = true;
					} else if (op.equals("1")) {// entrar em grupo
						try {
							fachada.entrarGrupo(usuarioLogado, grupoSelecionado);
							System.out.println("Você agora faz parte do grupo " + grupoSelecionado.getNomeGrupo());
						} catch (UJCException e) {
							System.out.println("Usuario ja cadastrado");
						}catch (SMPCException e) {
							System.out.println("Sem memoria para cadastro");
						}
					} else if (op.equals("2")) {// sair do grupo
						try {
							fachada.sairGrupo(usuarioLogado, grupoSelecionado);
							System.out.println("Você saiu do grupo " + grupoSelecionado.getNomeGrupo());
						} catch (UNCException e) {
							System.out.println("Usuario nao cadastrado");
						}
					} else if (op.equals("3")) {
						System.out.println("Digite a categoria do grupo a ser atualizado:");
						String categoriaGrupo = in.nextLine();
						Grupo novoGrupo = new Grupo(grupoSelecionado.getNomeGrupo(), categoriaGrupo);
						try {
							fachada.atualizarGrupo(novoGrupo);
							System.out.println("Grupo atualizado com sucesso!");
						} catch (GNEException e) {
							System.out.println("Este grupo ja foi atualizado. Tente novamente com um novo grupo.");
						}

					} else if (op.equals("4")) {
						try {
							fachada.removerGrupo(grupoSelecionado);
						} catch (GNEException e) {
							System.out.println("O grupo a ser removido nao existe.");
						}
					} else {
						System.out.println("Entrada invalida, tente novamente");
					}
				}

				while (Tperfil) {// tela do usuario atual
					System.out.println("Escolha uma das opcoes abaixo:");
					System.out.println("1 - Atualizar informacoes");//listar,selecionar
					System.out.println("3 - Ver saldo da conta");
					System.out.println("0 - Voltar");

					op = in.nextLine();

					if (op.equals("0")) {
						Tperfil = false;
						Tprincipal = true;
					} else if (op.equals("1")) {
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
					} else if (op.equals("2")) {
						RepositorioProdutos aux = usuarioLogado.getProdutos();
						System.out.println("Produtos adquiridos: " + aux.listarProdutos());
					} else if (op.equals("3")) {
						double saldo = usuarioLogado.getCarteira();
						System.out.println(saldo);
					}
				}

			}
			System.out.println("Programa Encerrado! Obrigado pela visita.\n\n\t\t\tVolte Sempre!!!");
		}

	}
}
