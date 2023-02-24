package javaPet;

import java.io.IOException;
import java.util.Scanner;

import javaPet.controller.JavaPetController;
import javaPet.model.Cachorro;
import javaPet.model.Gato;

public class Menu {


	public static void main(String[] args) {

		JavaPetController animais = new JavaPetController();
	
		Scanner leia = new Scanner(System.in);
		int id;
		int opcao = 1;
		int tipo, porte;
		double idade, peso;
		String nome, raca, sexo;
		boolean aptoDoacao;
		boolean felv, fiv;

		
		animais.cadastrar(new Cachorro("Gibson", animais.gerarID(), "Poodle", 8, 7, "Macho", true, animais.porteCachorro(1) ));
		animais.cadastrar(new Gato("Mel", animais.gerarID(), "SRD", 3, 4.3, "Femea", true, true, false));

		do {
			System.out.println("                                                     ,-.___,-.   \r\n"
					+ "                                                     \\_/_ _\\_/\r\n"
					+ "            /\\_/\\                                      )O_O(\r\n"
					+ "           ( o.o )                                    { (_) }\r\n"
					+ "            > ^ <                                      `-^-' ");
			System.out.println("         *******************************************************");
			System.out.println("         *                                                     *");
			System.out.println("         *                                                     *");
			System.out.println("         *                 INSTITUTO JAVA PET                  *");
			System.out.println("         *                                                     *");
			System.out.println("         *                                                     *");
			System.out.println("         *******************************************************");
			System.out.println("         *        1 - Cadastrar novo animal                    *");
			System.out.println("         *        2 - Listar todos animais                     *");
			System.out.println("         *        3 - Buscar animal por ID                     *");
			System.out.println("         *        4 - Atualizar Dados do Animal                *");
			System.out.println("         *        5 - Apagar Cadastro do Animal                *");
			System.out.println("         *        6 - Estoque                                  *");
			System.out.println("         *        0 - Sair                                     *");
			System.out.println("         *******************************************************\n\n");
			System.out.println("Informe a opção desejada:");
			opcao = leia.nextInt();

			if (opcao == 0) {
				System.out.println("\nPrograma Finalizado - Instituto Java PET");
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			
			// Cadastro
			case 1:
				System.out.println("Cadastrar novo animal:");
				System.out.println("");
				
				System.out.println("O que deseja cadastrar?");
				System.out.println("Informe a opção desejada.");
				System.out.println("1. Gato");
				System.out.println("2. Cachorro");
				tipo = leia.nextInt();
				
				System.out.println("Insira o nome do animal:    ");
				leia.skip("\\R?");
				nome = leia.nextLine();
				System.out.println("Insira a Raça:   ");
				leia.skip("\\R?");
				raca = leia.nextLine();
				System.out.println("Insira a idade do animal:   ");
				idade = leia.nextDouble();
				System.out.println("Insira o sexo do animal:    ");
				leia.skip("\\R?");
				sexo = leia.nextLine();
				System.out.println("Insira o peso do animal:    ");
				peso = leia.nextDouble();
				aptoDoacao = false;
				
				switch (tipo) {
				case 1:
					System.out.println("Ele é positivo para felv?");
					felv = leia.nextBoolean();
					System.out.println("Ele é positivo para fiv?");
					fiv = leia.nextBoolean();
					
					animais.cadastrar( new Gato(nome, animais.gerarID(), raca, idade, peso, sexo, aptoDoacao, fiv,felv));

				case 2:
					System.out.println("Qual o porte do cachorro?");
					System.out.println("Insira a opção desejada:");
					System.out.println("1. Pequeno");
					System.out.println("2. Médio");
					System.out.println("3. Grande");
					porte = leia.nextInt();
					
					animais.cadastrar( new Cachorro(nome, animais.gerarID(), raca, idade, peso, sexo, aptoDoacao, animais.porteCachorro(porte) ));
				}

				keyPress();
				break;

			// Listar animais
			case 2:
				System.out.println("Listar todos animais:");
				
				animais.listar();
				
				keyPress();
				break;
				
			// Buscar animal
			case 3:
				System.out.println("Buscar animal por ID:");
				
				System.out.println("Digite o ID desejado: ");
				id = leia.nextInt();
				
				animais.buscar(id);
				
				keyPress();
				break;

			// Atualizar 
			case 4:
				System.out.println("Atualizar dados do animal:");

				System.out.println("Digite o ID que deseja alterar: ");
				id = leia.nextInt();
				
				var animal = animais.buscarNaCollection(id);
				if(animal == null) {
					System.out.println("ID não cadastrado na nossa base de dados.");
					
					keyPress();
					break;
				}
				
				System.out.println("");
				System.out.println("Gato ou cachorro?");
				System.out.println("Informe a opção desejada.");
				System.out.println("1. Gato");
				System.out.println("2. Cachorro");
				tipo = leia.nextInt();
				
				System.out.println("Insira o nome do animal:    ");
				leia.skip("\\R?");
				nome = leia.nextLine();
				System.out.println("Insira a Raça:   ");
				leia.skip("\\R?");
				raca = leia.nextLine();
				System.out.println("Insira a idade do animal:   ");
				idade = leia.nextDouble();
				System.out.println("Insira o sexo do animal:    ");
				leia.skip("\\R?");
				sexo = leia.nextLine();
				System.out.println("Insira o peso do animal:    ");
				peso = leia.nextDouble();
				
				aptoDoacao = animal.isAptoDoacao();
				

				switch (tipo) {
				case 1:
					System.out.println("Ele é positivo para felv?");
					felv = leia.nextBoolean();
					System.out.println("Ele é positivo para fiv?");
					fiv = leia.nextBoolean();
					
					animais.atualizar( new Gato(nome, animal.getID(), raca, idade, peso, sexo, aptoDoacao, fiv,felv));
					break;

				case 2:
					System.out.println("Qual o porte do cachorro?");
					System.out.println("Insira a opção desejada:");
					System.out.println("1. Pequeno");
					System.out.println("2. Médio");
					System.out.println("3. Grande");
					porte = leia.nextInt();
					
					animais.atualizar( new Cachorro(nome, animal.getID(), raca, idade, peso, sexo, aptoDoacao, animais.porteCachorro(porte) ));
					break;
				}
				
				keyPress();
				break;
				
			// Apagar
			case 5:
				System.out.println("Apagar cadastro do animal.");
				
				System.out.println("Digite o ID: ");
				id = leia.nextInt();
				
				animais.apagar(id);
				
				keyPress();
				break;

				
				
				
				
				
				
				
				
				
				
				
			case 6:
				System.out.println("Estoque:");
				
				keyPress();
				break;

			default:
				System.out.println("Opção Inválida!");
				
				keyPress();
				break;
			}

		} while (opcao != 0);

		leia.close();
	}

	public static void keyPress() { 
		try { 
			// Possível TODO: Criar classe de cores
			System.out.println("\n\nPressione Enter para Continuar...");
			System.in.read(); 
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	} 
	
	
}
