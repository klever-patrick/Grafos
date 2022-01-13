package AV3.trabalho07;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class Main {
    public static void main (String[] args) {
        String caminho = "./src/AV3/trabalho07/entradas/entrada2.txt";
        int origem = 0;
        List<Aresta> listaArestas = new ArrayList<Aresta>();
        File entrada = new File(caminho);
        try {
            Scanner sc = new Scanner(entrada);
            origem = Integer.parseInt(sc.nextLine());
            while (sc.hasNext()) {
                String[] arrayLinha = sc.nextLine().split(" ");
                int comeco = Integer.parseInt(arrayLinha[0]);
                int destino = Integer.parseInt(arrayLinha[1]);
                int custo = Integer.parseInt(arrayLinha[2]);
                listaArestas.add(new Aresta(comeco, destino, custo));
            }
            sc.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        File arquivo = new File("./src/AV3/trabalho07/saida.txt");
        try {
            FileOutputStream fos = new FileOutputStream(arquivo);
            PrintStream ps = new PrintStream(fos);
            System.setOut(ps);
            Set<Integer> qtdVertices = new HashSet<>();
            for (Aresta a : listaArestas) {
                qtdVertices.add(a.origem);
                qtdVertices.add(a.destino);
            }
            Grafo grafo = new Grafo(qtdVertices.size(), listaArestas);
            grafo.bellmanFord(origem);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
