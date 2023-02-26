package javaPet;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javaPet.controller.JavaPetController;
import javaPet.model.Cachorro;
import javaPet.model.Gato;
import javaPet.model.Item;
import javaPet.controller.EstoqueController;

public class Menu {

	static int vez = 1;
	static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		JavaPetController animais = new JavaPetController();

		int id, sexo, opcao = 1, porte, tipo = 1, felv, fiv, trocaDoacao;
		double idade, peso;
		String nome, raca;
		boolean aptoDoacao, loop = false;

		animais.cadastrar(new Cachorro("Gibson", animais.gerarID(), "Poodle", 8, 7, "Macho", true, animais.porteCachorro(1)));
		animais.cadastrar(new Gato("Mel", animais.gerarID(), "SRD", 3, 4.3, "Femea", true, true, false));
		animais.cadastrar(new Cachorro("schwarzenegger", animais.gerarID(), "Dalmata", 5, 15, "Macho", false,animais.porteCachorro(3)));
		animais.cadastrar(new Gato("SnowBell", animais.gerarID(), "Persa", 9, 12.3, "Macho", true, false, false));

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
			System.out.println("         *        2 - Listar todos os animais                  *");
			System.out.println("         *        3 - Buscar animal por ID                     *");
			System.out.println("         *        4 - Atualizar Dados do Animal                *");
			System.out.println("         *        5 - Apagar Cadastro do Animal                *");
			System.out.println("         *        6 - Acessar o menu de Estoque                *");
			System.out.println("         *        0 - Sair                                     *");
			System.out.println("         *******************************************************\n\n");
			System.out.println("Informe a opção desejada:");
			opcao = leia.nextInt();
			System.out.println("");

			if (opcao == 0) {
				System.out.println("\nPrograma Finalizado.");
				System.out.println("");
				System.out.println("         Instituto Java Pet");
				System.out.println("Tenha a classe de adotar com a gente!");
				leia.close();
				System.exit(0);
			}

			switch (opcao) {

			// ***************
			// Cadastro
			// ***************
			case 1:
				System.out.println("Cadastrar novo animal:");
				System.out.println("");


				try {

					System.out.println("O que deseja cadastrar?");
					System.out.println("Informe a opção desejada.");
					System.out.println("1 - Gato");
					System.out.println("2 - Cachorro");
					tipo = leia.nextInt();
					
					if(tipo != 1 && tipo != 2) {
						System.out.println("Opção inválida.");
						System.out.println("Operação cancelada.");
						keyPress();
						break;
					}

					System.out.println("Insira o nome do animal:");
					leia.skip("\\R?");
					nome = leia.nextLine();

					System.out.println("Insira a raça:");
					leia.skip("\\R?");
					raca = leia.nextLine();

					System.out.println("Insira a idade do animal (em anos):");
					idade = leia.nextDouble();

					System.out.println("Digite um número para indicar o sexo do animal:");
					System.out.println("1 - Fêmea");
					System.out.println("2 - Macho");
					sexo = leia.nextInt();

					System.out.println("Insira o peso do animal (em kg):");
					peso = leia.nextDouble();
					aptoDoacao = false;

					switch (tipo) {
					case 1:
						System.out.println("\nO gato é positivo para FeLV?");
						System.out.println("Digite o número referente à opção:");
						System.out.println("1 - Sim");
						System.out.println("2 - Não");
						felv = leia.nextInt();
						
						System.out.println("\nO gato é positivo para FIV?");
						System.out.println("Digite o número referente à opção:");
						System.out.println("1 - Sim");
						System.out.println("2 - Não");
						fiv = leia.nextInt();

						animais.cadastrar(new Gato(nome, animais.gerarID(), raca, idade, peso,
								animais.sexoAnimal(sexo), aptoDoacao, animais.simOuNao(felv), animais.simOuNao(fiv)));
						System.out.println("Pet Adicionado com sucesso!");
						break;
					case 2:
						System.out.println("Qual o porte do cachorro?");
						System.out.println("Insira a opção desejada:");
						System.out.println("1. Pequeno");
						System.out.println("2. Médio");
						System.out.println("3. Grande");
						porte = leia.nextInt();

						animais.cadastrar(new Cachorro(nome, animais.gerarID(), raca, idade, peso,
								animais.sexoAnimal(sexo), aptoDoacao, animais.porteCachorro(porte)));
						System.out.println("Pet Adicionado com sucesso!");
						break;
					}
				} catch (InputMismatchException e) {
					System.out.println("\nATENÇÃO:");
					System.out.println("Erro de entrada de dados: " + e);
					System.out.println("Operação cancelada.");
					leia.nextLine();
				}

				keyPress();
				break;

			// ***************
			// Listar animais
			// ***************
			case 2:
				System.out.println("Listar todos animais:");

				animais.listar();

				keyPress();
				break;

			// ***************
			// Buscar animal
			// ***************
			case 3:
				System.out.println("Buscar animal por ID.");
				
				try {
					System.out.println("Digite o ID desejado: ");
					id = leia.nextInt();
	
					animais.buscar(id);
				} catch (InputMismatchException e) {
					System.out.println("\nATENÇÃO:");
					System.out.println("Erro de entrada de dados: " + e);
					System.out.println("Operação cancelada.");
					leia.nextLine();
				}

				keyPress();
				break;

			// ***************
			// Atualizar
			// ***************
			case 4:
				System.out.println("Atualizar dados do animal:");


				try {
					System.out.println("\nDigite o ID que deseja alterar: ");
					id = leia.nextInt();

					var animal = animais.buscarNaCollection(id);
					if (animal == null) {
						System.out.println("ID não cadastrado na nossa base de dados.");

						keyPress();
						break;
					}

					animal.visualizar();
					
					System.out.println("");
					System.out.println("É um gato ou cachorro?");
					System.out.println("Informe a opção desejada.");
					System.out.println("1. Gato");
					System.out.println("2. Cachorro");

					tipo = leia.nextInt();

					if(tipo != 1 && tipo != 2) {
						System.out.println("Opção inválida.");
						System.out.println("Operação cancelada.");
						keyPress();
						break;
					}
					
					System.out.println("Insira o nome do animal:");
					leia.skip("\\R?");
					nome = leia.nextLine();
					
					System.out.println("Insira a raça:");
					leia.skip("\\R?");
					raca = leia.nextLine();
					
					System.out.println("Insira a idade do animal (em anos):");
					idade = leia.nextDouble();
					
					System.out.println("Digite um número para indicar o sexo do animal:");
					System.out.println("1 - Fêmea");
					System.out.println("2 - Macho");
					sexo = leia.nextInt();

					System.out.println("Insira o peso do animal:");
					peso = leia.nextDouble();

					aptoDoacao = animal.isAptoDoacao();
					if(aptoDoacao == true) {
						System.out.println("O animal está definido como apto a ser adotado. Deseja alterar?");
						System.out.println("Digite o número referente à opção:");
						System.out.println("1 - Sim");
						System.out.println("2 - Não");
						trocaDoacao = leia.nextInt();
						
						if(trocaDoacao == 1)
							aptoDoacao = false;
					}
					else {
						System.out.println("O animal está definido como NÃO apto a ser adotado. Deseja alterar?");
						System.out.println("Digite o número referente à opção:");
						System.out.println("1 - Sim");
						System.out.println("2 - Não");
						trocaDoacao = leia.nextInt();
						
						if(trocaDoacao == 1)
							aptoDoacao = true;
					}
					
					switch (tipo) {
					case 1:
						System.out.println("\nO gato é positivo para FeLV?");
						System.out.println("Digite o número referente à opção:");
						System.out.println("1 - Sim");
						System.out.println("2 - Não");
						felv = leia.nextInt();
						
						System.out.println("\nO gato é positivo para FIV?");
						System.out.println("Digite o número referente à opção:");
						System.out.println("1 - Sim");
						System.out.println("2 - Não");
						fiv = leia.nextInt();
						
						animais.atualizar(new Gato(nome, animal.getID(), raca, idade, peso, animais.sexoAnimal(sexo), 
								aptoDoacao, animais.simOuNao(felv), animais.simOuNao(fiv)));
						System.out.println("Animal atualizado com sucesso.");
						break;

					case 2:
						System.out.println("Qual o porte do cachorro?");
						System.out.println("Digite o número referente à opção:");
						System.out.println("1 - Pequeno");
						System.out.println("2 - Médio");
						System.out.println("3 - Grande");
						porte = leia.nextInt();

						animais.atualizar(new Cachorro(nome, animal.getID(), raca, idade, peso, animais.sexoAnimal(sexo), 
								aptoDoacao, animais.porteCachorro(porte)));
						System.out.println("Animal atualizado com sucesso.");
						break;
					}
				} catch (InputMismatchException e) {
					System.out.println("\nATENÇÃO:");
					System.out.println("Erro de entrada de dados: " + e);
					System.out.println("Operação cancelada.");
					leia.nextLine();
				}
				
				keyPress();
				break;

			// ***************
			// Apagar
			// ***************
			case 5:
				System.out.println("Apagar cadastro de um animal.");

				try {
					System.out.println("Digite o ID: ");
					id = leia.nextInt();
	
					animais.apagar(id);
				} catch (InputMismatchException e) {
					System.out.println("\nATENÇÃO:");
					System.out.println("Erro de entrada de dados: " + e);
					System.out.println("Operação cancelada.");
					leia.nextLine();
				}
				
				keyPress();
				break;

			case 6:
				System.out.println("Estoque:");

				estoqueMenu();

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
			System.out.println("\n\nPressione Enter para Continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}
	
	// *****************************
	// Estoque
	// *****************************
	
	static public void estoqueMenu() {

		EstoqueController itens = new EstoqueController();
		
		if (vez == 1) {
			itens.cadastrar(new Item(itens.gerarID(), "Ração Magnus Premium Carne Para Cães Adultos", 30, 5, itens.tipoItem(1)));
			itens.cadastrar(new Item(itens.gerarID(), "Ração Bocão Premium Frango Para Cães Adultos", 10, 1, itens.tipoItem(1)));
			itens.cadastrar(new Item(itens.gerarID(), "Ração Foster Premium Carne Para Cães Filhotes", 18, 2, itens.tipoItem(1)));
			itens.cadastrar(new Item(itens.gerarID(), "Ração Magnus Frango Para Cães Filhotes", 13, 2, itens.tipoItem(1)));

			itens.cadastrar(new Item(itens.gerarID(), "Ração Magnus Frango Para Gatos Filhotes", 13, 2, itens.tipoItem(1)));
			itens.cadastrar(new Item(itens.gerarID(), "Ração Foster Carne Para Gatos Adultos", 13, 2, itens.tipoItem(1)));

			itens.cadastrar(new Item(itens.gerarID(), "Granulado Sanitario Para Gatos PipiCat", 40, 12, itens.tipoItem(2)));
			itens.cadastrar(new Item(itens.gerarID(), "Areia Higienica Kets", 35, 10, itens.tipoItem(2)));

			itens.cadastrar(new Item(itens.gerarID(), "Natu Verm - 4 Comprimidos", 9, 0, itens.tipoItem(3)));
			itens.cadastrar(new Item(itens.gerarID(), "Sarniram - 30 ml", 15, 0, itens.tipoItem(3)));
			vez += 1;
		}

		boolean loop = false;
		String nome;
		int id, quantidade, tipo, opcao = 1;
		double peso;

		do {
			System.out.println("         *******************************************************");
			System.out.println("         *                                                     *");
			System.out.println("         *                  ESTOQUE JAVA PET                   *");
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
			
			if (opcao == 0) {
				break;
			}
			
			switch (opcao) {

			// ***************
			// Cadastro
			// ***************
			case 1:
				System.out.println("Cadastrar novo item.");
				System.out.println("");

				try {
					System.out.println("Insira o nome do item: ");
					leia.skip("\\R?");
					nome = leia.nextLine();

					System.out.println("Digite o número referente ao tipo de item: ");
					System.out.println("1 - Alimento");
					System.out.println("2 - Produto de higiene");
					System.out.println("3 - Medicamento");
					tipo = leia.nextInt();

					if(tipo == 3)
						peso = 0;
					else {
						System.out.println("Insira o peso do produto (em kg):");
						peso = leia.nextDouble();
					}

					System.out.println("Insira a quantidade:");
					quantidade = leia.nextInt();

					itens.cadastrar(new Item( itens.gerarID(), nome, quantidade, peso, itens.tipoItem(tipo) ));
					System.out.println("Item Adicionado");
					
				} catch (InputMismatchException e) {
					System.out.println("\nATENÇÃO:");
					System.out.println("Erro de entrada de dados: " + e);
					System.out.println("Operação cancelada.");
					leia.nextLine();

				}

				keyPress();
				break;

			// ***************				
			// Listar itens
			// ***************
			case 2:
				System.out.println("Listar todos os produtos:");

				itens.listar();

				keyPress();
				break;

			// ***************
			// Buscar item
			// ***************
			case 3:
				System.out.println("Buscar item por ID.");

				try {
					System.out.println("Digite o ID desejado: ");
					id = leia.nextInt();
					
					itens.buscar(id);
				} catch (InputMismatchException e) {
					System.out.println("\nATENÇÃO:");
					System.out.println("Erro de entrada de dados: " + e);
					System.out.println("Operação cancelada.");
					leia.nextLine();
				}

				keyPress();
				break;

			// ***************
			// Atualizar
			// ***************
			case 4:
				System.out.println("Atualizar item.");

				try {
					System.out.println("Digite o ID do item que deseja alterar: ");
					id = leia.nextInt();

					var item = itens.buscarNaCollection(id);
					if (item == null) {
						System.out.println("ID não cadastrado na nossa base de dados.");

						keyPress();
						break;
					}
					
					item.visualizar();

					System.out.println("");
					System.out.println("Insira o nome do item:");
					leia.skip("\\R?");
					nome = leia.nextLine();

					System.out.println("Digite o número referente ao tipo de item: ");
					System.out.println("1 - Alimento");
					System.out.println("2 - Produto de higiene");
					System.out.println("3 - Medicamento");
					tipo = leia.nextInt();

					if(tipo == 3)
						peso = 0;
					else {
						System.out.println("Insira o peso do produto (em kg):");
						peso = leia.nextDouble();
					}

					System.out.println("Insira a quantidade:");
					quantidade = leia.nextInt();

					itens.atualizar(new Item(item.getiD(), nome, quantidade, peso, itens.tipoItem(tipo)));

				} catch (InputMismatchException e) {
					System.out.println("\nATENÇÃO:");
					System.out.println("Erro de entrada de dados: " + e);
					System.out.println("Operação cancelada.");
					leia.nextLine();
				}

				keyPress();
				break;
				
			// ***************
			// Apagar
			// ***************
			case 5:
				System.out.println("Apagar item.");
				try {
					System.out.println("Digite o ID: ");
					id = leia.nextInt();
	
					itens.apagar(id);
				} catch (InputMismatchException e) {
					System.out.println("\nATENÇÃO:");
					System.out.println("Erro de entrada de dados: " + e);
					System.out.println("Operação cancelada.");
					leia.nextLine();
				}

				keyPress();
				break;
				
			default:
				System.out.println("Opção Inválida!");

				keyPress();
				break;
			}

		} while (opcao != 0);
	}
}
