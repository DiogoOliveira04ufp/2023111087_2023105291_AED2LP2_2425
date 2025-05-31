/*
 * Classe feita em LP no package p01_intro
 */

public class Data
{
    private short day;
    private short month;
    private int year;

    public Data(short day, short month, int year)
    {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Data()
    {
        this.day = (short)3;
        this.month = (short)4;
        this.year = 2025;
    }

    public short getDay()
    {
        return this.day;
    }

    public short getMonth()
    {
        return this.month;
    }

    public int getYear()
    {
        return this.year;
    }

    @Override
    public String toString()
    {
        return day + "/" + month + "/" + year;
    }

    /**
     * Verifica se uma data é depois da data que utiliza este mét0do
     * @param d data a comparar
     */
    public boolean afterDate(Data d)
    {
        if(d.year > this.year)
            return true;
        else if(d.month > this.month && d.year == this.year)
            return true;
        else if(d.day > this.day && d.month == this.month && d.year == this.year)
            return true;
        else
            return false;
    }

    /**
     * Verifica se uma data é antes da data que utiliza este mét0do
     * @param d data a comparar
     */
    public boolean beforeDate(Data d)
    {
        if(d.year < this.year)
            return true;
        else if(d.month < this.month && d.year <= this.year)
            return true;
        else if(d.day < this.day && d.month <= this.month && d.year <= this.year)
            return true;
        else
            return false;
    }

    /**
     * Incrementa a data que utiliza o mét0do
     */
    public void incrementDate()
    {
        this.day++;

        if(this.day == 32 && (this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month == 8 || this.month == 10 || this.month == 12))
        {
            this.day = 1;
            this.month++;
            if(this.month == 13)
            {
                this.month = 1;
                this.year++;
            }
        }
        else if(this.day == 31 && (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11))
        {
            this.day = 1;
            this.month++;
        }
        else if(isLeapYear(this.year) == false)
        {
            if(this.month == 2 || this.day == 29)
            {
                this.day = 1;
                this.month++;
            }
        }
        else if(isLeapYear(this.year) == true)
        {
            if(this.month == 2 || this.day == 30)
            {
                this.day = 1;
                this.month++;
            }
        }
    }

    /**
     * Retorna se o ano é bissexto ou não
     * A cada 4 anos um ano é bissexto, exceto se o ano for um novo século (ex.: 1900). No entanto, se o ano do novo século for divisível por 400, já é bissexto
     * @param year a verificar
     */
    public static boolean isLeapYear(int year)
    {
        if(year % 4 == 0)
        {
            // novos séculos não são anos bissextos mas quando são divisíveis por 400 são
            // (ex.: 1900 não é ano bissexto mas 2000 é)
            if(year % 100 == 0 && year % 400 != 0)
                return false;
            else
                return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Retorna quantos dias um mês de um ano tem
     * ex.: fevereiro 2024 -> 29 | fevereiro 2025 -> 28 | março 2025 -> 31 | abril 2025 -> 30
     * @param month mês a comparar
     * @param year ano do mês
     */
    public static int daysMonth(short month, int year)
    {
        if(month == 2 && isLeapYear(year) == true)
            return 29;
        else if(month == 2 && isLeapYear(year) == false)
            return 28;
        else if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            return 31;
        else
            return 30;
    }

    /**
     * Teste da classe data
     * @param args arumentos da linha de comandos
     */
    public static void main(String[] args)
    {
        Data data1 = new Data();
        Data data2 = new Data((short)21, (short)5, 2025);

        System.out.println("beforeDate()");
        System.out.println("data1 -> data2: " + data1.beforeDate(data2));
        System.out.println("data2 -> data1: " + data2.beforeDate(data1));
        System.out.print("\n");

        System.out.println("afterDate()");
        System.out.println("data1 -> data2: " + data1.afterDate(data2));
        System.out.println("data2 -> data1: " + data2.afterDate(data1));
        System.out.print("\n");

        System.out.println("incrementDate()");
        System.out.println(data1);
        data1.incrementDate();
        System.out.println(data1);
        System.out.print("\n");

        System.out.println("isLeapYear()");
        System.out.println("2025: " + isLeapYear(2025));
        System.out.println("2024: " + isLeapYear(2024));
        System.out.println("1900: " + isLeapYear(1900));
        System.out.println("2000: " + isLeapYear(2000));
        System.out.print("\n");

        System.out.println("daysMonth()");
        System.out.println("fevereiro 2024: " + daysMonth((short)2, 2024));
        System.out.println("fevereiro 2025: " + daysMonth((short)2, 2025));
        System.out.println("março 2025: " + daysMonth((short)3, 2025));
        System.out.println("junho 2025: " + daysMonth((short)6, 2025));
    }
}
