import java.io.*;
import java.util.ArrayList;

/**
 * Aluno da universidade, armazenado em Symbol Tables num objeto da classe Cadeira. Herda a classe Pessoa.
 */
public class Aluno extends Pessoa
{
    private final int numero;
    private int ano;

    public Aluno(String nome, String email, int numero, int ano, Horario horario)
    {
        super(nome, email, horario);
        this.numero = numero;
        this.ano = ano;
    }

    public void setStudentYear(int year)
    {
        this.ano = year;
    }

    public int getStudentYear()
    {
        return this.ano;
    }

    public int getStudentNumber()
    {
        return this.numero;
    }

    @Override
    public String toString()
    {
        return "Aluno " + this.getName() + "\nEmail: " + this.getEmail() + "\nNumero: " + this.numero + "\nAno: " + this.ano;
    }

    /**
     * Pesquisa para verificar em que horas um aluno pode marcar reunião com um professor (cruzar horário do aluno com o professor)
     * @param professor Professor a verificar horário de atendimento
     */
    public ArrayList<Hora> horarioParaReuniao(Professor professor)
    {
        ArrayList<Hora> horariosDisponiveis = new ArrayList<>();

        Hora horaAtendimento = professor.getHorarioAtendimentoInicio();
        while(horaAtendimento.isBefore(professor.getHorarioAtendimentoFim()))
        {
            boolean disponivel = true;

            for(Aula aulaAluno : this.getTimetable().getAllLectures())
            {
                if(!(horaAtendimento.isBefore(aulaAluno.getStartTime()) || horaAtendimento.isAfter(aulaAluno.getEndTime())))
                {
                    disponivel = false;
                    break;
                }
            }

            if(disponivel)
            {
                horariosDisponiveis.add(new Hora(horaAtendimento.getHour(), horaAtendimento.getMinute()));
            }

            // Incrementa 30 minutos
            horaAtendimento = new Hora(horaAtendimento.getHour(), horaAtendimento.getMinute() + 30);
        }

        return horariosDisponiveis;
    }

    /**
     * Teste da classe Aluno
     * @param args argumentos da linha de comandos
     */
    public static void main(String[] args)
    {
        Aluno armindo = new Aluno("armindo", "armindo@ufp.pt", 30, 2, new Horario());
        System.out.println(armindo);

        Hora meio_dia = new Hora(12, 0);
        Hora uma = new Hora(13, 0);
        Hora duas = new Hora(14, 0);
        Hora tres = new Hora(15, 0);
        Hora quatro = new Hora(16, 0);
        Hora cinco = new Hora(17, 0);
        Hora seis = new Hora(18, 0);

        Aluno jose = new Aluno("José", "jose@ufp.pt", 31, 2, new Horario());
        Professor antonio = new Professor("António", "antonio@ufp.pt", new Horario(), 3, "mestrado", duas, quatro);

        armindo.getTimetable().adicionarAula(new Aula(meio_dia, uma, new Data((short) 31, (short) 5, 2025), null, null));
        armindo.getTimetable().adicionarAula(new Aula(tres, quatro, new Data((short)31, (short)5, 2025), null, null));
        jose.getTimetable().adicionarAula(new Aula(duas, quatro, new Data((short) 31, (short) 5, 2025), null, null));

        System.out.println("Horários para Armindo (pode): " + armindo.horarioParaReuniao(antonio));
        System.out.println("Horários para José (não pode): " + jose.horarioParaReuniao(antonio));
        System.out.println();
    }
}