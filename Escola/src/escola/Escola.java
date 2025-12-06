package escola;

import java.util.*;

public class Escola {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        SistemaEscolar sistema = new SistemaEscolar();
        String resposta = "";
        boolean continuar1 = true;
        do {
        try{
            
            while(continuar1) {
            System.out.println("Menu do Sistema Escolar: ");
            System.out.println("1-Adicionar Aluno\n2-Adicionar Professor\n3-Adicionar Funcionário\n4-Listas"
                                + "\n5-Exibir Informações\n6-Remover da Lista "
                                + "\n7-Adicionar Notas\n8-Mostrar Situação do Aluno\n9-Sair");
            
            System.out.print("\nEscolha uma opção: ");
            String escolhar1 = sc.nextLine();

            
            switch(escolhar1) {
                    case "1" ->{
                        System.out.println("=== Cadastro de Aluno ===");
                        System.out.print("Nome: ");
                        String nome = sc.nextLine();
                        System.out.print("Ano de Nascimento: ");
                        int anoNacimento = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Endereço: ");
                        String endereco = sc.nextLine();
                        System.out.print("Telefone: ");
                        String telefone = sc.nextLine();
                        System.out.print("Email: ");
                        String email = sc.nextLine();
                        char sexo;
                        do {
                        System.out.print("Sexo (M/F): ");
                        sexo = sc.next().toUpperCase().charAt(0);
                        if (sexo != 'M' && sexo != 'F' ) {
                            System.out.println("Valor inválido! Digite M ou F.");
                        } 
                        }while(sexo != 'M' && sexo != 'F');
                        sc.nextLine();
                        System.out.print("Matrícula: ");
                        String matricula = sc.nextLine();
                        System.out.print("Curso: ");
                        String curso = sc.nextLine();
                        System.out.print("Turma: ");
                        String turma = sc.nextLine();
                        
                        Aluno aluno = new Aluno(nome,anoNacimento,endereco,
                                                telefone,email,sexo,matricula,
                                                curso,turma);
                        sistema.adicionaAluno(aluno);
            
                    }
                    
                    case "2" -> {
                        System.out.println("=== Cadastro de Professor ===");
                        System.out.print("Nome: ");
                        String nome = sc.nextLine();
                        System.out.print("Ano de Nascimento: ");
                        int anoNacimento = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Endereço: ");
                        String endereco = sc.nextLine();
                        System.out.print("Telefone: ");
                        String telefone = sc.nextLine();
                        System.out.print("Email: ");
                        String email = sc.nextLine();
                        char sexo;
                        do {
                        System.out.print("Sexo (M/F): ");
                        sexo = sc.next().toUpperCase().charAt(0);
                        if (sexo != 'M' && sexo != 'F' ) {
                            System.out.println("Valor inválido! Digite M ou F.");
                        } 
                        }while(sexo != 'M' && sexo != 'F');
                        sc.nextLine();
                        System.out.print("Código de Funcionário: ");
                        String codigoFuncionario = sc.nextLine();
                        System.out.print("Salário: ");
                        double salario = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Disciplina: ");
                        String disciplina = sc.nextLine();
                        System.out.print("Carga Horária: ");
                        int cargaHoraria = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Titulação: ");
                        String titulacao = sc.nextLine();
            
                        Proferssor proferssor = new Proferssor(nome, anoNacimento, endereco, 
                                                                telefone, email, sexo, codigoFuncionario, salario,
                                                                disciplina, cargaHoraria, titulacao);
                        sistema.adicionaProferssor(proferssor);
                    }
                    
                    case "3" -> {
                        System.out.println("=== Cadastro de Funcionário ===");
                        System.out.print("Nome: ");
                        String nome = sc.nextLine();
                        System.out.print("Ano de Nascimento: ");
                        int anoNacimento = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Endereço: ");
                        String endereco = sc.nextLine();
                        System.out.print("Telefone: ");
                        String telefone = sc.nextLine();
                        System.out.print("Email: ");
                        String email = sc.nextLine();
                        char sexo;
                        do {
                        System.out.print("Sexo (M/F): ");
                        sexo = sc.next().toUpperCase().charAt(0);
                        if (sexo != 'M' && sexo != 'F' ) {
                            System.out.println("Valor inválido! Digite M ou F.");
                        } 
                        }while(sexo != 'M' && sexo != 'F');
                        sc.nextLine();
                        System.out.print("Código do Funcionário: ");
                        String idFuncionario = sc.nextLine();
                        System.out.print("Cargo: ");
                        String cargo = sc.nextLine();
                        System.out.print("Departamento: ");
                        String departamento = sc.nextLine();
                        System.out.print("Salário: ");
                        double salario = sc.nextDouble();
                        sc.nextLine();
                        Funcionario funcionario = new Funcionario(nome, anoNacimento, endereco, telefone, email, sexo,
                                                                  idFuncionario, cargo, departamento, salario);
                        sistema.adicionarFuncionario(funcionario);
                    }
                    
                    case "4" -> {
                        boolean continuar2 = true;
                        System.out.println("=== LISTAS ===");
                        while(continuar2) {
                        System.out.println("1-Lista de Alunos\n2-Lista de Professores\n3-Lista de Funcionários\n4-Sair");
            
                        System.out.print("\nEscolha uma lista: ");
                        String escolhar2 = sc.nextLine();
                        
                        switch(escolhar2) {
                        case "1" -> {
                            System.out.println("=== Lista de Alunos ===");
                            sistema.listaAlunos();
                            sc.nextLine();
                        }
                        case "2" ->{
                            System.out.println("=== Lista de Professores ===");
                            sistema.listaProferssor();
                            sc.nextLine();
                        }
                        case "3" ->{
                            System.out.println("=== Lista de Funcionários ===");
                            sistema.listaFuncionario();
                            sc.nextLine();
                        }
                        case "4" -> {
                            continuar2 = false;
                        }
                        default ->{
                            System.out.println("Opção inválida!\nTente novamente\nAperte Enter para voltar ao menu");
                            sc.nextLine();
                        }
                                }
                        for(int i = 0; i < 21; i++) {
                            System.out.println("");
                        }   
                            }
                        }
                        case "5" ->{
                            System.out.println("=== Exibir Informações ===");
                            boolean continuar3 = true;
                            while(continuar3) {
                                System.out.println("1-Informações de Aluno\n2-Informações de Professor\n3-Informações de Funcionário\n4-Sair");
                                System.out.print("Escolha: ");
                                String escolher = sc.nextLine();    
                                
                                switch(escolher) {
                                case "1" -> {
                                    System.out.print("Digite o nome do aluno: ");
                                    String nomeAluno = sc.nextLine();
                                    
                                    boolean encontrado = false;
                                    for(Aluno a : sistema.getListaAlunos()) {
                                        if(a.getNome().equalsIgnoreCase(nomeAluno)) {
                                        a.exibirInformacoes();
                                        encontrado = true;     
                                        break;
                                        }
                                    }
                                    if(!encontrado) {
                                        System.out.println("Aluno "+nomeAluno+" não encontrado");
                                    }
                                    sc.nextLine();
                                }
                                case "2" ->{
                                    System.out.print("Digite o nome do Professor: ");
                                    String nomeProfer = sc.nextLine();
                                    
                                    boolean encontrado = false;
                                    for(Proferssor p : sistema.getListaProforssores()) {
                                        if(p.getNome().equalsIgnoreCase(nomeProfer)) {
                                            p.exibirInformacoes();
                                            encontrado = true;
                                            break;
                                        }
                                    }
                                    if(!encontrado) {
                                        System.out.println("Professor "+nomeProfer+" não encontrado");
                                    }
                                    sc.nextLine();
                                }
                                case "3" -> {
                                    System.out.print("Digite o nome do Funcionário: ");
                                    String nomeFuncio = sc.nextLine();
                                    
                                    boolean encontrado = false;
                                    for(Funcionario f : sistema.getListaFuncionarios()) {
                                        if(f.getNome().equalsIgnoreCase(nomeFuncio)) {
                                            f.exibirInformacoes();
                                            encontrado = true;
                                            break;
                                        }
                                    }
                                    if(!encontrado) {
                                        System.out.println("Funcionário "+nomeFuncio+" não encontrado");
                                    }
                                    sc.nextLine();
                                    }
                                case "4"-> {
                                    continuar3 = false;
                                }
                                default ->{
                                    System.out.println("Opção inválida!\nTente novamente\nAperte Enter para voltar ao menu");
                                    sc.nextLine();
                                }
                                }
                                
                                for(int i = 0; i < 21; i++) {
                                    System.out.println("");
                                }
                            }
                        }
                        case "6" ->{
                                System.out.println("=== Remover da lista ===");

                                boolean continuar3 = true;
                                while(continuar3) {
                                    System.out.println("1-Remover Aluno\n2-Remover Professor\n3-Remover Funcionário\n4-Sair");
                                    System.out.print("Escolha: ");
                                    String escolher = sc.nextLine();    
                                    
                                    switch(escolher) { 
                                        case "1" -> {
                                            System.out.println("Removendo Aluno");
            
                                            System.out.print("Digite o nome do aluno: ");
                                            String nomeAluno = sc.nextLine();
                                            sistema.removerAluno(nomeAluno);
                                        }
                                        case "2" -> {
                                            System.out.println("Removendo Professor");
            
                                            System.out.print("Digite o nome do Professor: ");
                                            String nomeProferssor = sc.nextLine();
                                            sistema.removerProferssor(nomeProferssor);
                                        }
                                        case "3" -> {
                                            System.out.println("Removendo Funcionário.");
            
                                            System.out.print("Digite o nome do Funcionário: ");
                                            String nomeFuncionario = sc.nextLine();
                                            sistema.removerFuncionario(nomeFuncionario);
                                        }
                                        default ->{
                                            System.out.println("Opção inválida!\nTente novamente\nAperte Enter para voltar ao menu");
                                            sc.nextLine();
                                        }
                                    }
                                }
                            
                        }
                        case "7" -> {
                            System.out.println("=== Adicionar Notas ===");
                            System.out.print("Digite o nome do aluno: ");
                            String nomeAluno = sc.nextLine();
                            
                            boolean encontrado = false;
                            for(Aluno a : sistema.getListaAlunos()) {
                                if(a.getNome().equalsIgnoreCase(nomeAluno)){
                                a.adicionarNotas();
                                encontrado = true;     
                                break;
                                }
                            }
                            if(!encontrado) {
                                System.out.println("Aluno "+nomeAluno+" não encontrado");
                            }
                        }
                        case "8" -> {
                            System.out.println("=== Mostrar Situação do Aluno ===");
                            System.out.print("Digite o nome do aluno: ");
                            String nomeAluno = sc.nextLine();
                            
                            boolean encontrado = false;
                            for(Aluno a : sistema.getListaAlunos()) {
                                if(a.getNome().equalsIgnoreCase(nomeAluno)) {
                                a.mostraSituacao();
                                encontrado = true;     
                                break;
                                }
                            }
                            if(!encontrado) {
                                System.out.println("Aluno "+nomeAluno+" não encontrado");
                            }
                        }
                        case "9" -> {
                            continuar1 = false;
                            System.out.println("Saindo do Sistema Escolar.");
                            
                        }
                        default ->{
                            System.out.println("Opção inválida!\nTente novamente\nAperte Enter para voltar ao menu");
                            sc.nextLine();
                        }
                }
            for(int i = 0; i < 21; i++) {
                System.out.println("");
            }
            }
            
        }catch (Exception e) {
            System.out.println("Tente novamente\n\nDeseja tentar de novo (S/N): ");
            sc.nextLine();
            resposta = sc.nextLine();
        }
        
        for(int j = 0; j < 21; j++) {
            System.out.println("");

        }
        }while(resposta.equalsIgnoreCase("S"));
    }

}
