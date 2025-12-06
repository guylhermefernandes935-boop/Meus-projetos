package escola;

public abstract class Pessoa {
	
	private String nome;
	private int anoNacimento;
	private String endereco;
	private String telefone;
	private String email;
	private char sexo;
	
	public Pessoa(String nome, int anoNacimento, String endereco, String telefone, String email,char sexo){
		this.nome = nome;
		this.anoNacimento = anoNacimento;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.sexo = sexo;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public int getAnoNacimento() {
		return anoNacimento;
	}
	public void setAnoNacimento(int anoNacimento) {
		this.anoNacimento = anoNacimento;
	}
	

	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	

	public void exibirInformacoes() {
		System.out.println("Informacoes sobre ****: ");
		System.out.println("Nome: "+getNome());
		System.out.println("Ano de nascimento: "+getAnoNacimento());
		System.out.println("Endereco: "+getEndereco());
		System.out.println("Telefone: "+getTelefone());
		System.out.println("Email: "+getEmail());
		System.out.println("Sexo: "+getSexo());




		
	}


}
