import java.util.ArrayList;
import java.util.HashMap;

import edu.princeton.cs.algs4.Graph;

public class Piso
{
    private int nivel;
    private ArrayList<Sala> salas;
    private Graph grafoSalas;
    private HashMap<String, Integer> nomeParaId;

    public Piso(int nivel, ArrayList<Sala> salas)
    {
        this.nivel = nivel;
        this.salas = salas;
        this.grafoSalas = new Graph(salas.size());
        this.nomeParaId = new HashMap<>();

        // Mapear salas para IDs
        for (int i = 0; i < salas.size(); i++)
        {
            nomeParaId.put(salas.get(i).getRoomName(), i);
        }
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
