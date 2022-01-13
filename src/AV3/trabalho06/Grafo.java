package AV3.trabalho06;

import java.util.*;

public class Grafo {
    private final Set<Vertice> vertices;
    private final boolean direcionado;

    Grafo(boolean directed) {
        this.direcionado = directed;
        vertices = new HashSet<>();
    }

    public Set<Vertice> getVertices() {
        return vertices;
    }

    public void addVertice(Vertice... n) {
        vertices.addAll(Arrays.asList(n));
    }

    public void addAresta(Vertice origem, Vertice destino, double peso) {
        vertices.add(origem);
        vertices.add(destino);
        addArestaAuxiliar(origem, destino, peso);
        if (!direcionado && origem != destino) {
            addArestaAuxiliar(destino, origem, peso);
        }
    }

    private void addArestaAuxiliar(Vertice a, Vertice b, double weight) {
        for (Aresta edge : a.arestas) {
            if (edge.origem == a && edge.destino == b) {
                edge.peso = weight;
                return;
            }
        }
        a.arestas.add(new Aresta(a, b, weight));
    }

    public void mostraArestas() {
        for (Vertice v : vertices) {
            LinkedList<Aresta> arestas = v.arestas;

            if (arestas.isEmpty()) {
                System.out.println("Vértice " + v.nome + " não possui arestas.");
                continue;
            }
            System.out.print("Vértice " + v.nome + " tem arestas com: ");
            for (Aresta a : arestas) {
                System.out.print(a.destino.nome + "(" + a.peso + ") ");
            }
            System.out.println();
        }
    }

    public boolean temAresta(Vertice origem, Vertice destino) {
        LinkedList<Aresta> arestas = origem.arestas;
        for (Aresta a : arestas) {
            if (a.destino == destino) {
                return true;
            }
        }
        return false;
    }

    public void resetarVerticesVisitados(Set<Vertice> visitados) {
        visitados.clear();
    }

    private Vertice maisProximoNaoVisitado(HashMap<Vertice, Double> menorCaminho, Set<Vertice> visitados) {
        double menorDistancia = Double.POSITIVE_INFINITY;
        Vertice verticeMaisProximo = null;
        for (Vertice v : vertices) {
            if (visitados.contains(v)) {
                continue;
            }
            double distanciaAtual = menorCaminho.get(v);
            if (distanciaAtual == Double.POSITIVE_INFINITY) {
                continue;
            }
            if (distanciaAtual < menorDistancia) {
                menorDistancia = distanciaAtual;
                verticeMaisProximo = v;
            }
        }
        return verticeMaisProximo;
    }

    public void dijkstra(Vertice origem, Vertice fim, Set<Vertice> visitados) {
        HashMap<Vertice, Vertice> predecessores = new HashMap<>();
        predecessores.put(origem, null);
        HashMap<Vertice, Double> menorCaminho = new HashMap<>();
        for (Vertice v : vertices) {
            if (v == origem) {
                menorCaminho.put(origem, 0.0);
            } else {
                menorCaminho.put(v, Double.POSITIVE_INFINITY);
            }
        }
        for (Aresta a : origem.arestas) {
            menorCaminho.put(a.destino, a.peso);
            predecessores.put(a.destino, origem);
        }
        visitados.add(origem);
        while (true) {
            Vertice verticeAtual = maisProximoNaoVisitado(menorCaminho, visitados);
            if (verticeAtual == null) {
                System.out.println("Não há caminho entre " + origem.nome + " e " + fim.nome);
                return;
            }
            if (verticeAtual == fim) {
//                System.out.print("O caminho com menor custo entre " + origem.nome + " e " + fim.nome + " é: ");
                Vertice filho = fim;
                String caminho = fim.nome;
                while (true) {
                    Vertice pai = predecessores.get(filho);
                    if (pai == null) {
                        break;
                    }
                    caminho = pai.nome + " " + caminho;
                    filho = pai;
                }
                System.out.print(caminho);
                System.out.println(" Custo: " + menorCaminho.get(fim));
                return;
            }
            visitados.add(verticeAtual);
            for (Aresta a : verticeAtual.arestas) {
                if (visitados.contains(a.destino)) {
                    continue;
                }
                if (menorCaminho.get(verticeAtual) + a.peso < menorCaminho.get(a.destino)) {
                    menorCaminho.put(a.destino, menorCaminho.get(verticeAtual) + a.peso);
                    predecessores.put(a.destino, verticeAtual);
                }
            }
        }
    }
}