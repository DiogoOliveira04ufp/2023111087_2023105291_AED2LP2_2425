public class Sala
{
    private int capacidade;
    private String nome;
    private Piso piso;
    private Horario horario;

    /*
    public Classroom()
    {
        this.nome = "208";

    }
    */

    public Sala(int capacidade, String nome, Piso piso, Horario horario)
    {
        this.capacidade = capacidade;
        this.nome = nome;
        this.piso = piso;
        this.horario = horario;
    }

    public String getRoomName()
    {
        return this.nome;
    }

    public Piso getFloor()
    {
        return this.piso;
    }

    public Horario getTimetable()
    {
        return this.horario;
    }

    public void setRoomName(String name)
    {
        this.nome = name;
    }

    public void setFloor(Piso floor)
    {
        this.piso = floor;
    }

    public void setTimetable(Horario timetable)
    {
        this.horario = timetable;
    }
}
