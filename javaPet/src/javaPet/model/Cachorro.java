package javaPet.model;

public class Cachorro extends Animal {
	
	private String porte;

	public Cachorro(String nome, int iD, String raca, double idade, double peso, String sexo, boolean aptoDoacao,
			String porte) {
		super(nome, iD, raca, idade, peso, sexo, aptoDoacao);
		this.porte = porte;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}
	
	public void visualizar(){
		// TODO Atualizar para definir como Gato/Cachorro
		super.visualizar();
		System.out.println("Porte: " + porte);
	}
}
