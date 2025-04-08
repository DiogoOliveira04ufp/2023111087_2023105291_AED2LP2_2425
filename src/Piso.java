import java.util.ArrayList;

public class Piso
{
    private int nivel;
    private ArrayList<Sala> salas;

    public Piso(int nivel, ArrayList<Sala> salas)
    {
        this.nivel = nivel;
        this.salas = salas;
    }

    public void setLevel(int level)
    {
        this.nivel = level;
    }

    public void setRooms(ArrayList<Sala> salas)
    {
        this.salas = salas;
    }

    public int getLevel()
    {
        return this.nivel;
    }

    public ArrayList<Sala> getRooms()
    {
        return this.salas;
    }
}
