import java.util.ArrayList;

import edu.princeton.cs.algs4.CC;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.DijkstraUndirectedSP;

/**
 * Grafos que representam cada piso da universidade. Poderão ter vários pontos de passagem (salas ou outros tipos de pontos), e estarão ligados a outros pisos pelas escadas.
 */
public class Piso
{
    private int nivel;
    private ArrayList<PontoDePassagem> pontos;
    private EdgeWeightedGraph grafoPontos;

    public Piso(int nivel, ArrayList<PontoDePassagem> pontos)
    {
        this.nivel = nivel;
        this.pontos = pontos;
        this.grafoPontos = new EdgeWeightedGraph(pontos.size());
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

    /**
     * Conecta dois pontos no grafo com o peso dado
     * @param ponto1 primeiro ponto a conectar
     * @param ponto2 segundo ponto a conectar
     * @param peso peso da aresta
     */
    public void conectarPontos(PontoDePassagem ponto1, PontoDePassagem ponto2, double peso)
    {
        Edge edge = new Edge(ponto1.getId(), ponto2.getId(), peso);
        grafoPontos.addEdge(edge);
    }

    /**
     * Retorna se dois pontos estão conectados no grafo
     * @param ponto1 primeiro ponto a verificar
     * @param ponto2 segundo ponto a verificar
     * @return verdadeiro se é conectado || falso se não é conectado
     */
    public boolean saoConectados(PontoDePassagem ponto1, PontoDePassagem ponto2)
    {
        for (Edge edge : grafoPontos.adj(ponto1.getId()))
        {
            if (edge.other(ponto1.getId()) == ponto2.getId())
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Utilizar Dijkstra para descobrir o caminho mais curto entre dois pontos
     * @param ponto1 primeiro ponto
     * @param ponto2 segundo ponto
     * @return ArrayList de pontos por onde se tem de passar, na ordem por onde se tem de passar
     */
    public ArrayList<PontoDePassagem> caminhoMaisCurto(PontoDePassagem ponto1, PontoDePassagem ponto2)
    {
        ArrayList<PontoDePassagem> caminho = new ArrayList<>();
        DijkstraUndirectedSP dijkstra = new DijkstraUndirectedSP(grafoPontos, ponto1.getId());

        if(dijkstra.hasPathTo(ponto2.getId()))
        {
            for(Edge edge : dijkstra.pathTo(ponto2.getId()))
            {
                int id1 = edge.either();
                int id2 = edge.other(id1);

                // Adicionar ambos os pontos da aresta ao caminho, se ainda não estiverem
                for(PontoDePassagem ponto : pontos)
                {
                    if(ponto.getId() == id1 && !caminho.contains(ponto))
                    {
                        caminho.add(ponto);
                    }
                    if(ponto.getId() == id2 && !caminho.contains(ponto))
                    {
                        caminho.add(ponto);
                    }
                }
            }
        }

        return caminho;
    }

    /**
     * Verificar se o grafo do piso é conexo, ou seja, pode-se chegar a todas os pontos do piso a partir de qualquer um dos seus outros pontos
     * @return verdadeiro -> o piso é conexo || falso -> o piso não é conexo
     */
    public boolean pisoEConexo()
    {
        CC cc = new CC(grafoPontos);
        return cc.count() == 1;         // Retorna true se o grafo tiver apenas 1 componente conectado
    }

    /**
     * Teste da classe Piso
     * @param args argumentos da linha de comandos
     */
    public static void main(String[] args)
    {
        PontoDePassagem sala1 = new Sala(0, "Sala 101", 30, 5, null);
        PontoDePassagem sala2 = new Sala(1, "Sala 102", 40, 6, null);
        PontoDePassagem sala3 = new Sala(2, "Sala 103", 50, 8, null);
        PontoDePassagem escada = new Escada(3, "Escada A", 1, 2);

        ArrayList<PontoDePassagem> pontos = new ArrayList<>();
        pontos.add(sala1);
        pontos.add(sala2);
        pontos.add(sala3);
        pontos.add(escada);

        Piso piso = new Piso(1, pontos);

        piso.conectarPontos(sala1, sala2, 1);
        piso.conectarPontos(sala2, escada, 1);
        piso.conectarPontos(escada, sala3, 1);
        piso.conectarPontos(sala3, sala1, 1);

        ArrayList<PontoDePassagem> caminho = piso.caminhoMaisCurto(sala1, sala3);

        System.out.println("Caminho mais curto entre Sala 101 e Sala 103:");
        for (PontoDePassagem ponto : caminho)
        {
            System.out.println(ponto.getNamePP());
        }

        System.out.println(piso.pisoEConexo());

        piso.grafoPontos = new EdgeWeightedGraph(pontos.size());
        piso.conectarPontos(sala1, sala2, 1);
        piso.conectarPontos(escada, sala3, 1);

        System.out.println(piso.pisoEConexo());
    }
}