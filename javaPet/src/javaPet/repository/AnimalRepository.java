package javaPet.repository;

import javaPet.model.Animal;

public interface AnimalRepository {

	public void cadastrar(Animal animal);
	public void listar();
	public void buscar(int id);
	public void atualizar(Animal animal);
	public void apagar(int id);

}


