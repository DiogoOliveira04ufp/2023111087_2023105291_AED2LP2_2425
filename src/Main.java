import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<Aula> cenas = new ArrayList<Aula>();
        ArrayList<Cadeira> cadeiras = new ArrayList<Cadeira>();

        Horario horarioAntonio = new Horario(2, 2, cenas);
        Professor antonio = new Professor("António Pedro", "antoniopedro@ufp.pt", horarioAntonio, 243, "mestrado");

        Horario horarioDiogo = new Horario(2, 2, cenas);
        Aluno diogo = new Aluno("Diogo Oliveira", "diogooliveira@ufp.pt", 11, 2, horarioDiogo);

        System.out.println(antonio);
        System.out.println(diogo);
    }
}