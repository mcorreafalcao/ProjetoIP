package UI;

import java.util.Scanner;

public class Programa {
	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		boolean Tlogin = false, logado = false, Tprincipal = false, Tloja = false, Tgrupo = false, Tperfil = false, sair = false;// telas
		int op;

		/*
		 * while (!logado) {
		 * System.out.println("Bem vindo à Steam! O que deseja fazer?");
		 * System.out.println("1 - Fazer login");
		 * System.out.println("2 - Crie sua conta"); int i = in.nextInt(); if (i == 2)
		 * {// cadastrar usuario
		 * 
		 * } else if (i == 1) {// pede as info, caso exista, faz login e muda booleana
		 * System.out.println("Usuário: "); String ususario = in.next();
		 * System.out.println("Senha: "); String senha = in.next(); if (usuario &&
		 * string) {
		 * 
		 * } else { logado = true; Tlogin = false; Tprincipal=true; } }//fim do login ou
		 * cadastro
		 * 
		 * while (Tprincipal) { System.out.println("Informe o que deseja fazer:");
		 * System.out.println("1 - Loja de jogos");
		 * System.out.println("2 - Nossos grupos");
		 * 
		 * int valor = in.nextInt();
		 * 
		 * }
		 * 
		 * }
		 */

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
				} else if (op == 1) {
					System.out.println("LOGIN \n");
					System.out.println("Digite seu usuário:");
					String usuario = in.nextLine();
					System.out.println("Digite sua senha:");
					String senha = in.nextLine();
					// se conseguir logar, logado=true
					logado = true;
					Tprincipal = true;
					System.out.println("Bem vindo, user.");
					// Testar se usuario e senha batem, senão, jogar exceção
				} else {
					// Jogar exceção de Entrada Invalida
				}
			}
			
			while (logado) {
				while (Tprincipal) {
					System.out.println("O que deseja fazer?");
					System.out.println("1 - Acessar a loja");
					System.out.println("2 - Acessar a comunidade");
					System.out.println("3 - Acessar seu perfil");
					System.out.println("0 - Deslogar");
					op = in.nextInt();
					in.nextLine();
					if (op == 0) {
						logado = false;
						Tprincipal = false;
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
						//Joga exceção de Entrada Invalida
					}
				}

				while (Tloja) {
					// Imprimir todos os jogos disponíveis
					// Se não tiver jogos, apenas exibir Não há jogos disponíveis

				}

				while (Tgrupo) {
					// Imprimir a lista de grupos disponíveis
					// Se não tiver grupos, apenas exibir Não há grupos disponiveis
				}

				while (Tperfil) {

				}
			}

		}

	}

}
