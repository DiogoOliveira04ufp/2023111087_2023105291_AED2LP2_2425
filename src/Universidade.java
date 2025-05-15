import java.util.ArrayList;

public class Universidade
{
    private String nome;
    private ArrayList<Curso> cursos;
    private ArrayList<Piso> pisos;

    public Universidade(String nome, ArrayList<Curso> cursos, ArrayList<Aluno> alunos, ArrayList<Professor> professores, ArrayList<Piso> pisos)
    {
        this.nome = nome;
        this.cursos = cursos;
        this.pisos = pisos;
    }

    public String getUniName()
    {
        return nome;
    }

    public void setUniName(String name)
    {
        this.nome = name;
    }

    public ArrayList<Curso> getUniCourses()
    {
        return cursos;
    }

    public void setUniCourses(ArrayList<Curso> courses)
    {
        this.cursos = courses;
    }

    public ArrayList<Piso> getUniFloors()
    {
        return pisos;
    }

    public void setUniFloors(ArrayList<Piso> floors)
    {
        this.pisos = floors;
    }
}