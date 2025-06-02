/**
 * Classe genérica para os vértices dos grafos dos pisos. Não é abstrata porque pode ser um ponto que não seja uma sala ou escada.
 */
public class PontoDePassagem
{
    private int id;
    private String nome;

    public PontoDePassagem(int id, String nome)
    {
        this.id = id;
        this.nome = nome;
    }

    public int getId()
    {
        return id;
    }

    public String getNamePP()
    {
        return nome;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setNamePP(String name)
    {
        this.nome = name;
    }

    @Override
    public String toString()
    {
        return "PontoDePassagem: " + nome + " (ID: " + id + ")";
    }
}
