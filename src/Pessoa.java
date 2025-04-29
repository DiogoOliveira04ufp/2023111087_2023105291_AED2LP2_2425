import java.util.List;

public abstract class Pessoa
{
    private Universidade universidade;
    private String nome;
    private String email;
    private Horario horario;
    private List<Cadeira> cadeiras;

    public Pessoa(Universidade universidade, String nome, String email, Horario horario, List<Cadeira> cadeiras)
    {
        this.universidade = universidade;
        this.nome = nome;
        this.email = email;
        this.horario = horario;
        this.cadeiras = cadeiras;
    }

    public Universidade getUni()
    {
        return this.universidade;
    }

    public String getName()
    {
        return nome;
    }

    public void setName(String name)
    {
        this.nome = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setUni(Universidade uni)
    {
        this.universidade = uni;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Horario getTimetable()
    {
        return horario;
    }

    public void setTimetable(Horario timetable)
    {
        this.horario = timetable;
    }

    public List<Cadeira> getClasses()
    {
        return cadeiras;
    }

    public void setClasses(List<Cadeira> classes)
    {
        this.cadeiras = classes;
    }
}