import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

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
        int maxId = 0;
        for (PontoDePassagem p : pontos) {
            if (p.getId() > maxId) maxId = p.getId();
        }
        this.grafoPontos = new EdgeWeightedGraph(maxId + 1);
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

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Piso: ").append(nivel).append("\n");
        sb.append("Pontos de Passagem:\n");
        for(PontoDePassagem ponto : pontos)
        {
            sb.append("  - ").append(ponto.getNamePP()).append("\n");
        }
        sb.append("Ligações:\n");
        HashSet<String> printed = new HashSet<>();
        for(int v = 0; v < this.grafoPontos.V(); v++)
        {
            for(Edge e : this.grafoPontos.adj(v))
            {
                int id1 = e.either();
                int id2 = e.other(id1);
                String key = Math.min(id1, id2) + "-" + Math.max(id1, id2);
                if(!printed.contains(key))
                {
                    sb.append("  ").append(id1).append(" <-> ").append(id2).append(" (peso: ").append(e.weight()).append(")\n");
                    printed.add(key);
                }
            }
        }
        return sb.toString();
    }

    public void escreverFicheiro(String file_path)
    {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file_path, false)))
        {
            writer.write("Piso;" + this.nivel);
            writer.newLine();
            HashSet<String> printed = new HashSet<>();
            for(PontoDePassagem ponto : pontos)
            {
                writer.write("Ponto;" + ponto.getId() + ";" + ponto.getNamePP());
                writer.newLine();
            }
            for(int v = 0; v < this.grafoPontos.V(); v++)
            {
                for(Edge e : this.grafoPontos.adj(v))
                {
                    int id1 = e.either();
                    int id2 = e.other(id1);
                    String key = Math.min(id1, id2) + "-" + Math.max(id1, id2);
                    if(!printed.contains(key))
                    {
                        writer.write("Ligacao;" + id1 + ";" + id2 + ";" + e.weight());
                        writer.newLine();
                        printed.add(key);
                    }
                }
            }
            writer.write("FIM_PISO");
            writer.newLine();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void lerFicheiro(String file_path)
    {
        try(BufferedReader reader = new BufferedReader(new FileReader(file_path)))
        {
            String linha;
            ArrayList<PontoDePassagem> pontosLidos = new ArrayList<>();
            EdgeWeightedGraph grafo = null;
            int nivelLido = 0;
            while((linha = reader.readLine()) != null)
            {
                String[] dados = linha.split(";");
                if(dados[0].equals("Piso"))
                {
                    nivelLido = Integer.parseInt(dados[1]);
                }
                else if(dados[0].equals("Ponto"))
                {
                    int id = Integer.parseInt(dados[1]);
                    String nome = dados[2];
                    pontosLidos.add(new PontoDePassagem(id, nome));
                }
                else if(dados[0].equals("Ligacao"))
                {
                    if(grafo == null)
                        grafo = new EdgeWeightedGraph(100);         // ou pontosLidos.size()
                    int id1 = Integer.parseInt(dados[1]);
                    int id2 = Integer.parseInt(dados[2]);
                    double peso = Double.parseDouble(dados[3]);
                    grafo.addEdge(new Edge(id1, id2, peso));
                }
                else if(dados[0].equals("FIM_PISO"))
                {
                    this.nivel = nivelLido;
                    this.pontos = pontosLidos;
                    this.grafoPontos = grafo;
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
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

        System.out.println(piso);
        System.out.println();

        // -----------------------------------------CAMINHO MAIS CURTO ENTRE SALAS-----------------------------------------
        System.out.println("-----------------------------------------CAMINHO MAIS CURTO ENTRE SALAS-----------------------------------------");
        ArrayList<PontoDePassagem> caminho = piso.caminhoMaisCurto(sala1, sala3);

        System.out.println("Caminho mais curto entre Sala 101 e Sala 103:");
        for(PontoDePassagem ponto : caminho)
        {
            System.out.println(ponto.getNamePP());
        }
        System.out.println();

        // -----------------------------------------ESCRITA E LEITURA EM FICHEIROS-----------------------------------------
        System.out.println("-----------------------------------------ESCRITA E LEITURA EM FICHEIROS-----------------------------------------");
        piso.escreverFicheiro("teste.txt");

        Piso piso2 = new Piso(0, new ArrayList<>());
        piso2.lerFicheiro("teste.txt");
        System.out.println(piso2);

        // -------------------------------------------------PISO É CONEXO--------------------------------------------------
        System.out.println("-------------------------------------------------PISO É CONEXO--------------------------------------------------");
        System.out.println(piso.pisoEConexo());

        piso.grafoPontos = new EdgeWeightedGraph(pontos.size());
        piso.conectarPontos(sala1, sala2, 1);
        piso.conectarPontos(escada, sala3, 1);

        System.out.println(piso.pisoEConexo());
        System.out.println();
    }
}