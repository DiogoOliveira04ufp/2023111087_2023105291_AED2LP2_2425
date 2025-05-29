import java.util.ArrayList;

public class Professor extends Pessoa
{
    private final int numero;
    private String qualificacao;
    private Hora horario_atendimento_inicio;
    private Hora horario_atendimento_fim;

    public Professor(String nome, String email, Horario horario, int numero, String qualificacao, Hora horario_atendimento_inicio, Hora horario_atendimento_fim)
    {
        super(nome, email, horario);
        this.numero = numero;
        this.qualificacao = qualificacao;
        this.horario_atendimento_inicio = horario_atendimento_inicio;
        this.horario_atendimento_fim = horario_atendimento_fim;
    }

    public void setQualification(String qualification)
    {
        this.qualificacao = qualification;
    }

    public void setHorarioAtendimento(Hora inicio, Hora fim)
    {
        this.horario_atendimento_inicio = inicio;
        this.horario_atendimento_fim = fim;
    }

    public int getProfNumber()
    {
        return this.numero;
    }

    public String getQualification()
    {
        return this.qualificacao;
    }

    public Hora getHorarioAtendimentoInicio()
    {
        return this.horario_atendimento_fim;
    }

    public Hora getHorarioAtendimentoFim()
    {
        return this.horario_atendimento_fim;
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
            for(PontoDePassagem ponto : piso.getPoints())
            {
                if(ponto instanceof Sala)
                {
                    Sala sala = (Sala) ponto;
                    boolean salaLivre = true;

                    for(Hora hora : sala.getTimetable().getAllHoras())
                    {
                        Aula aula = sala.getTimetable().getAula(hora);

                        if(!(aula.getEndTime().isBefore(horaInicio) || aula.getStartTime().isAfter(horaFim)))
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
                if(cadeira.getClassProfessors().contains(this.getProfNumber()))
                {
                    for(Integer key : cadeira.getClassStudents().keys())
                    {
                        alunos.add(cadeira.getClassStudents().get(key));
                    }
                }
            }
        }

        return alunos;
    }
}
