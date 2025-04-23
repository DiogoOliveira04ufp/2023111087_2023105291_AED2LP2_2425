import edu.princeton.cs.algs4.ST;

import java.util.ArrayList;

public class Professor extends Pessoa
{
    private final int numero;
    private String qualificacao;

    public Professor(String nome, String email, ArrayList<Cadeira> cadeiras, Horario horario, int numero, String qualificacao)
    {
        super(nome, email, horario, cadeiras);
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
}
