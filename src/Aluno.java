public class Aluno
{
    private String nome;
    private String email;
    private final int numero;
    private int ano;
    private Curso curso;
    private Cadeira[] cadeiras;
    private Horario horario;

    public Aluno(String nome, String email, int numero, int ano, Curso curso, Cadeira[] cadeiras, Horario horario)
    {
        this.nome = nome;
        this.email = email;
        this.numero = numero;
        this.ano = ano;
        this.curso = curso;
        this.cadeiras = cadeiras;
        this.horario = horario;
    }
}