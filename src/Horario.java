import java.util.ArrayList;

import edu.princeton.cs.algs4.RedBlackBST;

public class Horario {
    private RedBlackBST<Hora, Aula> aulas;

    public Horario() {
        this.aulas = new RedBlackBST();
    }

    public void adicionarAula(Aula aula) {
        aulas.put(aula.getStartTime(), aula);
    }

    public void removerAula(Hora horaInicio) {
        aulas.delete(horaInicio);
    }

    public Aula getAula(Hora horaInicio) {
        return aulas.get(horaInicio);
    }

    public Iterable<Aula> getAllLectures() {
        ArrayList<Aula> todas = new ArrayList<>();
        for (Hora h : aulas.keys()) {
            Aula a = aulas.get(h);

            if (a != null)
                todas.add(a);
        }
        return (Iterable<Aula>) todas;
    }

    public Iterable<Hora> getAllLectureTimes() {
        return aulas.keys();
    }

    public Aula getNextAula(Hora horaAtual) {
        Hora nextHora = aulas.ceiling(horaAtual);
        return nextHora != null ? aulas.get(nextHora) : null;
    }
}