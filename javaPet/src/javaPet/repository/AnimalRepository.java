package javaPet.repository;

import javaPet.model.Animal;

public interface AnimalRepository {

	public void cadastrar(Animal animal);
	public void listar();
	public void buscar();
	public void atualizar();
	public void apagar();

}
