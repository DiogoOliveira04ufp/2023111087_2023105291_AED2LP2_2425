import java.util.ArrayList;
import edu.princeton.cs.algs4.ST;

public class Professor extends Pessoa
{
    private final int numero;
    private String qualificacao;

    public Professor(String nome, String email, Horario horario, int numero, String qualificacao)
    {
        super(nome, email, horario);
        this.numero = numero;
        this.qualificacao = qualificacao;
    }

    public void setQualification(String qualification)
    {
        this.qualificacao = qualification;
    }

    public int getProfNumber()
    {
        return this.numero;
    }

    public String getQualification()
    {
        return this.qualificacao;
    }

    public String toString()
    {
        return "Professor " + this.getName() + "\nEmail: " + this.getEmail() + "\nNumero: " + this.numero + "\nQualificação: " + this.qualificacao;
    }

//    /**
//     * Receber a lista de salas livres num determinado horário
//     * @param horaInicio hora onde o horário a pesquisar começa
//     * @param horaFim hora onde o horário a pesquisar acaba
//     */
//    public ArrayList<Sala> verSalasHorario(Hora horaInicio, Hora horaFim)
//    {
//        ArrayList<Sala> salasLivres = new ArrayList<>();
//        ST<Sala, Boolean> salasOcupadas = new ST<>();
//
//        // Marcar todas as salas ocupadas no horário especificado
//        for (Piso piso : this.getUni().getUniFloors())
//        {
//            for (Sala sala : piso.getRooms())
//            {
//                for (Aula aula : sala.getTimetable().getTTLectures())
//                {
//                    Hora inicioAula = aula.getStartTime();
//                    Hora fimAula = aula.getEndTime();
//
//                    if (!(fimAula.isBefore(new Hora(horaInicio, 0)) || inicioAula.isAfter(new Hora(horaFim, 0))))
//                    {
//                        salasOcupadas.put(sala, true);
//                    }
//                }
//            }
//        }
//
//        // Adicionar salas livres à lista
//        for (Piso piso : this.getUni().getUniFloors())
//        {
//            for (Sala sala : piso.getRooms())
//            {
//                if (!salasOcupadas.contains(sala))
//                {
//                    salasLivres.add(sala);
//                }
//            }
//        }
//
//        return salasLivres;
//    }
}
