import java.util.ArrayList;

/**
 * Representa um curso que pode ter vários anos ou várias cadeiras, e ainda um professor coordenador.
 */
public class Curso
{
    private String nome;
    private int anos;
    private ArrayList<Cadeira> cadeiras;
    private Professor coordenador;

    public Curso(String nome, int anos, ArrayList<Cadeira> cadeiras, Professor coordenador)
    {
        this.nome = nome;
        this.anos = anos;
        this.cadeiras = cadeiras;
        this.coordenador = coordenador;
    }

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

    public Professor getCourseCoordinator()
    {
        return coordenador;
    }

    public void setCourseCoordinator(Professor coordinator)
    {
        this.coordenador = coordinator;
    }
}