package UI;

import java.util.Scanner;

public class Programa {
	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		boolean Tlogin = false, logado = false, Tprincipal = false, Tloja = false, Tloja1 = false, Tloja2 = false,
				Tgrupo = false, Tperfil = false, sair = false;// telas
		int op;

		while (sair == false) {// programa

			while (!logado) {
				System.out.println("Bem vindo à Steam! O que deseja fazer?");
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
					System.out.println("Digite um novo usuário e senha");
					System.out.println("Usuario: ");
					String usuario = in.nextLine();
					System.out.println("Senha: ");
					String senha = in.nextLine();
					System.out.println("Digite o seu email:");
					String email = in.nextLine();
					// Testar se usuário já existe, se já existir, jogar exceção try catch
					System.out.println("Cadastro efetuado com sucesso!");// só pode chegar aqui se nao ocorrer excecoes
				} else if (op == 1) {
					System.out.println("LOGIN \n");
					System.out.println("Digite seu usuário:");
					String usuario = in.nextLine();
					System.out.println("Digite sua senha:");
					String senha = in.nextLine();
					// se conseguir logar
					logado = true;
					Tprincipal = true;
					System.out.println("Bem vindo, user.");
					// Testar se usuario e senha batem, senão, jogar exceção
				} else {
					// Jogar exceção de Entrada Invalida
				}
			}

			while (!sair && logado) {
				while (Tprincipal) {
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
						// Joga exceção de Entrada Invalida
					}
				}

				while (Tloja) {
					System.out.println("Bem vindo a nossa loja. Escolha uma das opções abaixo!");
					System.out.println("1 - Selecionar Jogo no Catalogo");
					System.out.println("2 - Cadastrar Jogo");
					System.out.println("0 - Voltar");
					int op2 = in.nextInt();
					in.nextLine();
					if (op2 == 0) {
						Tloja = false;
						Tprincipal = true;
					} else if (op2 == 1) {
						// imprimir catalogo
						System.out.println("Digite o nome do jogo selecionado:");
						// chama metodo de procurar dentro de try catch
						Tloja1 = true;// caso procurar funcione
						Tloja = false;// caso procurar funcione

					} else if (op2 == 2)
						System.out.println("Digite o nome do jogo a ser cadastrado:");
					String nomeJogo = in.nextLine();
					System.out.println("Digite o valor do jogo a ser cadastrado:");
					double precoJogo = in.nextDouble();
					in.nextLine();
					System.out.println("Insira uma breve descrição do jogo cadastrado:");
					String descricao = in.nextLine();

				}
				while (Tloja1) {// encontrou o jogo procurado
					// informacoes do jogo
					System.out.println("1 - Comprar");
					System.out.println("2 - Remover");
					System.out.println("3 - Atualizar");
					System.out.println("0 - Voltar");
					int op2 = in.nextInt();
					in.nextLine();
					if (op2 == 0) {
						Tloja1 = false;
						Tloja = true;
					} else if (op2 == 1) {
						System.out.println("Tem certeza?\n1 - Sim\n2 - Nao");
						op = in.nextInt();
						in.nextLine();
						if (op == 1) {
							// adicionar na lista de jogo do usuario e debitar da carteira
						}
					} else if (op2 == 2) {
						
					}else if(op2==3) {
						
					}else {
						
					}
				}

				while (Tgrupo) {
					// Imprimir a lista de grupos disponíveis
					// Se não tiver grupos, apenas exibir Não há grupos disponiveis
					System.out.println(
							"Bem vindo a nossa comunidade. Onde você pode interagir com outros usuários sobre seus jogos favoritos. \n Escolha uma das opções abaixo!");
					System.out.println("1 - Selecionar Grupo");
					System.out.println("2 - Cadastrar Grupo");
					System.out.println("0 - Voltar");
					int op2 = in.nextInt();
					in.nextLine();

					if (op2 == 0) {

					} else if (op2 == 1) {
						System.out.println("Digite o nome do grupo selecionado:");
						String nomeGrupo = in.nextLine();
					} else if (op2 == 2) {
						System.out.println("Digite o nome do grupo a ser cadastrado:");
						String nomeGrupo = in.nextLine();
						System.out.println("Digite a categoria do grupo a ser cadastrado:");
						String categoriaGrupo = in.nextLine();

					}

				}

				while (Tperfil) {
					// NOME DA PESSOA//
					// Status//
					System.out.println("Escolha uma das opções abaixo:");
					System.out.println("1 - Adicionar amigo");
					System.out.println("2 - Ver lista de amigos");
					System.out.println("3 - Atualizar status");
					System.out.println("0 - Voltar");

					int op2 = in.nextInt();
					in.nextLine();

					if (op2 == 0) {

					} else if (op2 == 1) {
						System.out.println("Digite o nome do usuário que gostaria de adicionar a sua lista de amigos.");
						// metodo de procurar
						String nickAmigo = in.nextLine();
					} else if (op2 == 2) {
						System.out.println("Digite o nome do amigo que deseja visitar o perfil");
						String nickAmigo = in.nextLine();
					} else if (op2 == 3) {
						System.out.println("Digite o novo status a ser exibido:");
						String novoStatus = in.nextLine();
					}
				}
			}

		}
		System.out.println("Programa Encerrado! Obrigado pela visita.\n\n\t\t\tVolte Sempre!!!");

	}

}
