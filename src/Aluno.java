import java.util.List;

public class Aluno extends Pessoa
{
    private final int numero;
    private int ano;
    private Curso curso;

    public Aluno(Universidade universidade, String nome, String email, int numero, int ano, Curso curso, List<Cadeira> cadeiras, Horario horario)
    {
        super(universidade, nome, email, horario, cadeiras);
        this.numero = numero;
        this.ano = ano;
        this.curso = curso;
    }

    public void setStudentYear(int year)
    {
        this.ano = year;
    }

    public void setStudentCourse(Curso course)
    {
        this.curso = course;
    }

    public int getStudentNumber()
    {
        return this.numero;
    }

    public Curso getStudentCourse()
    {
        return this.curso;
    }


}