/**
 * Classe abstrata que será herdada pelas classes Aluno e Professor.
 */
public abstract class Pessoa
{
    private String nome;
    private String email;
    private Horario horario;

    public Pessoa(String nome, String email, Horario horario)
    {
        this.nome = nome;
        this.email = email;
        this.horario = horario;
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
}