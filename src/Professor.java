import java.util.ArrayList;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.ST;

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
        return this.horario_atendimento_inicio;
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
     * @return ArrayList das salas disponíveis
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
                    System.out.println("Verificando sala: " + sala.getNamePP());

                    for(Aula aula : sala.getTimetable().getAllLectures())
                    {
                        System.out.println("Aula: " + aula.getStartTime() + " - " + aula.getEndTime());
                        System.out.println("Intervalo: " + horaInicio + " - " + horaFim);
                        System.out.println("Sobreposição: " + !(aula.getEndTime().isBefore(horaInicio) || aula.getStartTime().isAfter(horaFim)) + "\n\n");
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
     * @return todos os alunos do professor
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

    /**
     * Teste da classe Professor
     * @param args argumentos da linha de comandos
     */
    public static void main(String[] args)
    {
        Horario horario = new Horario();
        Hora duas = new Hora(14, 0);
        Hora tres = new Hora(15, 0);
        Hora quatro = new Hora(16, 0);
        Hora cinco = new Hora (17, 0);
        Hora seis = new Hora(18, 0);

        //--------------------------------------------------------------------- TESTE DOS CONSTRUTORES ---------------------------------------------------------------------
        ArrayList<Professor>professores = new ArrayList<>();
        Professor Jsilva = new Professor("João Silva", "jsilva@ufp.pt", horario, 12345, "Doutoramento", duas, seis);
        professores.add(Jsilva);
        System.out.println(Jsilva);
        System.out.print("\n");
        Professor prof = new Professor("João", "joao@uni.pt", horario, 101, "Mestre", duas, tres);
        professores.add(prof);
        System.out.println(prof);
        System.out.print("\n");

        Professor professora1 = new Professor("Ana Costa", "Acufp.pt", horario, 67890, "Mestrado", tres, cinco);
        System.out.println(professora1);
        System.out.print("\n");

        // -------------------------------------------------------------------- verAlunosProfessor() --------------------------------------------------------------------
        System.out.println("------------------------- verAlunosProfessor() -------------------------");
        ArrayList<Aluno>alunos = new ArrayList<>();
        Aluno aluno1 = new Aluno("Carlos", "carlos@uni.pt",202410 ,2, horario);
        alunos.add(aluno1);
        Aluno aluno2 = new Aluno("Maria", "maria@uni.pt",202411, 2, horario);
        alunos.add(aluno2);


        Cadeira cadeira1 = new Cadeira("SO",2, new ST<Integer, Professor>(), new ST<Integer, Aluno>());
        Cadeira cadeira2 = new Cadeira("BD",2, new ST<Integer, Professor>(), new ST<Integer, Aluno>());

        for(Aluno aluno : alunos)
        {
            cadeira1.inserirAluno(aluno);
            cadeira2.inserirAluno(aluno);
        }
        for(Professor professor : professores)
        {
            cadeira1.inserirProfessor(professor);
        }
        cadeira2.inserirProfessor(professora1);

        ArrayList<Cadeira> cadeiras = new ArrayList<>();
        cadeiras.add(cadeira1);
        cadeiras.add(cadeira2);

        Curso curso = new Curso("Engenharia",2, cadeiras, professores.get(0));

        ArrayList<Curso> cursos = new ArrayList<>();
        cursos.add(curso);

        ArrayList<Aluno> resultado = prof.verAlunosProfessor(cursos);

        System.out.println("Resultado de verAlunosProfessor(): ");
        System.out.println(resultado);

        // ---------------------------------------------------- verSalasHorarios() -----------------------------------------------
        System.out.println("------------------------- verSalasHorario() -------------------------");

        // Criar horários e aulas
        Horario horarioSala1 = new Horario();
        Horario horarioSala2 = new Horario();

        Aula aula1 = new Aula(new Hora(14, 0), new Hora(15, 0), new Data((short)30, (short)5, 2025), null, null);
        Aula aula2 = new Aula(new Hora(16, 0), new Hora(17, 0), new Data((short)30, (short)5, 2025), null, null);
        Aula aula3 = new Aula(new Hora(15, 15), new Hora(15, 45), null, null, cadeira1);

        horarioSala1.adicionarAula(aula1);
        horarioSala2.adicionarAula(aula2);
        horarioSala2.adicionarAula(aula3);

        // Criar salas
        Sala sala1 = new Sala(1, "Sala 101", 30, 5, horarioSala1);
        Sala sala2 = new Sala(2, "Sala 102", 40, 6, horarioSala2);
        Sala sala3 = new Sala(3, "Sala 103", 50, 8, new Horario()); // Sala sem aulas

        // Adicionar salas a um piso
        ArrayList<PontoDePassagem> pontos = new ArrayList<>();
        pontos.add(sala1);
        pontos.add(sala2);
        pontos.add(sala3);

        Piso piso = new Piso(1, pontos);
        ArrayList<Piso> pisos = new ArrayList<>();
        pisos.add(piso);

        // Verificar salas livres entre 15:00 e 16:00
        Hora horaInicio = new Hora(15, 0);
        Hora horaFim = new Hora(16, 0);

        ArrayList<Sala> salasLivres = prof.verSalasHorario(horaInicio, horaFim, pisos);

        System.out.println("Salas livres entre " + horaInicio + " e " + horaFim + ":");
        for (Sala sala : salasLivres)
        {
            System.out.println(sala.getNamePP());
        }
    }
}
