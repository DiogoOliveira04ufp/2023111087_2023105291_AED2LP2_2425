import java.util.ArrayList;

public class Cadeira
{
    private String nome;
    private int year;
    private ArrayList<Professor> professores;
    private ArrayList<Aluno> students;

    public Cadeira(String nome, int ano, ArrayList<Professor> professores, ArrayList<Aluno> alunos)
    {
        this.nome = nome;
        this.year = ano;
        this.professores = professores;
        this.students = alunos;
    }

    public void setClassName(String name)
    {
        this.nome = name;
    }

    public void setClassYear(int year)
    {
        this.year = year;
    }

    public void setClassProfessors(ArrayList<Professor> professors)
    {
        this.professores = professors;
    }

    public void setClassStudents(ArrayList<Aluno> students)
    {
        this.students = students;
    }

    public String getClassName()
    {
        return this.nome;
    }

    public int getClassYear()
    {
        return this.year;
    }

    public ArrayList<Professor> getClassProfessors()
    {
        return this.professores;
    }

    public ArrayList<Aluno> getClassStudents()
    {
        return this.students;
    }
}