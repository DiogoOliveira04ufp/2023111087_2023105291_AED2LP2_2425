import java.io.*;

import edu.princeton.cs.algs4.ST;

/**
 * Classe para representar cadeiras (unidades curriculares) de um dado curso. As Symbol Tables dos alunos e professores estarão aqui armazenadas.
 */
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

    public void escreverFicheiroCadeira(String file_path)
    {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file_path, false)))
        {
            writer.write("Cadeira;" + this.nome + ";" + this.year);
            writer.newLine();
            for(Integer key : professores.keys())
            {
                Professor p = professores.get(key);
                writer.write("Professor;" + p.getProfNumber() + ";" + p.getName() + ";" + p.getEmail() + ";" + p.getQualification());
                writer.newLine();
            }
            for(Integer key : students.keys())
            {
                Aluno a = students.get(key);
                writer.write("Aluno;" + a.getStudentNumber() + ";" + a.getName() + ";" + a.getEmail() + ";" + a.getStudentYear());
                writer.newLine();
            }
            writer.write("FIM_CADEIRA");
            writer.newLine();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void lerFicheirosCadeira(String file_path)
    {
        try(BufferedReader reader = new BufferedReader(new FileReader(file_path)))
        {
            String linha;
            while((linha = reader.readLine()) != null)
            {
                String[] dados = linha.split(";");
                switch(dados[0])
                {
                    case "Cadeira":
                        this.nome = dados[1];
                        this.year = Integer.parseInt(dados[2]);
                        break;
                    case "Professor":
                        int profNum = Integer.parseInt(dados[1]);
                        String profNome = dados[2];
                        String profEmail = dados[3];
                        String qualificacao = dados[4];
                        Professor p = new Professor(profNome, profEmail, null, profNum, qualificacao, null, null);
                        this.professores.put(profNum, p);
                        break;
                    case "Aluno":
                        int alunoNum = Integer.parseInt(dados[1]);
                        String alunoNome = dados[2];
                        String alunoEmail = dados[3];
                        int ano = this.year; // ou Integer.parseInt(dados[4]);
                        Aluno a = new Aluno(alunoNome, alunoEmail, alunoNum, ano, null);
                        this.students.put(alunoNum, a);
                        break;
                    case "FIM_CADEIRA":
                        return;
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Inserir aluno na symbol table dos alunos
     * @param aluno aluno a inserir
     */
    public void inserirAluno(Aluno aluno)
    {
        this.students.put(aluno.getStudentNumber(), aluno);
    }

    /**
     * Encontrar aluno na symbol table e removê-lo
     * @param aluno aluno a remover
     */
    public void removerAluno(Aluno aluno)
    {
        this.students.delete(aluno.getStudentNumber());
    }

    /**
     * Inserir professor na symbol table dos professores
     * @param professor professor a inserir
     */
    public void inserirProfessor(Professor professor)
    {
        this.professores.put(professor.getProfNumber(), professor);
    }

    /**
     * Encontrar professor na symbol table dos professores
     * @param professor professor a remover
     */
    public void removerProfessor(Professor professor)
    {
        this.professores.delete(professor.getProfNumber());
    }

    /**
     * Teste da classe Cadeira
     * @param args argumentos da linha de comandos
     */
    public static void main(String[] args)
    {
        Cadeira lp2 = new Cadeira("Linguagens de Programação II", 2, new ST<Integer, Professor>(), new ST<Integer, Aluno>());
        Cadeira aed2 = new Cadeira("Algoritmos e Estruturas de Dados II", 2, new ST<Integer, Professor>(), new ST<Integer, Aluno>());

        Professor rui = new Professor("Rui Silva Moreira", "rmoreira@ufp.edu.pt", null, 1, "mestrado", null, null);
        Professor viana = new Professor("João Viana", "jviana@ufp.edu.pt", null,2, "mestrado", null, null);
        Professor torres = new Professor("José Manuel Torres", "jtorres@ufp.edu.pt", null, 3, "mestrado", null, null);
        Professor celio = new Professor("Célio Carvalho", "celio.carvalho@ufp.edu.pt", null, 4, "mestrado", null, null);

        lp2.inserirProfessor(rui);
        lp2.inserirProfessor(viana);
        aed2.inserirProfessor(torres);
        aed2.inserirProfessor(celio);

        Aluno diogo = new Aluno("Diogo Oliveira", "2023111087@ufp.edu.pt", 2023111087, 2, null);
        Aluno joao = new Aluno("João Nascimento", "2023105291@ufp.edu.pt", 2023105291, 2, null);

        lp2.inserirAluno(diogo);
        lp2.inserirAluno(joao);
        aed2.inserirAluno(diogo);
        aed2.inserirAluno(joao);

        System.out.println("Escrita de ficheiros");
        lp2.escreverFicheiroCadeira("teste.txt");
        Cadeira teste = new Cadeira("", 0, new ST<>(), new ST<>());
        teste.lerFicheirosCadeira("teste.txt");
        System.out.println(teste);
        System.out.println("----------------------------------------------------------------");
        System.out.println();

        System.out.println("Cadeiras antes de remover os dados");
        System.out.println(lp2);
        System.out.print("\n");
        System.out.println(aed2);
        System.out.print("\n");

        lp2.removerAluno(diogo);
        lp2.removerAluno(joao);
        aed2.removerAluno(diogo);
        aed2.removerAluno(joao);

        lp2.removerProfessor(rui);
        lp2.removerProfessor(viana);
        aed2.removerProfessor(torres);
        aed2.removerProfessor(celio);

        System.out.println("Cadeiras depois de remover os dados");
        System.out.println(lp2);
        System.out.print("\n");
        System.out.println(aed2);
    }
}