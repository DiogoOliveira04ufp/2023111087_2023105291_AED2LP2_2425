import edu.princeton.cs.algs4.ST;

public class Cadeira
{
    private String nome;
    private int year;
    private ST<Integer, Professor> professores;
    private ST<Integer, Aluno> students;

    public Cadeira(String nome, int ano, ST<Integer, Professor> professores, ST<Integer, Aluno> alunos)
    {
        this.nome = nome;
        this.year = ano;
        this.professores = professores;
        this.students = alunos;
    }

    public void setClassName(String name)
    {
        this.nome = name;
    }

    public void setClassYear(int year)
    {
        this.year = year;
    }

    public void setClassProfessors(ST<Integer, Professor> professors)
    {
        this.professores = professors;
    }

    public void setClassStudents(ST<Integer, Aluno> students)
    {
        this.students = students;
    }

    public String getClassName()
    {
        return this.nome;
    }

    public int getClassYear()
    {
        return this.year;
    }

    public ST<Integer, Professor> getClassProfessors()
    {
        return this.professores;
    }

    public ST<Integer, Aluno> getClassStudents()
    {
        return this.students;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("Cadeira: ").append(nome).append("\n");
        sb.append("Ano: ").append(year).append("\n");
        sb.append("Lista de Professores:\n");

        for(Integer key : professores.keys())
        {
            sb.append(" - ").append(professores.get(key)).append("\n");
        }
        sb.append("Lista de Alunos:\n");
        for(Integer key : students.keys())
        {
            sb.append(" - ").append(students.get(key)).append("\n");
        }

        return sb.toString();
    }

    public void inserirAluno(Aluno aluno)
    {
        this.students.put(aluno.getStudentNumber(), aluno);
    }

    public void inserirProfessor(Professor professor)
    {
        this.professores.put(professor.getProfNumber(), professor);
    }
}