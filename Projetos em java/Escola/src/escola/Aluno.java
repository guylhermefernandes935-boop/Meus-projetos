package escola;

import java.util.Scanner;

public class Aluno extends Pessoa{

	
	private String matricula;
	private String curso;
	private String turma;
	protected double[] notas = new double[4];
	private double mediaFinal;
	
	public Aluno(String nome, int anoNacimento, String endereco, String telefone, String email, 
				 char sexo, String matricula, String curso,String turma) {
		super(nome, anoNacimento, endereco, telefone, email, sexo);
		
		this.matricula = matricula;
		this.curso = curso;
		this.turma = turma;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public double[] getNotas() {
		return notas;
	}

	public void setNotas(double[] notas) {
		this.notas = notas;
	}

	public double getMediaFinal() {
		return mediaFinal;
	}

	public void setMediaFinal(double mediafinal) {
		this.mediaFinal = mediafinal;
	}
	
	
	@Override
	public void exibirInformacoes() {
		System.out.println("Informacoes do aluno: ");
		System.out.println("Nome: "+getNome());
		System.out.println("Matricula: "+getMatricula());
		System.out.println("Curso: "+getCurso());
		System.out.println("Turma: "+getTurma());
		System.out.println("Ano de nascimento: "+getAnoNacimento());
		System.out.println("Endereco: "+getEndereco());
		System.out.println("Telefone: "+getTelefone());
		System.out.println("Email: "+getEmail());
		System.out.println("Sexo: "+getSexo());
	}
	
	public void adicionarNotas() {
		Scanner sc = new Scanner(System.in);
		String resposta;
		do {
		try {
		System.out.println("=== Adicionando Notas ===\n");
		
		for(int i = 0; i < notas.length; i++) {
			System.out.println("Digite a "+(i+1)+" nota: ");
			double nota = sc.nextDouble();
			if(nota > 0 && nota < 11) {
				notas[i] = nota;
			}
		}
		} catch (Exception e) {
			System.out.println("Erro: "+e);
		}
		System.out.println("\nOcorreo um Erro!\nTente novamente\n\nDeseja tenta de novo (S/N):");
		resposta = sc.nextLine();
		}while(resposta.equalsIgnoreCase("S"));
		
	}
	
	public void calcularMedia() {
		double n, media;
		n = 0;
		for(int i = 0; i < notas.length; i++) {
			n += notas[i];
		}
		media = n/notas.length;
		setMediaFinal(media);
	}
	
	public void mostraSituacao() {
		System.out.println("==========================================================================");
		System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-12s |\n",
		                  "1ª Nota", "2ª Nota", "3ª Nota", "4ª Nota", "Média Final");
		System.out.println("==========================================================================");

		for (int i = 0; i < notas.length; i++) {
		    System.out.printf("| %-10.2f ", notas[i]);
		}

		System.out.printf("| %-12.2f |\n", getMediaFinal());
		System.out.println("==========================================================================\n");
		
		System.out.print("Situação: ");
		if(getMediaFinal() >= 6) {
			System.out.println("Aprovado");
		} else{
			System.out.println("Reprovado");
		}
		
	}
	
}
