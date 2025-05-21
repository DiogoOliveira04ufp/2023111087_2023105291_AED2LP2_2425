import java.util.ArrayList;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.LinearProbingHashST;

public class Piso
{
    private int nivel;
    private ArrayList<Sala> salas;
    private Graph grafoSalas;
    private LinearProbingHashST<String, Integer> nomeParaId;

    public Piso(int nivel, ArrayList<Sala> salas)
    {
        this.nivel = nivel;
        this.salas = salas;
        this.grafoSalas = new Graph(salas.size());
        this.nomeParaId = new LinearProbingHashST<String, Integer>();

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

    public void conectarSalas(Sala sala1, Sala sala2)
    {
        int id1 = nomeParaId.get(sala1.getRoomName());
        int id2 = nomeParaId.get(sala2.getRoomName());
        grafoSalas.addEdge(id1, id2);
    }

    public boolean saoConectadas(Sala sala1, Sala sala2)
    {
        int id1 = nomeParaId.get(sala1.getRoomName());
        int id2 = nomeParaId.get(sala2.getRoomName());
        for (int adj : grafoSalas.adj(id1))
        {
            if (adj == id2)
            {
                return true;
            }
        }
        return false;
    }

    public Graph getGrafoSalas()
    {
        return grafoSalas;
    }
}
