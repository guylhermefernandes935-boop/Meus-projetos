package escola;

public class Proferssor extends Pessoa{
	
	
	private String codigoFuncionario;
	private double salario;
	private String disciplina;
	private int cargaHoraria;
	private String titulacao;
	
	public Proferssor(String nome, int anoNacimento, String endereco, String telefone, String email, char sexo,
					  String codigoFuncionario, double salario, String disciplina,int cargaHoraria,String titulacao) {
		super(nome, anoNacimento, endereco, telefone, email, sexo);
		this.codigoFuncionario = codigoFuncionario;
		this.salario = salario;
		this.disciplina = disciplina;
		this.cargaHoraria = cargaHoraria;
		this.titulacao = titulacao;
	}


	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}
	
	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}


	public void setCodigoFuncionario(String codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}


	public double getSalario() {
		return salario;
	}


	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
	@Override
	public void exibirInformacoes() {
		System.out.println("Informacoes do Proferssor: ");
		System.out.println("Nome: "+getNome());
		System.out.println("ID do Funcionario: "+getCodigoFuncionario());
		System.out.println("Disciplina: "+getDisciplina());
		System.out.println("CargaHoraria: "+getCargaHoraria()+"h");
		System.out.println("Titulação: "+getTitulacao());
		System.out.printf("Salario: R$%.2f%n",getSalario());
		System.out.println("Ano de nascimento: "+getAnoNacimento());
		System.out.println("Endereco: "+getEndereco());
		System.out.println("Telefone: "+getTelefone());
		System.out.println("Email: "+getEmail());
		System.out.println("Sexo: "+getSexo());
		
	}


}
