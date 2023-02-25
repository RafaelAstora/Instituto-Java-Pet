package javaPet;

import java.io.IOException;
import java.util.Scanner;

import javaPet.controller.JavaPetController;
import javaPet.model.Cachorro;
import javaPet.model.Gato;
import javaPet.model.Item;
import javaPet.controller.EstoqueController;

public class Menu {

	static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		JavaPetController animais = new JavaPetController();

		int id, sexo;
		int opcao = 1;
		int tipo, porte;
		double idade, peso;
		String nome, raca;
		boolean aptoDoacao;
		boolean felv, fiv;

		animais.cadastrar(
				new Cachorro("Gibson", animais.gerarID(), "Poodle", 8, 7, "Macho", true, animais.porteCachorro(1)));
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
				try {

				} catch (Exception e) {

					
					
				}
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
				System.out.println("1 - Para femea");
				System.out.println("2 - Para macho");
				sexo = leia.nextInt();

				System.out.println("Insira o peso do animal (kg):    ");
				peso = leia.nextDouble();
				aptoDoacao = false;

				switch (tipo) {
				case 1:
					System.out.println("Ele é positivo para felv?");
					felv = leia.nextBoolean();
					System.out.println("Ele é positivo para fiv?");
					fiv = leia.nextBoolean();

					animais.cadastrar(new Gato(nome, animais.gerarID(), raca, idade, peso, animais.sexoAnimal(sexo),
							aptoDoacao, fiv, felv));
					break;
				case 2:
					System.out.println("Qual o porte do cachorro?");
					System.out.println("Insira a opção desejada:");
					System.out.println("1. Pequeno");
					System.out.println("2. Médio");
					System.out.println("3. Grande");
					porte = leia.nextInt();

					animais.cadastrar(new Cachorro(nome, animais.gerarID(), raca, idade, peso, animais.sexoAnimal(sexo),
							aptoDoacao, animais.porteCachorro(porte)));
					break;

				}
				System.out.println("Pet Adicionado");
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
				if (animal == null) {
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
				sexo = leia.nextInt();
				System.out.println("Insira o peso do animal:    ");
				peso = leia.nextDouble();

				aptoDoacao = animal.isAptoDoacao();

				switch (tipo) {
				case 1:
					System.out.println("Ele é positivo para felv?");
					felv = leia.nextBoolean();
					System.out.println("Ele é positivo para fiv?");
					fiv = leia.nextBoolean();

					animais.atualizar(new Gato(nome, animal.getID(), raca, idade, peso, animais.sexoAnimal(sexo),
							aptoDoacao, fiv, felv));
					break;

				case 2:
					System.out.println("Qual o porte do cachorro?");
					System.out.println("Insira a opção desejada:");
					System.out.println("1. Pequeno");
					System.out.println("2. Médio");
					System.out.println("3. Grande");
					porte = leia.nextInt();

					animais.atualizar(new Cachorro(nome, animal.getID(), raca, idade, peso, animais.sexoAnimal(sexo),
							aptoDoacao, animais.porteCachorro(porte)));
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

				estoqueMenu();

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

	static public void estoqueMenu() {

		EstoqueController itens = new EstoqueController();

		String nome;
		int id;
		int quantidade;
		double peso;
		int tipo;

		int opcao = 1;

		do {

			System.out.println("         *******************************************************");
			System.out.println("         *                                                     *");
			System.out.println("         *                                                     *");
			System.out.println("         *                  ESTOQUE JAVA PET                   *");
			System.out.println("         *                                                     *");
			System.out.println("         *                                                     *");
			System.out.println("         *******************************************************");
			System.out.println("         *        1 - Cadastrar novo item                      *");
			System.out.println("         *        2 - Listar todos os itens                    *");
			System.out.println("         *        3 - Buscar item por ID                       *");
			System.out.println("         *        4 - Atualizar item                           *");
			System.out.println("         *        5 - Apagar item                              *");
			System.out.println("         *        0 - Voltar                                   *");
			System.out.println("         *******************************************************\n\n");
			System.out.println("Informe a opção desejada:");

			opcao = leia.nextInt();

			switch (opcao) {

			// Cadastro
			case 1:
				System.out.println("Cadastrar novo item:");
				System.out.println("");

				System.out.println("Insira o nome do item:    ");
				leia.skip("\\R?");
				nome = leia.nextLine();

				System.out.println("Insira o tipo do item:   ");
				System.out.println("1 - Para alimento");
				System.out.println("2 - Para produto de higiene");
				System.out.println("3 - Para medicamento ");
				leia.skip("\\R?");
				tipo = leia.nextInt();

				System.out.println("Insira o peso do produto (kg):");
				peso = leia.nextDouble();

				System.out.println("Insira a quantidade:");
				quantidade = leia.nextInt();

				itens.cadastrar(new Item(itens.gerarID(), nome, quantidade, peso, itens.tipoItem(tipo)));

				keyPress();
				break;

			// Listar itens
			case 2:
				System.out.println("Listar todos os produtos:");

				itens.listar();

				keyPress();
				break;

			// Buscar item
			case 3:
				System.out.println("Buscar item por ID:");

				System.out.println("Digite o ID desejado: ");
				id = leia.nextInt();

				itens.buscar(id);

				keyPress();
				break;

			// Atualizar
			case 4:
				System.out.println("Atualizar itens:");

				System.out.println("Digite o ID do item que deseja alterar: ");
				id = leia.nextInt();

				var item = itens.buscarNaCollection(id);
				if (item == null) {
					System.out.println("ID não cadastrado na nossa base de dados.");

					keyPress();
					break;
				}

				System.out.println("");
				System.out.println("Insira o nome do item:    ");
				leia.skip("\\R?");
				nome = leia.nextLine();

				System.out.println("Insira o tipo do item:   ");
				System.out.println("1 - Para alimento");
				System.out.println("2 - Para produto de higiene");
				System.out.println("3 - Para medicamento ");
				leia.skip("\\R?");
				tipo = leia.nextInt();

				System.out.println("Insira o peso do produto (kg):");
				peso = leia.nextDouble();

				System.out.println("Insira a quantidade:");
				quantidade = leia.nextInt();

				itens.atualizar(new Item(item.getiD(), nome, quantidade, peso, itens.tipoItem(tipo)));

				keyPress();
				break;

			// Apagar
			case 5:
				System.out.println("Apagar item.");

				System.out.println("Digite o ID: ");
				id = leia.nextInt();

				itens.apagar(id);

				keyPress();
				break;
			}

		} while (opcao != 0);

	}
}
