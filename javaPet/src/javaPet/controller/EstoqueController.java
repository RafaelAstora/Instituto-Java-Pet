package javaPet.controller;

import java.util.ArrayList;

import javaPet.model.Animal;
import javaPet.model.Item;
import javaPet.repository.EstoqueRepository;

public class EstoqueController implements EstoqueRepository {
	

	ArrayList<Item> itens = new ArrayList<Item>();
	
	

	@Override
	public void cadastrar(Item item) {
		itens.add(item);
		System.out.println("Item Adicionado");
		
		
	}

	@Override
	public void listar() {
		
		
		
		
	}

	@Override
	public void buscar(int iD) {
		
		
	}

	@Override
	public void atualizar(Item item) {
		
		
	}

	@Override
	public void apagar(int iD) {
		
		
	}
	
	

}
