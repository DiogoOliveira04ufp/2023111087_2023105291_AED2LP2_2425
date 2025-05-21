import java.util.HashMap;

import edu.princeton.cs.algs4.Graph;

public class Sala
{
    private int capacidade;
    private int tomadas;
    private String nome;
    private Horario horario;

    public Sala(int capacidade, int tomadas, String nome, Horario horario)
    {
        this.capacidade = capacidade;
        this.tomadas = tomadas;
        this.nome = nome;
        this.horario = horario;
    }

    public int getCapacity()
    {
        return this.capacidade;
    }

    public int getOutlets()
    {
        return this.tomadas;
    }

    public String getRoomName()
    {
        return this.nome;
    }

    public Horario getTimetable()
    {
        return this.horario;
    }

    public void setCapacity(int capacity)
    {
        this.capacidade = capacity;
    }

    public void setOutlets(int outlets)
    {
        this.tomadas = outlets;
    }

    public void setRoomName(String name)
    {
        this.nome = name;
    }

    public void setTimetable(Horario timetable)
    {
        this.horario = timetable;
    }
}