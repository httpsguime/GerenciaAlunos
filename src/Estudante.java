public class Estudante {

    private int matricula;
    private String nome;
    private float nota;

    public Estudante() {
    }

    public Estudante(int matricula, String nome, float nota) {
        this.matricula = matricula;
        this.nome = nome;
        this.nota = nota;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Matricula: " + getMatricula() + "- Nome: " + getNome();
    }
}