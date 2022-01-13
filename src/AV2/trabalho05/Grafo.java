package AV2.trabalho05;

import java.util.*;

public class Grafo {
    private final Map<Vertice, LinkedList<Vertice>> tabelaHash = new HashMap<>();
    private final boolean direcionado;

    public Grafo(boolean direcionado) {
        this.direcionado = direcionado;
    }

    public Map<Vertice, LinkedList<Vertice>> getTabelaHash() {
        return tabelaHash;
    }

    public void addVertice(Vertice v) {
        tabelaHash.put(v, new LinkedList<>());
    }

    public void addAresta(Vertice inicio, Vertice fim) {
        if (!tabelaHash.containsKey(inicio)) {
            addVertice(inicio);
        }
        if (!tabelaHash.containsKey(fim)) {
            addVertice(fim);
        }

        tabelaHash.get(inicio).add(fim);

        if (!direcionado) {
            tabelaHash.get(fim).add(inicio);
        }
    }

    public void dfsRecursiva(Vertice origem, Set<Vertice> visitados) {
        visitados.add(origem);
        System.out.print(origem.getNome() + " ");
        LinkedList<Vertice> vizinhos = tabelaHash.get(origem);
        if (vizinhos == null) {
            return;
        }
        for (Vertice vizinho : vizinhos) {
            if (!visitados.contains(vizinho)) {
                dfsRecursiva(vizinho, visitados);
            }
        }
    }

    public void dfsIterativa(Vertice origem) {
        Stack<Vertice> pilha = new Stack<Vertice>();
        pilha.add(origem);

        Set<Vertice> visitados = new HashSet<Vertice>();

        while (!pilha.isEmpty()) {
            Vertice atual = pilha.pop();
            if (!visitados.contains(atual)) {
                System.out.print(atual + " ");
                visitados.add(atual);
            }
            LinkedList<Vertice> vizinhos = tabelaHash.get(atual);
            for (Vertice v : vizinhos) {
                if (v != null && !visitados.contains(v)) {
                    pilha.add(v);
                }
            }
        }
    }

    public void recursiveDfs(Vertice origem, HashSet<Vertice> visitados, Grafo arvore) {
        visitados.add(origem);
        for (Vertice v : tabelaHash.get(origem)) {
            if (!visitados.contains(v)) {
                arvore.addAresta(origem, v);
                recursiveDfs(v, visitados, arvore);
            }
        }
    }

    public void iterativeDfs(Vertice origem, Grafo arvore) {
        Stack<Vertice> pilha = new Stack<Vertice>();
        pilha.add(origem);

        Set<Vertice> visitados = new HashSet<Vertice>();

        while (!pilha.isEmpty()) {
            Vertice atual = pilha.pop();
            if (!visitados.contains(atual)) {
                System.out.print("");
                visitados.add(atual);
            }
            LinkedList<Vertice> vizinhos = tabelaHash.get(atual);
            for (Vertice v : vizinhos) {
                if (v != null && !visitados.contains(v)) {
                    arvore.addAresta(atual, v);
                    pilha.add(v);
                }
            }
        }
    }
    @Override
    public String toString() {
        return "Grafo: " + tabelaHash;
    }

}
