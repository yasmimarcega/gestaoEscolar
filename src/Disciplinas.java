import java.util.HashSet;

public class Disciplinas {
    private String codigo;
    private String nome;
    private int cargaHoraria;
    private int limiteAlunos;
    private HashSet<Aluno> alunosMatriculados;

    public Disciplinas(String codigo, String nome, int cargaHoraria, int limiteAlunos) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.limiteAlunos = limiteAlunos;
        this.alunosMatriculados = new HashSet<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public int getLimiteAlunos() {
        return limiteAlunos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public void setLimiteAlunos(int limiteAlunos) {
        this.limiteAlunos = limiteAlunos;
    }

    public boolean matricular(Aluno a){
        if (alunosMatriculados.size() < limiteAlunos && !alunosMatriculados.contains(a)){
            return alunosMatriculados.add(a);
        }
        return false;
    }

    public boolean desmatricular(String cpf){
        for (Aluno aluno : alunosMatriculados){
            if (aluno.getCpf().equals(cpf)){
                alunosMatriculados.remove(aluno);
                return true;
            }
        }
        return false;
    }

    public String listarAlunos(){
        StringBuilder sb = new StringBuilder("Alunos Matriculados:\n");
        for (Aluno aluno : alunosMatriculados){
            sb.append(aluno.toString() + "\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Nome: " + nome + ", Carga Horário: " + cargaHoraria + ", horas, Limite de Alunos" + limiteAlunos;
    }
}
