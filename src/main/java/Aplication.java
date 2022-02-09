import java.io.*;
import java.util.*;

public class Aplication {

    public static void main(String[] args){
        String turmaJava ="Java";
        String turmaBD = "BD";
        String pathTurmaJava = "docs/arquivos/turma"+ turmaJava;
        String pathTurmaBD = "docs/arquivos/turma"+ turmaBD;
        String pathTurmas = "docs/arquivos/turmasoutput.txt";

        ArrayList<String> listaAlunosJava = lerAlunos(pathTurmaJava+".txt", turmaJava);
        ArrayList<String> listaAlunosBD = lerAlunos(pathTurmaBD + ".txt", turmaBD);
        // lista tudo mundo junto


        escreverAlunos(listaAlunosJava,pathTurmaJava+"output.txt");
        escreverAlunos(listaAlunosBD,pathTurmaBD+"output.txt");


        listaAlunosJava.remove(0);
        listaAlunosJava.remove(listaAlunosJava.size()-1);
        listaAlunosBD.remove(0);
        listaAlunosBD.remove(listaAlunosBD.size()-1);

        ArrayList<String> listaAlunos = new ArrayList<String>(listaAlunosJava);
        listaAlunos.addAll(listaAlunosBD);
        SortedSet<String> listaAlunosOrdenada = new TreeSet<String>(listaAlunos);
        escreverAlunosOrdenada(listaAlunosOrdenada,pathTurmas);
        for (String aluno: listaAlunosJava) {
            System.out.println(aluno);

        }
        System.out.println("---");
        for (String aluno: listaAlunosBD) {
            System.out.println(aluno);

        }
        System.out.println("---");
        for (String aluno: listaAlunos) {
            System.out.println(aluno);

        }
    }
    protected static ArrayList<String> lerAlunos(String path,String turma){
        ArrayList<String> listaAlunos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path)); ){
            String linha = reader.readLine();

            listaAlunos.add(turma);
            int c = 0;
            while( linha != null ){
                listaAlunos.add(linha);
                linha = reader.readLine();
                c++;
            }

            listaAlunos.add("Total de Aluno é: "+ c);

        } catch (FileNotFoundException e) {
            System.out.println("Erro ao buscar arquivo : " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaAlunos;
    }
    protected static void escreverAlunos(ArrayList<String> lista, String path){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {

            lista.forEach( item -> {
                        try {
                            writer.append(item);
                            writer.newLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
            );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected static void escreverAlunosOrdenada(SortedSet<String> lista, String path){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.append("Lista Escola Ordenada as Duas Turmas");
            writer.newLine();
            lista.forEach( item -> {
                        try {
                            writer.append(item);
                            writer.newLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
            );

            writer.append(String.valueOf(lista.size()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
