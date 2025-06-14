import static java.lang.Integer.parseInt;

/**
 * Classe feita por nós para utilizar horas de uma maneira mais simples.
 */
public class Hora implements Comparable<Hora>
{
    private int hora;
    private int minuto;

    public Hora(int hora, int minuto)
    {
        this.hora = hora;
        this.minuto = minuto;
        this.correctTime();
    }

    public Hora(String hora)
    {
        String[] hora_minutos = hora.split(":");
        this.hora = parseInt(hora_minutos[0]);
        this.minuto = parseInt(hora_minutos[1]);
        this.correctTime();
    }

    public int getHour()
    {
        return this.hora;
    }

    public int getMinute()
    {
        return this.minuto;
    }

    public void setHour(int hour)
    {
        this.hora = hour;
        this.correctTime();
    }

    public void setMinute(int minute)
    {
        this.minuto = minute;
        this.correctTime();
    }

    @Override
    public String toString()
    {
        if(minuto >= 10)
        {
            return hora + ":" + minuto;
        }
        else
        {
            return hora + ":0" + minuto;
        }
    }

    @Override
    public int compareTo(Hora outraHora)
    {
        if (this.hora != outraHora.hora)
        {
            return this.hora - outraHora.hora;
        }
        return this.minuto - outraHora.minuto;
    }

    /**
     * Corrige a hora caso os valores de hora ou minuto estejam fora dos limites permitidos.
     * Ajusta a hora para o intervalo de 0 a 24 e os minutos para o intervalo de 0 a 60.
     */
    public void correctTime()
    {
        while(hora >= 24 || minuto >= 60)
        {
            while(hora >= 24)
            {
                hora = hora - 24;
            }
            while(minuto >= 60)
            {
                minuto = minuto - 60;
                hora++;
            }
        }
    }

    /**
     * Verifica se uma dada hora está antes desta hora.
     * @param hora a hora a comparar
     */
    public boolean isBefore(Hora hora)
    {
        if(this.hora < hora.hora)
            return true;
        else if(this.hora == hora.hora && this.minuto < hora.minuto)
            return true;
        else
            return false;
    }

    /**
     * Verifica se uma dada hora está depois desta hora.
     * @param hora a hora a comparar
     */
    public boolean isAfter(Hora hora)
    {
        if(this.hora > hora.hora)
            return true;
        else if(this.hora == hora.hora && this.minuto > hora.minuto)
            return true;
        else
            return false;
    }
}