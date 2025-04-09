import java.util.List;

public abstract class Pessoa
{
    private String nome;
    private String email;
    private Horario horario;
    private List<Cadeira> cadeiras;

    public Pessoa(String nome, String email, Horario horario, List<Cadeira> cadeiras)
    {
        this.nome = nome;
        this.email = email;
        this.horario = horario;
        this.cadeiras = cadeiras;
    }

    public String getName()
    {
        return nome;
    }

    public void setName(String name)
    {
        this.nome = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Horario getTimetable() {
        return horario;
    }

    public void setTimetable(Horario timetable) {
        this.horario = timetable;
    }

    public List<Cadeira> getClasses() {
        return cadeiras;
    }

    public void setClasses(List<Cadeira> classes) {
        this.cadeiras = classes;
    }
}