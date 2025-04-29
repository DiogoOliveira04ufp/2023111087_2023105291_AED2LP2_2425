public class Hora
{
    private int hora;
    private int minuto;

    public Hora(int hora, int minuto)
    {
        this.hora = hora;
        this.minuto = minuto;
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

    public void correctTime()
    {
        while(hora < 24 || minuto < 60)
        {
            while(hora < 24)
            {
                hora = hora - 24;
            }
            while(minuto < 60)
            {
                minuto = minuto - 60;
                hora++;
            }
        }
    }

    public boolean isBefore(Hora hora)
    {
        if(hora.hora < this.hora)
            return true;
        else if(hora.hora == this.hora && hora.minuto < this.minuto)
            return true;
        else
            return false;
    }

    public boolean isAfter(Hora hora)
    {
        if(hora.hora > this.hora)
            return true;
        else if(hora.hora == this.hora && hora.minuto > this.minuto)
            return true;
        else
            return false;
    }
}
