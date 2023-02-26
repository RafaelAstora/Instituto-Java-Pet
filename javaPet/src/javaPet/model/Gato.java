package javaPet.model;

public class Gato extends Animal {

	private boolean felv; // leucemia felina
	private boolean fiv; // aids felina

	public Gato(String nome, int iD, String raca, double idade, double peso, String sexo, boolean aptoDoacao,
			boolean felv, boolean fiv) {
		super(nome, iD, raca, idade, peso, sexo, aptoDoacao);
		this.felv = felv;
		this.fiv = fiv;
	}

	public boolean isFelv() {
		return felv;
	}

	public void setFelv(boolean felv) {
		this.felv = felv;
	}

	public boolean isFiv() {
		return fiv;
	}

	public void setFiv(boolean fiv) {
		this.fiv = fiv;
	}

	public void visualizar() {
		System.out.println("");
		System.out.println("***********************************");
		System.out.println("              G A T O              ");
		System.out.println("***********************************");
		super.visualizar();
		
		if(this.felv == false && this.fiv == false)
			System.out.println("FIV e FeLV negativo.");
		else if(this.felv == true && this.fiv == true)
			System.out.println("É FIV e FeLV positivo.");
		else if(this.felv == true)
			System.out.println("É FeLV positivo.");
		else if(this.fiv == true)
			System.out.println("È FIV positivo.");
		
		System.out.println("");
	}
}
