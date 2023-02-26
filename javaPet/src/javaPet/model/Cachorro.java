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
		System.out.println("");
		System.out.println("***********************************");
		System.out.println("          C A C H O R R O          ");
		System.out.println("***********************************");
		
		super.visualizar();
		
		System.out.println("Porte: " + this.porte);
	}
}
