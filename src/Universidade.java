import java.util.ArrayList;

public class Universidade
{
    private String nome;
    private ArrayList<Curso> cursos;
    private ArrayList<Aluno> alunos;
    private ArrayList<Professor> professores;
    private ArrayList<Piso> pisos;

    public Universidade(String nome, ArrayList<Curso> cursos, ArrayList<Aluno> alunos, ArrayList<Professor> professores, ArrayList<Piso> pisos)
    {
        this.nome = nome;
        this.cursos = cursos;
        this.alunos = alunos;
        this.professores = professores;
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

    public ArrayList<Aluno> getUniStudents()
    {
        return alunos;
    }

    public void setUniStudents(ArrayList<Aluno> students)
    {
        this.alunos = students;
    }

    public ArrayList<Professor> getUniProfessors()
    {
        return professores;
    }

    public void setUniProfessors(ArrayList<Professor> professors)
    {
        this.professores = professors;
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
