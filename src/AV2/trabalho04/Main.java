package AV2.trabalho04;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Map;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

public class Main {

    public static void escrever(String caminho, String texto) {
        try {
            FileWriter output = new FileWriter(caminho);
            PrintWriter arquivo = new PrintWriter(output);
            arquivo.println(texto);
            arquivo.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        String caminho = "./src/AV2/trabalho04/entrada.txt";
        Grafo grafo = new Grafo(false);
        String origemBFS = "";

        System.setProperty("org.graphstream.ui", "swing");
        Graph graph = new SingleGraph("Graph");
        graph.setStrict(false);
        graph.setAutoCreate(true);
        graph.display();

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha = br.readLine();
            String[] primeiraLinha = linha.split(" ");
            origemBFS = primeiraLinha[0];
            linha = br.readLine();

            while (linha != null) {
                String[] array = linha.split(" ");
                String inicio = array[0];
                String fim = array[1];
                graph.addEdge(inicio + fim, inicio, fim);
                grafo.addAresta(new Vertice(inicio), new Vertice(fim));
                linha = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        Vertice raiz = new Vertice(origemBFS);
        LinkedList<Vertice> nos = new LinkedList<Vertice>();
        String buscaEmLargura = "\nBusca em largura realizada a partir do vértice: " + origemBFS;
        for (Map.Entry<Vertice, LinkedList<Vertice>> indice : grafo.getTabelaHash().entrySet()) {
            nos.add(indice.getKey());
        }
        StringBuilder caminhosDistancias = new StringBuilder();
        for (int i = 0; i < nos.size(); i++) {
            if (nos.get(i).getN() == raiz.getN()) {
                for (Vertice no : nos) {
                    if (!no.equals(nos.get(i))) {
                        caminhosDistancias.append("\n").append(grafo.buscaEmLargura(nos.get(i), no));
                    }
                }
                break;
            }
        }

        String[] metodos = {"\n" + grafo.qtdVertices(), grafo.qtdArestas(), grafo.grauMinimo(), grafo.grauMaximo(), grafo.grauMedio(), buscaEmLargura, caminhosDistancias.toString()};
        StringBuilder resultado = new StringBuilder(grafo.toString());
        for (String m : metodos) {
            resultado.append(m);
        }

        escrever("./src/AV2/trabalho04/saida.txt", resultado.toString());

        String style = "graph { padding: 50px; } node { size-mode: fit; shape: rounded-box; fill-color: white; stroke-mode: plain; padding: 3px, 2px; text-size: 50px; size: 700px; }";
        graph.setAttribute("ui.stylesheet", style);
        for (Node node : graph) {
            node.setAttribute("ui.label", node.getId());
        }
    }

}
