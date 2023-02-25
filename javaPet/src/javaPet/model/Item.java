package javaPet.model;

public class Item {
	
	private int iD;
	private String nomeDoproduto;
	private int quantidade;
	private double peso;
	private String tipo;
	public Item(int iD, String nomeDoproduto, int quantidade, double peso, String tipo) {
		this.iD = iD;
		this.nomeDoproduto = nomeDoproduto;
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
	public String getNomeDoproduto() {
		return nomeDoproduto;
	}
	public void setNomeDoproduto(String nomeDoproduto) {
		this.nomeDoproduto = nomeDoproduto;
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
		
		System.out.println(" Item ID " + this.iD);
		System.out.println(" Nomde do Produto " + this.nomeDoproduto);
		System.out.println(" Quantidade " + this.quantidade);
		System.out.println(" Item ID " + this.iD);
		System.out.println(" Item ID " + this.iD);
		
	}
	
	
	
	
	
}
