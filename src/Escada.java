public class Escada extends PontoDePassagem
{
    private int pisoOrigem;
    private int pisoDestino;

    public Escada(int id, String nome, int pisoOrigem, int pisoDestino)
    {
        super(id, nome);
        this.pisoOrigem = pisoOrigem;
        this.pisoDestino = pisoDestino;
    }

    public int getPisoOrigem()
    {
        return pisoOrigem;
    }

    public void setPisoOrigem(int pisoOrigem)
    {
        this.pisoOrigem = pisoOrigem;
    }

    public int getPisoDestino()
    {
        return pisoDestino;
    }

    public void setPisoDestino(int pisoDestino)
    {
        this.pisoDestino = pisoDestino;
    }

    @Override
    public String toString()
    {
        return "Escada: " + getNamePP() + "\nOrigem: Piso " + pisoOrigem + "\nDestino: Piso " + pisoDestino;
    }
}
