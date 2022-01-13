package AV3.trabalho07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Grafo {
    int qtdVertices;
    List<Aresta> listaArestas;

    public Grafo(int qtdVertices, List<Aresta> listaArestas) {
        this.qtdVertices = qtdVertices;
        this.listaArestas = listaArestas;
    }

    public void bellmanFord(int origem) {
        Long infinito = (long) 999999999;
        List<Long> distancia = new ArrayList<>(Collections.nCopies(qtdVertices, infinito));
        distancia.set(origem, (long) 0);
        for (int i = 0; i < qtdVertices; i++) {
            for (Aresta a : listaArestas) {
                if (distancia.get(a.destino) > distancia.get(a.origem) + a.custo) {
                    distancia.set(a.destino, distancia.get(a.origem) + a.custo);
                }
            }
        }
        for (Aresta a : listaArestas) {
            if (distancia.get(a.destino) > distancia.get(a.origem) + a.custo) {
                System.out.println("Grafo contém ciclo negativo entre: " + a.origem + " e " + a.destino);
            }
        }
        for (int i = 0; i < qtdVertices; i++) {
            System.out.println("De " + origem + " a " + i + "\tDistância: " + distancia.get(i));
        }
    }
}