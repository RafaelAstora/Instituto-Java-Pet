package javaPet.controller;

import java.util.ArrayList;
import java.util.Scanner;

import javaPet.model.Item;
import javaPet.repository.EstoqueRepository;

public class EstoqueController implements EstoqueRepository {

	static Scanner leia = new Scanner(System.in);

	ArrayList<Item> itens = new ArrayList<Item>();

	@Override
	public void cadastrar(Item item) {
		itens.add(item);
		System.out.println("Item Adicionado");

	}

	@Override
	public void listar() {
		for (var item : itens) {

			item.visualizar();

		}
	}

	@Override
	public void buscar(int iD) {

		var item = buscarNaCollection(iD);

		if (item != null)
			item.visualizar();
		else
			System.out.println("O item " + iD + " não foi localizado.");
	}

	@Override
	public void atualizar(Item item) {
		var buscarItem = buscarNaCollection(item.getiD());

		itens.set(itens.indexOf(buscarItem), item);
		System.out.println("O item foi atualizado!");

	}

	@Override
	public void apagar(int iD) {

		int opcao;

		var item = buscarNaCollection(iD);

		if (item != null) {

			System.out.println("Tem certeza que deseja excluir?\nDigite 1 para Sim e 2 para Não:");
			opcao = leia.nextInt();

			if (opcao == 1) {

				if (itens.remove(item) == true) {
					System.out.println("O item do ID " + iD + " foi excluído.");

				} else
					System.out.println("Não foi encontrado o ID " + iD + " do item informado na nossa base de dados.");

			} else {
				System.out.println("Exclusão cancelada!!");
			}
		}

	}

	public Item buscarNaCollection(int id) {
		for (var item : itens) {
			if (item.getiD() == id)
				return item;
		}
		return null;
	}
	
	public String tipoItem(int valor) {
		switch (valor) {
		case 1:
			return "Alimento";
		case 2:
			return "Higiene";
		case 3:
			return "Medicamento";
		}
		return "Erro";
	}
	public int gerarID() {
		return itens.size() + 1;
	}

}
