package javaPet.controller;

import java.util.ArrayList;
import java.util.Scanner;

import javaPet.model.Animal;
import javaPet.repository.AnimalRepository;

public class JavaPetController implements AnimalRepository {

	ArrayList<Animal> animais = new ArrayList<Animal>();
	
	static Scanner leia = new Scanner(System.in);

	@Override
	public void cadastrar(Animal animal) {
		animais.add(animal);
	}

	@Override
	public void listar() {
		for (var animal : animais)
			animal.visualizar();
	}

	@Override
	public void buscar(int id) {

		var animal = buscarNaCollection(id);

		if (animal != null)
			animal.visualizar();
		else
			System.out.println("O animal de ID  " + id + " não foi localizado.");
	}

	@Override
	public void atualizar(Animal animal) {

		var buscaAnimal = buscarNaCollection(animal.getID());

		animais.set(animais.indexOf(buscaAnimal), animal);
		System.out.println("O animal no ID " + animal.getID() + " foi atualizado.");
	}

	@Override
	public void apagar(int id) {
		
		int opcao;
		
		var animal = buscarNaCollection(id);

		if (animal != null) {
			System.out.println("Tem certeza que deseja excluir?");
			System.out.println("Digite o número para a opção desejada: ");
			System.out.println("1 - Sim");
			System.out.println("2 - Não");
			opcao = leia.nextInt();

			if (opcao == 1) {
				if (animais.remove(animal) == true)
					System.out.println("O cadastro do animal com o ID número " + id + " foi excluído.");
			} else
				System.out.println("Exclusão cancelada.");
			
		} else
			System.out.println("Não foi encontrado um animal cadastrado com o ID " + id + ".");
	}

	// **********************
	// Métodos complementares
	// **********************
	public int gerarID() {
		return animais.size() + 1;
	}

	public String porteCachorro(int valor) {
		switch (valor) {
		case 1:
			return "Pequeno";
		case 2:
			return "Médio";
		case 3:
			return "Grande";
		}
		return "Erro";
	}

	public String sexoAnimal(int valor) {
		
		switch (valor) {
		case 1:
			return "Femea";
		case 2:
			return "Macho";

		}
		return "Erro";
	}
	
	public Animal buscarNaCollection(int id) {
		for (var animal : animais) {
			if (animal.getID() == id)
				return animal;
		}
		return null;
	}

}
