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

    /**
     * Receber a lista de salas livres num determinado horário
     * @param horaInicio hora onde o horário a pesquisar começa
     * @param horaFim hora onde o horário a pesquisar acaba
     */
    public ArrayList<Sala> verSalasHorario(Hora horaInicio, Hora horaFim, ArrayList<Piso> pisos)
    {
        ArrayList<Sala> salasLivres = new ArrayList<>();

        for(Piso piso : pisos)
        {
            for(Sala sala : piso.getRooms())
            {
                boolean salaLivre = true;

                for(Aula aula : sala.getTimetable().getTTLectures())
                {
                    if(aula.getStartTime().isAfter(horaInicio) && aula.getEndTime().isBefore(horaFim))
                    {
                        salaLivre = false;
                        break;
                    }
                }

                if(salaLivre)
                {
                    salasLivres.add(sala);
                }
            }
        }

        return salasLivres;
    }

    /**
     * Receber a lista de alunos de um professor
     * @param cursos cursos da universidade onde se irá pesquisar os alunos
     */
    public ArrayList<Aluno> verAlunosProfessor(ArrayList<Curso> cursos)
    {
        ArrayList<Aluno> alunos = new ArrayList<>();

        for(Curso curso : cursos)
        {
            for(Cadeira cadeira: curso.getCourseClasses())
            {
                if(cadeira.getClassProfessors().contains(this))
                {
                    alunos.addAll(cadeira.getClassStudents());
                }
            }
        }

        return alunos;
    }
}
