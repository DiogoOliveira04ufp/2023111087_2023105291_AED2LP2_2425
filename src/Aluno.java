import java.util.ArrayList;

public class Aluno
{
    private String nome;
    private String email;
    private final int numero;
    private int ano;
    private Curso curso;
    private ArrayList<Cadeira> cadeiras;
    private Horario horario;

    public Aluno(String nome, String email, int numero, int ano, Curso curso, ArrayList<Cadeira> cadeiras, Horario horario)
    {
        this.nome = nome;
        this.email = email;
        this.numero = numero;
        this.ano = ano;
        this.curso = curso;
        this.cadeiras = cadeiras;
        this.horario = horario;
    }

    public void setStudentName(String name)
    {
        this.nome = name;
    }

    public void setStudentEmail(String email)
    {
        this.email = email;
    }

    public void setStudentYear(int year)
    {
        this.ano = year;
    }

    public void setStudentCourse(Curso course)
    {
        this.curso = course;
    }

    public void setStudentClasses(ArrayList<Cadeira> cadeiras)
    {
        this.cadeiras = cadeiras;
    }

    public void setTimetable(Horario horario)
    {
        this.horario = horario;
    }

    public String getStudentName()
    {
        return this.nome;
    }

    public String getStudentEmail()
    {
        return this.email;
    }

    public int getStudentNumber()
    {
        return this.numero;
    }

    public Curso getStudentCourse()
    {
        return this.curso;
    }

    public ArrayList<Cadeira> getStudentClasses()
    {
        return this.cadeiras;
    }

    public Horario getTimetable()
    {
        return this.horario;
    }
}