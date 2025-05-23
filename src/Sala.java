import java.util.ArrayList;
import java.util.HashMap;

import edu.princeton.cs.algs4.Graph;

public class Sala extends PontoDePassagem
{
    private int capacidade;
    private int tomadas;
    private Horario horario;

    public Sala(int id, String nome, int capacidade, int tomadas, Horario horario)
    {
        super(id, nome);
        this.capacidade = capacidade;
        this.tomadas = tomadas;
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

    public void setTimetable(Horario timetable)
    {
        this.horario = timetable;
    }

    @Override
    public String toString()
    {
        return "Sala " + getNamePP() + "\ncapacidade: " + capacidade + "\ntomadas: " + tomadas;
    }

    /**
     * Teste da classe Sala
     * @param args arumentos da linha de comandos
     */
    public static void main(String[] args)
    {
        // Criar um objeto Horario para a sala
        Horario horario = new Horario(2025, 1, new ArrayList<>());

        // Criar uma sala
        Sala sala = new Sala(1, "Sala 208", 50, 10, horario);

        // Testar os métodos getters
        System.out.println("Nome da sala: " + sala.getNamePP());
        System.out.println("Capacidade: " + sala.getCapacity());
        System.out.println("Tomadas: " + sala.getOutlets());
        System.out.println("ID: " + sala.getId());
        System.out.println("Horário: " + sala.getTimetable());

        // Testar os métodos setters
        sala.setNamePP("Sala 106");
        sala.setCapacity(60);
        sala.setOutlets(15);
        sala.setId(2);

        // Verificar as alterações
        System.out.println("\nApós alterações:");
        System.out.println("Nome da sala: " + sala.getNamePP());
        System.out.println("Capacidade: " + sala.getCapacity());
        System.out.println("Tomadas: " + sala.getOutlets());
        System.out.println("ID: " + sala.getId());

        // Testar o método toString()
        System.out.println("\nRepresentação da sala:");
        System.out.println(sala);
    }
}