package javaPet.model;

public class Item {

	private int iD;
	private String nomeProduto;
	private int quantidade;
	private double peso;
	private String tipo;

	public Item(int iD, String nomeProduto, int quantidade, double peso, String tipo) {
		this.iD = iD;
		this.nomeProduto = nomeProduto;
		this.quantidade = quantidade;
		this.peso = peso;
		this.tipo = tipo;
	}

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void visualizar() {

		System.out.println("");
		System.out.println(this.nomeProduto);
		for(int i = 0; i < this.nomeProduto.length(); i++)
			System.out.printf("*");
		
		System.out.println("\nID: " + this.iD);
		System.out.println("Tipo: " + this.tipo);
		System.out.println("Quantidade: x" + this.quantidade);
		if(this.peso != 0) {
			System.out.println("Peso da unidade: " + this.peso + " kg");
			System.out.println("Quantidade total: "  + (this.peso * this.quantidade) + " kg");
		}
		System.out.println("");
	}

}
