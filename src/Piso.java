import java.util.ArrayList;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.LinearProbingHashST;

public class Piso
{
    private int nivel;
    private ArrayList<PontoDePassagem> pontos;
    private Graph grafoPontos;
    private LinearProbingHashST<String, Integer> nomeParaId;

    public Piso(int nivel, ArrayList<PontoDePassagem> pontos)
    {
        this.nivel = nivel;
        this.pontos = pontos;
        this.grafoPontos = new Graph(pontos.size());
        this.nomeParaId = new LinearProbingHashST<>();

        // Mapear pontos para IDs
        for (PontoDePassagem ponto : pontos)
        {
            nomeParaId.put(ponto.getNamePP(), ponto.getId());
        }
    }

    public void setLevel(int level)
    {
        this.nivel = level;
    }

    public void setPoints(ArrayList<PontoDePassagem> points)
    {
        this.pontos = points;
    }

    public int getLevel()
    {
        return this.nivel;
    }

    public ArrayList<PontoDePassagem> getPoints()
    {
        return this.pontos;
    }

    public void conectarPontos(PontoDePassagem ponto1, PontoDePassagem ponto2)
    {
        grafoPontos.addEdge(ponto1.getId(), ponto2.getId());
    }

    public boolean saoConectados(PontoDePassagem ponto1, PontoDePassagem ponto2)
    {
        for (int adj : grafoPontos.adj(ponto1.getId()))
        {
            if (adj == ponto2.getId())
            {
                return true;
            }
        }
        return false;
    }

    public Graph getGrafoSalas()
    {
        return grafoPontos;
    }
}
