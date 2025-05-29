import java.util.ArrayList;
import java.util.List;

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

    public int getStudentNumber()
    {
        return this.numero;
    }

    @Override
    public String toString()
    {
        return "Aluno " + this.getName() + "\nEmail: " + this.getEmail() + "\nNumero: " + this.numero + "\nAno: " + this.ano;
    }

    public ArrayList<Hora> horarioParaReuniao(Professor professor)
    {
        ArrayList<Hora> horariosDisponiveis = new ArrayList<>();

        for(Hora horaAluno : this.getTimetable().getAllHoras())
        {
            boolean disponivel = true;

            for(Hora horaProfessor : professor.getTimetable().getAllHoras())
            {
                Aula aulaProfessor = professor.getTimetable().getAula(horaProfessor);

                if(!(horaAluno.isBefore(aulaProfessor.getStartTime()) || horaAluno.isAfter(aulaProfessor.getEndTime())))
                {
                    disponivel = false;
                    break;
                }
            }

            if(disponivel)
            {
                horariosDisponiveis.add(horaAluno);
            }
        }

        return horariosDisponiveis;
    }

    public static void main(String[] args)
    {
        //ArrayList<Aula> aulas = new ArrayList<>();
        Horario horario = new Horario();

        Aluno armindo = new Aluno("armindo", "armindo@ufp.pt", 30, 2, horario);

        System.out.println(armindo);
    }
}