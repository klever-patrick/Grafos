package AV3.trabalho06;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        String caminho = "./src/AV3/trabalho06/entradas/entrada2.txt";
        Grafo grafo = new Grafo(true);
        String origem = "";

        File entrada = new File(caminho);
        try {
            Scanner sc = new Scanner(entrada);
            origem = sc.nextLine();
            while (sc.hasNext()) {
                String[] arrayLinha = sc.nextLine().split(" ");
                if (grafo.getVertices().contains(new Vertice(arrayLinha[0]))) {
                    for (Vertice v : grafo.getVertices()) {
                        if (v.equals(new Vertice(arrayLinha[0]))) {
                            grafo.addAresta(v, new Vertice(arrayLinha[1]), Double.parseDouble(arrayLinha[2]));
                            break;
                        }
                    }
                } else if (grafo.getVertices().contains(new Vertice(arrayLinha[1]))) {
                    for (Vertice v : grafo.getVertices()) {
                        if (v.equals(new Vertice(arrayLinha[1]))) {
                            grafo.addAresta(new Vertice(arrayLinha[0]), v, Double.parseDouble(arrayLinha[2]));
                            break;
                        }
                    }
                } else {
                    grafo.addAresta(new Vertice(arrayLinha[0]), new Vertice(arrayLinha[1]), Double.parseDouble(arrayLinha[2]));
                }
            }
            sc.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        File arquivo = new File("./src/AV3/trabalho06/saida.txt");
        try {
            FileOutputStream fos = new FileOutputStream(arquivo);
            PrintStream ps = new PrintStream(fos);
            System.setOut(ps);
            Set<Vertice> visitados = new HashSet<>();
            Vertice comeco = new Vertice(origem);
            Vertice inicio = null;
            for (Vertice v : grafo.getVertices()) {
                if (comeco.equals(v)) {
                    inicio = v;
                }
            }
            for (Vertice v : grafo.getVertices()) {
                if (!v.equals(inicio)) {
                    grafo.resetarVerticesVisitados(visitados);
                    grafo.dijkstra(inicio, v, visitados);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
