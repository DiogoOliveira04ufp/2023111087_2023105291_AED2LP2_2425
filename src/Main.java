import java.util.ArrayList;

import edu.princeton.cs.algs4.*;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<Aula> cenas = new ArrayList<Aula>();
        ArrayList<Cadeira> cadeiras = new ArrayList<Cadeira>();
        ArrayList<Curso> cursos = new ArrayList<Curso>();
        ArrayList<Piso> pisos = new ArrayList<Piso>();

        Horario horarioAntonio = new Horario(2, 2, cenas);
        Professor antonio = new Professor("António Pedro", "antoniopedro@ufp.pt", horarioAntonio, 243, "mestrado");

        Horario horarioDiogo = new Horario(2, 2, cenas);
        Aluno diogo = new Aluno("Diogo Oliveira", "diogooliveira@ufp.pt", 11, 2, horarioDiogo);

        System.out.println(antonio);
        System.out.println(diogo);

        ArrayList<Aluno> alunos = new ArrayList<Aluno>();
        ArrayList<Professor> professores = new ArrayList<Professor>();
        System.out.printf("\n\n");

        alunos.add(diogo);
        professores.add(antonio);

        Universidade ufp = new Universidade("UFP", cursos, pisos);

        System.out.println(ufp);
    }
}