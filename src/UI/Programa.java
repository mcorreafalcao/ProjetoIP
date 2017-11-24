package UI;
/**
 * lembrar de colocar todas as atribuicoes de op em um try catch, pois pode gerar InputMismatchEsception
 */
import java.util.Scanner;

public class Programa {
	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		boolean logado = false, Tprincipal = false, Tloja = false, Tloja1 = false, 
				Tgrupo = false,Tgrupo1=false, Tperfil = false,Tperfil1=false, sair = false;// telas
		int op;

		while (sair == false) {// programa

			while (!logado) {//tela inicial
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
					// Testar se usuário já existe, se já existir, tratar exceção através de try catch
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
					System.out.println("Entrada invalida, tente outra vez");//imprimir a mesma coisa caso capture InputMismatchException
				}
			}//fim da tela inicial

			while (!sair && logado) {
				while (Tprincipal) {//tela principal
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

				while (Tloja) {//menu da loja
					System.out.println("Estes sao os jogos disponíveis:");
					//listar catalogo
					System.out.println("Bem vindo a nossa loja. Escolha uma das opções abaixo!");
					System.out.println("1 - Selecionar Jogo no Catalogo");
					System.out.println("2 - Cadastrar Jogo");
					System.out.println("0 - Voltar");
					op = in.nextInt();
					in.nextLine();
					if (op == 0) {//sair do menu de loja
						Tloja = false;
						Tprincipal = true;
					} else if (op == 1) {//selecionar jogo do catalogo
						// imprimir catalogo
						System.out.println("Digite o nome do jogo selecionado:");
						// chama metodo de procurar dentro de try catch
						
						Tloja1 = true;// caso procurar funcione
						Tloja = false;// caso procurar funcione

					} else if (op == 2){//cadastrar jogo
					System.out.println("Digite o nome do jogo a ser cadastrado:");
					String nomeJogo = in.nextLine();
					System.out.println("Digite o valor do jogo a ser cadastrado:");
					double precoJogo = in.nextDouble();
					in.nextLine();
					System.out.println("Insira uma breve descrição do jogo cadastrado:");
					String descricao = in.nextLine();
					//cria nova referencia de jogo a ser adicionada na lista, capturando escecao de jogo ja cadastrado
					
					//se nao capturar excecao
					System.out.println("Jogo cadastrado com sucesso!");
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
							//ver se ele ja possui o jogo na lista de jogos dele
							// adicionar na lista de jogo do usuario e debitar da carteira capturando excecoes
							System.out.println("Jogo comprado!");
						}
					} else if (op == 2) {
						//metodo que confere se o usuario é o dev do jogo. Se for, remove do catalogo, se nao, captura excecao (voce nao é o criador)
						//se remover, voltar para a Tloja, pois em Tloja1 a referencia do jogo nao existirá mais
						Tloja1=false;
						Tloja=true;
					}else if(op==3) {
						//try catch inputmismatchexception aqui
						System.out.println("Digite o nome do jogo a ser alterado: ");
						String nome = in.nextLine();
						System.out.println("Digite a nova descricao do jogo: ");
						String descricao = in.nextLine();
						System.out.println("digite o novo preco: ");
						double preco = in.nextDouble();
						//cria nova referencia para jogo que substituirá a referencia atual
						//metodo que confere se o usuario é o dev do jogo. Se for, troca a referencia pela nova criada neste if
						
					}else {
						System.out.println("Entrada invalida, tente novamente");
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
						Tgrupo=false;
						Tprincipal=true;
					} else if (op2 == 1) {//abrir grupo selecionado
						System.out.println("Digite o nome do grupo selecionado:");
						String nomeGrupo = in.nextLine();
					} else if (op2 == 2) {
						System.out.println("Digite o nome do grupo a ser cadastrado:");
						String nomeGrupo = in.nextLine();
						System.out.println("Digite a categoria do grupo a ser cadastrado:");
						String categoriaGrupo = in.nextLine();

					}else{
						System.out.println("Entrada invalida, tente novamente");
					}

				}
				while(Tgrupo1){//opcoes para o grupo encontrado em "selecionar"
					//info do grupo
					System.out.println("1 - Entrar");
					System.out.println("2 - Sair do grupo");
					System.out.println("3 - Atualizar informacoes");
					System.out.println("4 - Apagar grupo");
					System.out.println(") - Sair");
					op = in.nextInt();
					in.nextLine();
					if(op==0){
						Tgrupo1=false;
						Tgrupo=true;
					}else if(op==1){//entrar em grupo
						//adicionar grupo na lista de grupos do usuario
						//adicionar usuario na lista de usuarios do grupo
					}else if(op==2){
						//remover usuario da lista de usuarios do grupo
						//remover grupo da lista de grupos do usuario
					}else if(op==3){
						//criar nova referencia para o grupo, perguntar alteraçoec e substituir a referencia atual
					}else if(op==4){
						//remover referencia da lista de grupos
						//isso ja removerá o grupo da lista de grupos do usuario??
					}else{
						System.out.println("Entrada invalida, tente novamente");
					}
				}

				while (Tperfil) {//tela do usuario atual
					// NOME DA PESSOA//
					// Status//
					System.out.println("Escolha uma das opções abaixo:");
					System.out.println("1 - Ver lista de amigos");
					System.out.println("2 - Adicionar amigo");
					System.out.println("3 - Atualizar status");
					System.out.println("0 - Voltar");

					op = in.nextInt();
					in.nextLine();

					if (op == 0) {
						Tperfil=false;
						Tprincipal=true;
					} else if (op == 1) {
						//listar amigos
						System.out.println("Digite o nome do amigo que deseja visitar o perfil");
						String nickAmigo = in.nextLine();
						//procurar
						//se encontrar
						Tperfil=false;
						Tperfil1=true;
					} else if (op == 2) {
						System.out.println("Digite o nome do usuário que gostaria de adicionar a sua lista de amigos.");
						String nickAmigo = in.nextLine();
						// metodo de procurar
						//confere se ja nao é amigo, depois confere se usuario existe mesmo, entao adiciona caso nao capture exceção
					} else if (op == 3) {
						System.out.println("Digite o novo status a ser exibido:");
						String novoStatus = in.nextLine();
						//setter aqui
					}
				}
				while(Tperfil1){//perfil do amigo
					//info
					System.out.println("Escolha uma das opções abaixo:");
					System.out.println("1 - Remover amigo");
					System.out.println("0 - Voltar");
					
				}
			}

		}
		System.out.println("Programa Encerrado! Obrigado pela visita.\n\n\t\t\tVolte Sempre!!!");

	}

}
