package javaPet.controller;

import java.util.ArrayList;

import javaPet.model.Animal;
import javaPet.repository.AnimalRepository;

public class JavaPetController implements AnimalRepository {

	
	ArrayList<Animal> animais = new ArrayList<Animal>();

	
	@Override
	public void cadastrar(Animal animal) {
		animais.add(animal);
		System.out.println("Pet Adicionado");
		
	}
	

	@Override
	public void listar() {
		for (var animal : animais) {
			// TODO Atualizar para definir como Gato/Cachorro
			animal.visualizar();
		}
		
	}

	@Override
	public void buscar(int id) {
		
		var animal = buscarNaCollection(id);
		
		if(animal != null)
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
		
		var animal = buscarNaCollection(id);
		
		if(animal != null) {
			// TODO Além de poder colocar aqui aqueles "Tem certeza de que deseja excluir?"
			if(animais.remove(animal) == true)
				System.out.println("O cadastro do animal de ID " + id + " foi excluído.");
		}
		else
			System.out.println("Não foi encontrado o ID " + id + " do animal informado na nossa base de dados.");
	}
	
	// Métodos complementares
	public int gerarID() {
		return animais.size() + 1;
	}
	
	public String porteCachorro(int valor) {
		switch(valor) {
		case 1:
			return "Pequeno";
		case 2:
			return "Médio";
		case 3:
			return "Grande";
		}
		return "Erro";
	}
	
	public Animal buscarNaCollection(int id) {
		for(var animal: animais) {
			if(animal.getID() == id)
				return animal;
		}
		return null;
	}

	

}
