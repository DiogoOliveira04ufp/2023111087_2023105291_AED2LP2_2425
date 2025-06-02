import java.util.ArrayList;

import edu.princeton.cs.algs4.RedBlackBST;

/**
 * Classe para representar os horários; ou de uma pessoa, ou de uma sala. Utiliza uma Red Black BST para armazenar as Aulas.
 */
public class Horario
{
    private RedBlackBST<Hora, Aula> aulas;

    public Horario()
    {
        this.aulas = new RedBlackBST();
    }

    public void adicionarAula(Aula aula)
    {
        aulas.put(aula.getStartTime(), aula);
    }

    public void removerAula(Hora horaInicio)
    {
        aulas.delete(horaInicio);
    }

    public Aula getAula(Hora horaInicio)
    {
        return aulas.get(horaInicio);
    }

    public Iterable<Aula> getAllLectures()
    {
        ArrayList<Aula> todas = new ArrayList<>();
        for (Hora h : aulas.keys())
        {
            Aula a = aulas.get(h);

            if (a != null)
                todas.add(a);
        }
        return (Iterable<Aula>)todas;
    }

    public Iterable<Hora> getAllLectureTimes() {
        return aulas.keys();
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Horário:\n");
        for(Hora hora : aulas.keys())
        {
            Aula aula = aulas.get(hora);
            sb.append(hora).append(" - ").append(aula).append("\n");
        }
        return sb.toString();
    }

    /**
     * Retornar aula imediatamente a seguir à hora dada
     * @param horaAtual hora a partir da qual fazer a pesquisa
     * @return proxima aula
     */
    public Aula getNextAula(Hora horaAtual) {
        Hora nextHora = aulas.ceiling(horaAtual);
        return nextHora != null ? aulas.get(nextHora) : null;
    }

    /**
     * Teste da classe Horario
     * @param args argumentos da linha de comandos
     */
    public static void main(String[] args)
    {
        Hora nove = new Hora(9, 0);
        Hora dez = new Hora(10, 0);
        Hora onze = new Hora(11, 0);

        Aula aula1 = new Aula(nove, dez, new Data((short)1, (short)6, 2025), null, null);
        Aula aula2 = new Aula(dez, onze, new Data((short)1, (short)6, 2025), null, null);

        // Criar um Horario e adicionar aulas
        Horario horario = new Horario();
        horario.adicionarAula(aula1);
        horario.adicionarAula(aula2);

        // Exibir todas as aulas
        System.out.println("Aulas no horário:");
        System.out.println(horario);

        // Buscar uma aula específica
        System.out.println("Aula às 9:00:");
        System.out.println(horario.getAula(nove));

        // Remover uma aula
        horario.removerAula(nove);
        System.out.println("Aulas após remover a aula das 9:00:");
        System.out.println(horario);

        // Buscar a próxima aula
        System.out.println("Próxima aula após 9:30:");
        System.out.println(horario.getNextAula(new Hora(9, 30)));
    }
}
