package escola;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SistemaEscolar {
	
	private List<Aluno> listaAlunos;
	private List<Proferssor> listaProforssores;
	private List<Funcionario> listaFuncionarios;
	
	
	
	public SistemaEscolar() {
		listaAlunos = new ArrayList<>();
		listaProforssores = new ArrayList<>();
		listaFuncionarios = new ArrayList<>();
	}
	
	
	public void adicionaAluno(Aluno a) {
		listaAlunos.add(a);
	}

	public void removerAluno(String a) {
		boolean encotrado = false;
		Iterator<Aluno> obijeto = listaAlunos.iterator();
		while(obijeto.hasNext()) {
			Aluno aluno = obijeto.next();
			if(aluno.getNome().equalsIgnoreCase(a)) {
				obijeto.remove();
				encotrado = true;
				System.out.println("Aluno "+a+" removido com sucesso.");
				break;
			}
		}
		if(!encotrado) {
			System.out.println("Aluno "+a+" não encotrado.");	
		}
		
	}

	
	public void listaAlunos() {
		System.out.println("Lista de Alunos cadastrados: ");
		for (Aluno a : listaAlunos) {
			System.out.println("- "+a.getNome());
		}	
	}
	
	
	public void adicionaProferssor(Proferssor profersso) {
		listaProforssores.add(profersso);
	}
	
	public void removerProferssor(String p) {
		boolean encotrado = false;
		Iterator<Proferssor> obijeto = listaProforssores.iterator();
		
		while(obijeto.hasNext()) {
			Proferssor profer = obijeto.next();
			if(profer.getNome().equalsIgnoreCase(p)) {
			obijeto.remove();
			encotrado = true;
			System.out.println("Proferssor "+p+" removido com sucesso.");
			}
		}
		if(!encotrado) {
			System.out.println("Proferssor "+p+" não encontrado.");
		}
				
	}
	
	
	public void listaProferssor() {
		System.out.println("Lista de Proferssores cadrastados: ");
		for (Proferssor p : listaProforssores) {
			System.out.println("- "+p.getNome());
		}
	}
	
	
	public void adicionarFuncionario(Funcionario f) {
		listaFuncionarios.add(f);
	}
	
	public void removerFuncionario(String f) {
		boolean encotrado = false;
		Iterator<Funcionario> obijeto = listaFuncionarios.iterator(); 
		
		while(obijeto.hasNext()) {
			Funcionario funcio = obijeto.next();
			if(funcio.getNome().equalsIgnoreCase(f)) {
				obijeto.remove();
				encotrado = true;
				System.out.println("Funcionario "+f+" removido com sucesso.");
			}
		}
			
		if(!encotrado) {
				System.out.println("Funcionario "+f+" não encotrao.");
			
		}
	}
	
	public List<Aluno> getListaAlunos() {
		return listaAlunos;
	}


	public void setListaAlunos(List<Aluno> listaAlunos) {
		this.listaAlunos = listaAlunos;
	}


	public List<Proferssor> getListaProforssores() {
		return listaProforssores;
	}


	public void setListaProforssores(List<Proferssor> listaProforssores) {
		this.listaProforssores = listaProforssores;
	}


	public List<Funcionario> getListaFuncionarios() {
		return listaFuncionarios;
	}


	public void setListaFuncionarios(List<Funcionario> listaFuncionarios) {
		this.listaFuncionarios = listaFuncionarios;
	}


	public void listaFuncionario() {
		System.out.println("Lista de Funcionarios cadastrados: ");
		for (Funcionario f : listaFuncionarios) {
			System.out.println("- "+f.getNome());
		}
	}
	
}
