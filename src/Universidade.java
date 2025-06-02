import edu.princeton.cs.algs4.Graph;

import java.util.ArrayList;

public class Universidade
{
    private String nome;
    private ArrayList<Curso> cursos;
    private ArrayList<Piso> pisos;
    private Graph grafoPisos;

    public Universidade(String nome, ArrayList<Curso> cursos, ArrayList<Piso> pisos)
    {
        this.nome = nome;
        this.cursos = cursos;
        this.pisos = pisos;
        this.grafoPisos = new Graph(pisos.size());
    }

    public String getUniName()
    {
        return nome;
    }

    public void setUniName(String name)
    {
        this.nome = name;
    }

    public ArrayList<Curso> getUniCourses()
    {
        return cursos;
    }

    public void setUniCourses(ArrayList<Curso> courses)
    {
        this.cursos = courses;
    }

    public ArrayList<Piso> getUniFloors()
    {
        return pisos;
    }

    public void setUniFloors(ArrayList<Piso> floors)
    {
        this.pisos = floors;
    }

    @Override
    public String toString()
    {
        return "Universidade: " + nome + "\n" + "Cursos: " + (cursos.isEmpty() ? "Nenhum curso disponível" : cursos) + "\n" + "Pisos: " + (pisos.isEmpty() ? "Nenhum piso disponível" : pisos);
    }

    /**
     * Conectar dois grafos de pisos pelas suas escadas
     * @param piso1 primeiro piso a conectar
     * @param piso2 segundo piso a conectar
     */
    public void conectarPisos(Piso piso1, Piso piso2)
    {
        boolean escadaConecta = false;

        for(PontoDePassagem ponto : piso1.getPoints())
        {
            if(ponto instanceof Escada)
            {
                Escada escada = (Escada) ponto;
                if(escada.getPisoDestino() == piso2.getLevel())
                {
                    escadaConecta = true;
                    break;
                }
            }
        }

        if(escadaConecta)
        {
            grafoPisos.addEdge(pisos.indexOf(piso1), pisos.indexOf(piso2));
        }
        else
        {
            System.out.println("Não há escada conectando os pisos " + piso1.getLevel() + " e " + piso2.getLevel());
        }
    }

    /**
     * Verificar se dois pisos são conectados
     * @param piso1 primeiro piso conectado
     * @param piso2 segundo piso conectado
     * @return verdadeiro se são conectado || falso se não são conectados
     */
    public boolean saoConectados(Piso piso1, Piso piso2)
    {
        int id1 = pisos.indexOf(piso1);
        int id2 = pisos.indexOf(piso2);

        for(int adj : grafoPisos.adj(id1))
        {
            if(adj == id2)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Retornar ArrayList de pisos adjacentes a um dado piso
     * @param piso piso a verificar
     * @return ArrayList dos pisos adjacentes
     */
    public ArrayList<Piso> getPisosAdjacentes(Piso piso)
    {
        ArrayList<Piso> adjacentes = new ArrayList<>();
        for(int adj : grafoPisos.adj(pisos.indexOf(piso)))
        {
            adjacentes.add(pisos.get(adj));
        }
        return adjacentes;
    }

    /**
     * Teste da classe Universidade
     * @param args argumentos da linha de comandos
     */
    public static void main(String[] args)
    {
        Escada escada_1_2 = new Escada(0, "escada 1-2", 1, 2);
        Escada escada_2_3 = new Escada(1, "escada 2-3", 2, 3);
        ArrayList<PontoDePassagem> pontos_piso1 = new ArrayList<PontoDePassagem>();
        ArrayList<PontoDePassagem> pontos_piso2 = new ArrayList<PontoDePassagem>();
        ArrayList<PontoDePassagem> pontos_piso3 = new ArrayList<PontoDePassagem>();
        pontos_piso1.add(escada_1_2);
        pontos_piso2.add(escada_1_2);
        pontos_piso2.add(escada_2_3);
        pontos_piso3.add(escada_2_3);

        Piso piso1 = new Piso(1, pontos_piso1);
        Piso piso2 = new Piso(2, pontos_piso2);
        Piso piso3 = new Piso(3, pontos_piso3);

        ArrayList<Piso> pisos = new ArrayList<>();
        pisos.add(piso1);
        pisos.add(piso2);
        pisos.add(piso3);

        Universidade universidade = new Universidade("UFP", new ArrayList<>(), pisos);

        universidade.conectarPisos(piso1, piso2);
        universidade.conectarPisos(piso2, piso3);

        System.out.println("Piso 1 e Piso 2 conectados: " + universidade.saoConectados(piso1, piso2));
        System.out.println("Piso 2 e Piso 3 conectados: " + universidade.saoConectados(piso2, piso3));
        System.out.println("Piso 1 e Piso 3 conectados: " + universidade.saoConectados(piso1, piso3));

        System.out.println("Pisos adjacentes ao Piso 2: " + universidade.getPisosAdjacentes(piso2));
    }
}