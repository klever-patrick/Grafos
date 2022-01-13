package AV2.trabalho05;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class Main {
    public static void main(String[] args) {

       String caminho = "./src/AV2/trabalho05/entradas/entrada1.txt";
       Grafo grafo = new Grafo(false);
       String origemDFS = "";

       System.setProperty("org.graphstream.ui", "swing");
       Graph graph = new SingleGraph("Graph");
       graph.setStrict(false);
       graph.setAutoCreate(true);
       graph.display();

       Graph treeR = new SingleGraph("TreeR");
       treeR.setStrict(false);
       treeR.setAutoCreate(true);
       treeR.display();

       Graph treeI = new SingleGraph("TreeI");
       treeI.setStrict(false);
       treeI.setAutoCreate(true);
       treeI.display();

       File entrada = new File(caminho);
       try {
           Scanner sc = new Scanner(entrada);
           origemDFS = sc.nextLine();
           while (sc.hasNext()) {
               String[] arestas = sc.nextLine().split(" ");
               graph.addEdge(arestas[0]+arestas[1], arestas[0], arestas[1]);
               grafo.addAresta(new Vertice(arestas[0]), new Vertice(arestas[1]));
           }
           sc.close();
       } catch (IOException e) {
           System.out.println("Error: " + e.getMessage());
       }

        File arquivo = new File("./src/AV2/trabalho05/saida.txt");
        try {
            FileOutputStream fos = new FileOutputStream(arquivo);
            PrintStream ps = new PrintStream(fos);
            System.setOut(ps);
            System.out.println(grafo);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        Grafo arvoreR = new Grafo(false);
        Grafo arvoreI = new Grafo(false);

        for (Map.Entry<Vertice, LinkedList<Vertice>> indice : grafo.getTabelaHash().entrySet()) {
            if (indice.getKey().getN() == (Integer.parseInt(origemDFS))) {
                Vertice v = indice.getKey();
                System.out.println("Busca em profundidade realizada de maneira iterativa a partir do vértice: " + origemDFS);
                grafo.dfsIterativa(v);
                System.out.println("\nBusca em profundidade realizada de maneira recursiva a partir do vértice: " + origemDFS);
                Set<Vertice> visitados = new HashSet<Vertice>();
                grafo.dfsRecursiva(v, visitados);

                System.out.println("\n" + "Árvore gerada pela busca em profundidade recursiva: ");
                HashSet<Vertice> visitados1 = new HashSet<Vertice>();
                grafo.recursiveDfs(v, visitados1, arvoreR);
                System.out.println(arvoreR);
                System.out.println("Árvore gerada pela busca em profundidade iterativa: ");
                grafo.iterativeDfs(v, arvoreI);
                System.out.println(arvoreI);
                break;
            }
        }

        for (Map.Entry<Vertice, LinkedList<Vertice>> indice : arvoreR.getTabelaHash().entrySet()) {
            for (Vertice v : indice.getValue()) {
                treeR.addEdge(indice.getKey().getNome() + v.getNome(), indice.getKey().getNome(), v.getNome());
            }
        }
        for (Map.Entry<Vertice, LinkedList<Vertice>> indice : arvoreR.getTabelaHash().entrySet()) {
            for (Vertice v : indice.getValue()) {
                treeI.addEdge(indice.getKey().getNome() + v.getNome(), indice.getKey().getNome(), v.getNome());
            }
        }

        String style = "graph { padding: 50px; } node { size-mode: fit; shape: rounded-box; fill-color: white; stroke-mode: plain; padding: 3px, 2px; text-size: 50px; size: 700px; }";
        graph.setAttribute("ui.stylesheet", style);
        treeR.setAttribute("ui.stylesheet", style);
        treeI.setAttribute("ui.stylesheet", style);
        for (Node node : graph) {
            node.setAttribute("ui.label", node.getId());
        }
        for (Node node : treeR) {
            node.setAttribute("ui.label", node.getId());
        }
        for (Node node : treeI) {
            node.setAttribute("ui.label", node.getId());
        }
    }
}
