import java.util.ArrayList;

public class Curso
{
    private String nome;
    private int anos;
    private ArrayList<Cadeira> cadeiras;
    private ArrayList<Aluno> alunos;
    private ArrayList<Professor> professores;
    private Professor coordenador;

    public Curso(String nome, int anos, ArrayList<Cadeira> cadeiras, ArrayList<Aluno> alunos, ArrayList<Professor> professores, Professor coordenador)
    {
        this.nome = nome;
        this.anos = anos;
        this.cadeiras = cadeiras;
        this.alunos = alunos;
        this.professores = professores;
        this.coordenador = coordenador;
    }

    /*
    public Curso()
    {
        this.nome = "Engenharia Informática";
        this.anos = 3;
        this
    }
    */

    public String getCourseName()
    {
        return nome;
    }

    public void setCourseName(String name)
    {
        this.nome = name;
    }

    public int getCourseYears()
    {
        return anos;
    }

    public void setCourseYears(int years)
    {
        this.anos = years;
    }

    public ArrayList<Cadeira> getCourseClasses()
    {
        return cadeiras;
    }

    public void setCourseClasses(ArrayList<Cadeira> classes)
    {
        this.cadeiras = classes;
    }

    public ArrayList<Aluno> getCourseStudents()
    {
        return alunos;
    }

    public void setCourseStudents(ArrayList<Aluno> students)
    {
        this.alunos = students;
    }

    public ArrayList<Professor> getCourseProfessors()
    {
        return professores;
    }

    public void setCourseProfessors(ArrayList<Professor> professors)
    {
        this.professores = professors;
    }

    public Professor getCourseCoordinator()
    {
        return coordenador;
    }

    public void setCourseCoordinator(Professor coordinator)
    {
        this.coordenador = coordinator;
    }
}
