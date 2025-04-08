public class Aula
{
    private String start_time;
    private String end_time;
    private String dia;
    private Sala sala;
    private Cadeira cadeira;

    public Aula(String start_time, String end_time, String dia, Sala sala, Cadeira cadeira)
    {
        this.start_time = start_time;
        this.end_time = end_time;
        this.dia = dia;
        this.sala = sala;
        this.cadeira = cadeira;
    }

    public String getStartTime()
    {
        return start_time;
    }

    public void setStartTime(String start_time)
    {
        this.start_time = start_time;
    }

    public String getEndTime()
    {
        return end_time;
    }

    public void setEndTime(String end_time)
    {
        this.end_time = end_time;
    }

    public String getWeekDay()
    {
        return dia;
    }

    public void setWeekDay(String week_day)
    {
        this.dia = week_day;
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