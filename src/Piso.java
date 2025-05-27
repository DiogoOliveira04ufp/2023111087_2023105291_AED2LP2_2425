import java.util.ArrayList;

import edu.princeton.cs.algs4.BreadthFirstPaths;
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

    public ArrayList<PontoDePassagem> caminhoMaisCurto(PontoDePassagem ponto1, PontoDePassagem ponto2)
    {
        ArrayList<PontoDePassagem> caminho = new ArrayList<>();
        BreadthFirstPaths bfs = new BreadthFirstPaths(grafoPontos, ponto1.getId());

        if(bfs.hasPathTo(ponto2.getId()))
        {
            for(int id : bfs.pathTo(ponto2.getId()))
            {
                for(PontoDePassagem ponto : pontos)
                {
                    if(ponto.getId() == id)
                    {
                        caminho.add(ponto);
                        break;
                    }
                }
            }
        }

        return caminho;
    }

    public static void main(String[] args)
    {
        // Criar pontos de passagem
        PontoDePassagem sala1 = new Sala(0, "Sala 101", 30, 5, null);
        PontoDePassagem sala2 = new Sala(1, "Sala 102", 40, 6, null);
        PontoDePassagem sala3 = new Sala(2, "Sala 103", 50, 8, null);
        PontoDePassagem escada = new Escada(3, "Escada A", 1, 2);

        // Adicionar pontos ao piso
        ArrayList<PontoDePassagem> pontos = new ArrayList<>();
        pontos.add(sala1);
        pontos.add(sala2);
        pontos.add(sala3);
        pontos.add(escada);

        Piso piso = new Piso(1, pontos);

        // Conectar os pontos
        piso.conectarPontos(sala1, sala2);
        piso.conectarPontos(sala2, escada);
        piso.conectarPontos(escada, sala3);

        // Testar o caminho mais curto
        ArrayList<PontoDePassagem> caminho = piso.caminhoMaisCurto(sala1, sala3);

        // Exibir o caminho
        System.out.println("Caminho mais curto entre Sala 101 e Sala 103:");
        for (PontoDePassagem ponto : caminho)
        {
            System.out.println(ponto.getNamePP());
        }
    }
}
