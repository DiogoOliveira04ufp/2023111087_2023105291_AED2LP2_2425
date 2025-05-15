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

    public String toString()
    {
        return "Aluno " + this.getName() + "\nEmail: " + this.getEmail() + "\nNumero: " + this.numero + "\nAno: " + this.ano;
    }
}