/**
 * Classe que será utilizada na classe Horario, apenas para ser uma célula da tabela. Terá objetos das classes Hora, Data, Sala e Cadeira.
 */
public class Aula
{
    private Hora start_time;
    private Hora end_time;
    private Data data_aula;
    private Sala sala;
    private Cadeira cadeira;

    public Aula(Hora start_time, Hora end_time, Data data, Sala sala, Cadeira cadeira)
    {
        this.start_time = start_time;
        this.end_time = end_time;
        this.data_aula = data;
        this.sala = sala;
        this.cadeira = cadeira;
    }

    public Hora getStartTime()
    {
        return start_time;
    }

    public void setStartTime(Hora start_time)
    {
        this.start_time = start_time;
    }

    public Hora getEndTime()
    {
        return end_time;
    }

    public void setEndTime(Hora end_time)
    {
        this.end_time = end_time;
    }

    public Data getClassDate()
    {
        return data_aula;
    }

    public void setWeekDay(Data date)
    {
        this.data_aula = date;
    }

    public Sala getRoom()
    {
        return sala;
    }

    public void setRoom(Sala sala)
    {
        this.sala = sala;
    }

    public Cadeira getLectureClass()
    {
        return cadeira;
    }

    public void setLectureClass(Cadeira cadeira)
    {
        this.cadeira = cadeira;
    }

}