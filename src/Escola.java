import java.util.ArrayList

public class Escola {
    private String nome;
    private String telefone;
    private ArrayList<Aluno> aluno;
    private ArrayList<Disciplinas> disciplinas;

    public Escola() {
        this.nome = nome;
        this.telefone = telefone;
        this.aluno = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
    }

    public boolean adicionarAluno(Aluno a) {
        if (buscarAlunoCpf(a.getCpf()) == null){
            aluno.add(a);
            return true;
        }
        return false;
    }

    public Aluno buscarAlunoCpf(String cpf) {
        for (Aluno aluno : alunos){
            if (aluno.getCpf().equals(cpf)){
                return aluno;
            }
        }
        return null;
    }

    public boolean adicionarDisciplina(Disciplinas d) {
        if (buscarDisciplina(nova.getCodigo()) == null){
            disciplinas.add(nova);
            return true;
        }
        return false;
    }

    public Disciplinas buscarDisciplina(String codigo) {
        for (Disciplinas disciplina : disciplinas){
            if (disciplina.getCodigo().equalsIgnoreCase(codigo)) {
                return disciplina;
            }
        }
        return null;
    }

    public boolean matricular(String codigo, String cpf){
        Disciplina disciplina = buscarDisciplina(codigo);
        Aluno aluno = buscarAlunoCpf(cpf);

        if (disciplina != null && aluno != null){
            return disciplina.matricular(aluno);
        }
        return false;
    }

    public boolean desmatricular(String codigo, String cpf){
        Disciplina disciplina = buscarDisciplina(codigo);

        if (disciplina != null){
            return disciplina.desmatricular(cpf);
        }
        return false;
    }

    public String listarAlunosMatriculados(String codigo){
        Disciplina disciplina = buscarDisciplina(codigo);

        if (disciplina != null){
            return disciplina.listarAlunos();
        }
        return "Disciplina não encontrada.";
    }

}
