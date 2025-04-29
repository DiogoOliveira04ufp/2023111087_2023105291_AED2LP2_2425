import edu.princeton.cs.algs4.ST;

import java.util.ArrayList;

public class Professor extends Pessoa
{
    private final int numero;
    private String qualificacao;

    public Professor(Universidade universidade, String nome, String email, ArrayList<Cadeira> cadeiras, Horario horario, int numero, String qualificacao)
    {
        super(universidade, nome, email, horario, cadeiras);
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


    public ArrayList<Sala> verSalasHorario(int horaInicio, int horaFim)
    {
        ArrayList<Sala> salas;

        for(Piso piso : this.getUni().getUniFloors())
        {
            for(Sala sala : piso.getRooms())
            {
                for(Aula aula : sala.getTimetable().getTTLectures())
                {
                    ArrayList<Aula> aulasSala;
                    if(aula.getEndTime())
                }
            }
        }

        return salas;
    }
}
