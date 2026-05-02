package escola;

public class Funcionario extends Pessoa{

	
	private String idFuncionario;
	private String cargo;
	private String departamento;
	private double salario;
	
	public Funcionario(String nome, int anoNacimento, String endereco, String telefone, String email, char sexo,
						String idFuncionario, String cargo, String departamento, double salario) {
		super(nome, anoNacimento, endereco, telefone, email, sexo);
		
		this.idFuncionario = idFuncionario;
		this.cargo = cargo;
		this.departamento = departamento;
		this.salario = salario;
		
	}

	public String getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(String idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
	@Override
	public void exibirInformacoes() {
		System.out.println("Informacoes do Funcionario: ");
		System.out.println("Nome: "+getNome());
		System.out.println("Codigo do Funcionario: "+getIdFuncionario());
		System.out.println("Cargo: "+getCargo());
		System.out.println("Departamento: "+getDepartamento());
		System.out.println("Salario: "+getSalario());
		System.out.println("Ano de nascimento: "+getAnoNacimento());
		System.out.println("Endereco: "+getEndereco());
		System.out.println("Telefone: "+getTelefone());
		System.out.println("Email: "+getEmail());
		System.out.println("Sexo: "+getSexo());
		
	}
	
	
	 
	
}
