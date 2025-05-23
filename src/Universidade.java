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

    public void conectarPisos(Piso piso1, Piso piso2)
    {
        grafoPisos.addEdge(pisos.indexOf(piso1), pisos.indexOf(piso2));
    }

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

    public ArrayList<Piso> getPisosAdjacentes(Piso piso)
    {
        ArrayList<Piso> adjacentes = new ArrayList<>();
        for(int adj : grafoPisos.adj(pisos.indexOf(piso)))
        {
            adjacentes.add(pisos.get(adj));
        }
        return adjacentes;
    }

    public static void main(String[] args)
    {
        Piso piso1 = new Piso(1, new ArrayList<>());
        Piso piso2 = new Piso(2, new ArrayList<>());
        Piso piso3 = new Piso(3, new ArrayList<>());

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