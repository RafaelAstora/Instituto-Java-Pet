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
			animal.visualizar();
		}
		
	}

	@Override
	public void buscar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void apagar() {
		// TODO Auto-generated method stub
		
	}

	

}
