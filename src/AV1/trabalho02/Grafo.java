package AV1.trabalho02;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Grafo<T> {
    private final Map<T, List<T>> tabelaHash = new HashMap<>();

    public void addvertice(T v) {
        tabelaHash.put(v, new LinkedList<>());
    }

    public Map<T, List<T>> getTabelaHash() {
        return tabelaHash;
    }

    public void addAresta(T inicio, T fim, boolean bidirecional) {
        if (!tabelaHash.containsKey(inicio)) {
            addvertice(inicio);
        }
        if (!tabelaHash.containsKey(fim)) {
            addvertice(fim);
        }

        tabelaHash.get(inicio).add(fim);

        if (!bidirecional) {
            tabelaHash.get(fim).add(inicio);
        }
    }

    public void ordemDoGrafo() {
        System.out.println("\nOrdem do grafo: " + tabelaHash.keySet().size());
    }

    public int tamanho(boolean bidirecional) {
        int qtdArestas = 0;

        for (T i : tabelaHash.keySet()) {
            qtdArestas += tabelaHash.get(i).size();
        }
        if (bidirecional) {
            qtdArestas = qtdArestas / 2;
        }

        System.out.println("\nTamanho do grafo: " + qtdArestas);
        return qtdArestas;
    }

    public void temVertice(T vertice) {
        if (tabelaHash.containsKey(vertice)) {
            System.out.println("O grafo contém o vértice " + vertice);
        }
        else {
            System.out.println("O grafo não contém o vértice " + vertice);
        }
    }

    public void temAresta(T inicio, T fim) {
        if (tabelaHash.get(inicio).contains(fim)) {
            System.out.println("O grafo contém uma aresta entre " + inicio + " e " + fim);
        } else {
            System.out.println("O grafo não contém uma aresta entre " + inicio + " e " + fim);
        }
    }


    public T maisArestas() {
        int max = 0;
        T maisArestas = null;
        List<T> vizinhos = null;
        for (Map.Entry<T, List<T>> indice : tabelaHash.entrySet()) {
            if (indice.getValue().size() > max) {
                max = indice.getValue().size();
                maisArestas = indice.getKey();
                vizinhos = indice.getValue();
            }
        }
        return maisArestas;
    }

    public void menosArestas() {
        int min = 100000000;
        int atual = 0;
        T menosArestas;
        List<T> vizinhos;
        for (Map.Entry<T, List<T>> indice : tabelaHash.entrySet()) {
            if (indice.getValue().size() <= min) {
                min = indice.getValue().size();
                menosArestas = indice.getKey();
                vizinhos = indice.getValue();
                if (min <= atual) {
                    System.out.println("\nVértice com a menor quantidade de arestas: " + menosArestas);
                    System.out.println(menosArestas + " tem arestas com os seguintes vértices: " + vizinhos);
                }
            }
            atual = indice.getValue().size();
        }
    }

    public void densidadeGrafo(boolean bidirecional) {
        double qtdVertices = tabelaHash.keySet().size();
        double qtdArestas = this.tamanho(bidirecional);
        System.out.println("\nDensidade do grafo: " + (qtdArestas/qtdVertices));
    }

    public void grauVertices() {
        System.out.println();
        for (Map.Entry<T, List<T>> indice : tabelaHash.entrySet()) {
            System.out.println(indice.getKey() + " possui grau: " + indice.getValue().size());
        }
    }

    public void grauDeUmVertice(T vertice) {
        System.out.println();
        for (Map.Entry<T, List<T>> indice : tabelaHash.entrySet()) {
            if (indice.getKey() == vertice) {
                System.out.println(indice.getKey() + " possui grau: " + indice.getValue().size());
            }
        }
    }

    public void dirac() {
        int qtdVertices = tabelaHash.keySet().size();
        boolean validacao = true;
        for (Map.Entry<T, List<T>> indice : tabelaHash.entrySet()) {
            if (indice.getValue().size() < (qtdVertices / 2)) {
                validacao = false;
                break;
            }
        }
        if (qtdVertices >= 3 && validacao) {
            System.out.println("Este grafo satisfaz o Teorema de Dirac.");
        } else {
            System.out.println("Este grafo não satisfaz o Teorema de Dirac.");
        }
    }

    public void ore() {
        int qtdVertices = tabelaHash.keySet().size();
        boolean validacao = true;
        T atual;
        int soma;
        for (Map.Entry<T, List<T>> indice : tabelaHash.entrySet()) {
            atual = indice.getKey();
            for (Map.Entry<T, List<T>> index : tabelaHash.entrySet()) {
                if (!index.getValue().contains(atual) && index.getKey() != atual) {
                    soma =  index.getValue().size() + indice.getValue().size();
                    if (soma < qtdVertices) {
                        validacao = false;
                    }
                }
            }
        }
        if (qtdVertices >= 3 && validacao) {
            System.out.println("Este grafo satisfaz o Teorema de Ore.");
        } else {
            System.out.println("Este grafo não satisfaz o Teorema de Ore.");
        }
    }

    public boolean completo() {
        int qtdVertices = tabelaHash.keySet().size();
        boolean completo = true;
        for (Map.Entry<T, List<T>> indice : tabelaHash.entrySet()) {
            if (indice.getValue().size() != (qtdVertices - 1)) {
                completo = false;
                break;
            }
        }
        return completo;
    }

    @Override
    public String toString() {
        return "Grafo: " + tabelaHash;
    }
}
