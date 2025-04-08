import java.util.ArrayList;

public class Professor
{
    private String nome;
    private String email;
    private ArrayList<Cadeira> cadeiras;
    private Horario horario;

    public Professor(String nome, String email, ArrayList<Cadeira> cadeiras, Horario horario)
    {
        this.nome = nome;
        this.email = email;
        this.cadeiras = cadeiras;
        this.horario = horario;
    }

    public String getProfessorName()
    {
        return nome;
    }

    public void setProfessorName(String name)
    {
        this.nome = name;
    }

    public String getProfessorEmail()
    {
        return email;
    }

    public void setProfessorEmail(String email)
    {
        this.email = email;
    }

    public ArrayList<Cadeira> getProfessorClasses()
    {
        return cadeiras;
    }

    public void setProfessorClasses(ArrayList<Cadeira> classes)
    {
        this.cadeiras = classes;
    }

    public Horario getTimetable()
    {
        return horario;
    }

    public void setTimetable(Horario timetable)
    {
        this.horario = timetable;
    }
}
