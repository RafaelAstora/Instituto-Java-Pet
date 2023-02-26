package javaPet.model;

public  abstract class Animal  {
	
	private String nome;
	private int ID;
	private String raca;
	private double idade;
	private double peso;
	private String sexo;
	private boolean aptoDoacao;
	
	public Animal(String nome, int iD, String raca, double idade, double peso, String sexo, boolean aptoDoacao) {
		this.nome = nome;
		this.ID = iD;
		this.raca = raca;
		this.idade = idade;
		this.peso = peso;
		this.sexo = sexo;
		this.aptoDoacao = aptoDoacao;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public double getIdade() {
		return idade;
	}
	public void setIdade(double idade) {
		this.idade = idade;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public boolean isAptoDoacao() {
		return aptoDoacao;
	}
	public void setAptoDoacao(boolean aptoDoacao) {
		this.aptoDoacao = aptoDoacao;
	}
	
	public void visualizar(){
		
		System.out.println("ID: " + this.ID);
		System.out.println("Nome: " + this.nome);
		System.out.println("Sexo: " + this.sexo);
		System.out.println("Raça: " + this.raca);
		
		if(this.idade >= 2)
			System.out.println("Idade: " + this.idade + " anos");
		else
			System.out.println("Idade: " + this.idade + " ano");
		
		System.out.println("Peso: " + this.peso + " kg");
		
		if(this.aptoDoacao == true)
			System.out.println("Disponível para adoção? Sim");
		else
			System.out.println("Disponível para adoção? Não");
	}
}