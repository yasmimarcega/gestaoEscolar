import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Escola escola = new Escola("Escola Modelo", "1234-5678");
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Adicionar Aluno");
            System.out.println("2. Adicionar Disciplina");
            System.out.println("3. Matricular Aluno em Disciplina");
            System.out.println("4. Desmatricular Aluno de Disciplina");
            System.out.println("5. Listar Alunos Matriculados em Disciplina");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Ano de Nascimento: ");
                    int anoNascimento = scanner.nextInt();
                    scanner.nextLine();

                    Aluno aluno = new Aluno(nome, cpf, email, anoNascimento);
                    if (escola.adicionarAluno(aluno)) {
                        System.out.println("Aluno adicionado com sucesso.");
                    } else {
                        System.out.println("Erro ao adicionar aluno. CPF já existe.");
                    }
                    break;

                case 2:
                    System.out.print("Código: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Nome da disciplina: ");
                    String nomeDisciplina = scanner.nextLine();
                    System.out.print("Carga Horária: ");
                    int cargaHoraria = scanner.nextInt();
                    System.out.print("Limite de Alunos: ");
                    int limiteAlunos = scanner.nextInt();
                    scanner.nextLine();

                    Disciplina disciplina = new Disciplina(codigo, nomeDisciplina, cargaHoraria, limiteAlunos);
                    if (escola.adicionarDisciplina(disciplina)) {
                        System.out.println("Disciplina adicionada com sucesso.");
                    } else {
                        System.out.println("Erro ao adicionar disciplina. Código já existe.");
                    }
                    break;

                case 3:
                    System.out.print("Código da disciplina: ");
                    codigo = scanner.nextLine();
                    System.out.print("CPF do aluno: ");
                    cpf = scanner.nextLine();
                    if (escola.matricular(codigo, cpf)) {
                        System.out.println("Aluno matriculado com sucesso.");
                    } else {
                        System.out.println("Erro ao matricular aluno.");
                    }
                    break;

                case 4:
                    System.out.print("Código da disciplina: ");
                    codigo = scanner.nextLine();
                    System.out.print("CPF do aluno: ");
                    cpf = scanner.nextLine();
                    if (escola.desmatricular(codigo, cpf)) {
                        System.out.println("Aluno desmatriculado com sucesso.");
                    } else {
                        System.out.println("Erro ao desmatricular aluno.");
                    }
                    break;

                case 5:
                    System.out.print("Código da disciplina: ");
                    codigo = scanner.nextLine();
                    System.out.println(escola.listarAlunosMatriculados(codigo));
                    break;

                case 6:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 6);

        scanner.close();
    }
}
