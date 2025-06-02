import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

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
     * Ordenar as salas por tomadas (ordem decrescente)
     * @param salas salas a ordenar
     * @return salas ordenadas
     */
    public static List<Sala> ordenarPorTomadasDesc(List<Sala> salas)
    {
        salas.sort(Comparator.comparingInt(Sala::getOutlets).reversed());
        return salas;
    }

    /**
     * Ordenar salas por capaciade
     * @param salas salas a ordenar
     * @return salas ordenadas
     */
    public static List<Sala> ordenarPorCapacidadeDesc(List<Sala> salas)
    {
        salas.sort(Comparator.comparingInt(Sala::getCapacity).reversed());
        return salas;
    }

    /**
     * Extrai o número da sala (integer) do nome (string), ex: "Sala 208" -> 208
     * @param nomeSala nome da salas (string)
     * @return número da sala (integer)
     */
    public static int extrairNumeroSala(String nomeSala)
    {
        String[] partes = nomeSala.split(" ");
        return Integer.parseInt(partes[1]);
    }

    /**
     * Retorna piso da sala
     * @param numeroSala numero da sala
     * @return piso
     */
    public static String identificarPiso(int numeroSala)
    {
        if (numeroSala >= 101 && numeroSala < 121)
            return "1º Andar";
        if (numeroSala >= 201 && numeroSala < 221)
            return "2º Andar";
        if (numeroSala >= 301 && numeroSala < 321)
            return "3º Andar";
        return "Sala não encontrada ou inexistente";
    }

    /**
     * Mostra as salas agrupadas por piso e ordenadas pelo número
     * @param salas salas a ordenar
     */
    public static void mostrarSalasPorPisoOrdenadas(List<Sala> salas)
    {
        HashMap<String, List<Sala>> agrupadas = new HashMap<>();
        for(Sala sala : salas)
        {
            int numero = extrairNumeroSala(sala.getNamePP());
            String piso = identificarPiso(numero);
            agrupadas.computeIfAbsent(piso, k -> new ArrayList<>()).add(sala);
        }

        for(String piso : new String[]{"1º Andar", "2º Andar", "3º Andar"})
        {
            List<Sala> lista = agrupadas.get(piso);
            if(lista != null && !lista.isEmpty())
            {
                lista.sort(Comparator.comparingInt(s -> extrairNumeroSala(s.getNamePP())));
                System.out.println(piso + ":");
                for(Sala sala : lista)
                {
                    System.out.println("  " + sala.getNamePP());
                }
            }
        }
        // Salas não encontradas
        List<Sala> naoEncontradas = agrupadas.get("Sala não encontrada ou inexistente");
        if(naoEncontradas != null && !naoEncontradas.isEmpty())
        {
            System.out.println("Sala não encontrada ou inexistente:");
            for(Sala sala : naoEncontradas)
            {
                System.out.println("  " + sala.getNamePP());
            }
        }
    }

    /**
     * Teste da classe Sala
     * @param args argumentos da linha de comandos
     */
    public static void main(String[] args)
    {
        Horario horario = new Horario();

        Sala sala1 = new Sala(1, "Sala 208", 50, 10, horario);
        Sala sala2 = new Sala(2, "Sala 106", 60, 15, horario);
        Sala sala3 = new Sala(3, "Sala 305", 40, 8, horario);
        Sala sala4 = new Sala(4, "Sala 107", 55, 12, horario);
        Sala sala5= new Sala(5, "Sala 404", 70, 20, horario);

        ArrayList<Sala> listaSalas = new ArrayList<>();
        listaSalas.add(sala1);
        listaSalas.add(sala2);
        listaSalas.add(sala3);
        listaSalas.add(sala4);
        listaSalas.add(sala5);

        mostrarSalasPorPisoOrdenadas(listaSalas);
        System.out.println();

        // Ordenar por capacidade (decrescente)
        List<Sala> ordenadasPorCapacidade = Sala.ordenarPorCapacidadeDesc(listaSalas);

        System.out.println("Salas ordenadas por capacidade (decrescente):");
        for (Sala sala : ordenadasPorCapacidade) {
            System.out.println(sala.getNamePP() + " - Capacidade: " + sala.getCapacity());
        }
        System.out.println();

        // Ordenar por tomadas (decrescente)
        List<Sala> ordenadas = Sala.ordenarPorTomadasDesc(listaSalas);

        System.out.println("Salas ordenadas por tomadas (decrescente):");
        for (Sala sala : ordenadas) {
            System.out.println(sala.getNamePP() + " - Tomadas: " + sala.getOutlets());
        }
        System.out.println();

        System.out.println("Nome da sala: " + sala2.getNamePP());
        System.out.println("Capacidade: " + sala2.getCapacity());
        System.out.println("Tomadas: " + sala2.getOutlets());
        System.out.println("ID: " + sala2.getId());


        sala2.setNamePP("Sala 106");
        sala2.setCapacity(60);
        sala2.setOutlets(15);
        sala2.setId(2);

        // Verificar as alterações
        System.out.println("\nApós alterações:");
        System.out.println("Nome da sala: " + sala2.getNamePP());
        System.out.println("Capacidade: " + sala2.getCapacity());
        System.out.println("Tomadas: " + sala2.getOutlets());
        System.out.println("ID: " + sala2.getId());

        System.out.println(sala2);
    }
}