import java.util.ArrayList;

public class Horario
{
    private int ano;
    private int semestre;
    private ArrayList<Aula> aulas;

    public Horario(int ano, int semestre, ArrayList<Aula> aulas)
    {
        this.ano = ano;
        this.semestre = semestre;
        this.aulas = aulas;
    }

    public int getTTYear()
    {
        return ano;
    }

    public void setTTYear(int year)
    {
        this.ano = year;
    }

    public int getTTSemestre()
    {
        return semestre;
    }

    public void setTTSemestre(int semestre)
    {
        this.semestre = semestre;
    }

    public ArrayList<Aula> getTTLectures()
    {
        return aulas;
    }

    public void setTTLectures(ArrayList<Aula> lectures)
    {
        this.aulas = lectures;
    }
}
