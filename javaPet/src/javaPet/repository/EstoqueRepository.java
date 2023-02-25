package javaPet.repository;

import javaPet.model.Animal;
import javaPet.model.Item;

public interface EstoqueRepository {
	
	public void cadastrar(Item item);
	public void listar();
	public void buscar(int iD);
	public void atualizar(Item item);
	public void apagar(int iD);
	
	

}
