package AV2.trabalho04;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Grafo {
    private final Map<Vertice, LinkedList<Vertice>> tabelaHash = new HashMap<>();
    private final boolean direcionado;

    public Grafo(boolean direcionado) {
        this.direcionado = direcionado;
    }

    public Map<Vertice, LinkedList<Vertice>> getTabelaHash() {
        return tabelaHash;
    }

    public void addvertice(Vertice v) {
        tabelaHash.put(v, new LinkedList<>());
    }

    public void addAresta(Vertice inicio, Vertice fim) {
        if (!tabelaHash.containsKey(inicio)) {
            addvertice(inicio);
        }
        if (!tabelaHash.containsKey(fim)) {
            addvertice(fim);
        }

        tabelaHash.get(inicio).add(fim);

        if (!direcionado) {
            tabelaHash.get(fim).add(inicio);
        }
    }

    public String qtdVertices() {
        return "Quantidade de vértices do grafo: " + tabelaHash.keySet().size();
    }

    public String qtdArestas() {
        int total = 0;
        if (direcionado) {
            for (Map.Entry<Vertice, LinkedList<Vertice>> indice : tabelaHash.entrySet()) {
                total += indice.getValue().size();
            }
        } else {
            for (Map.Entry<Vertice, LinkedList<Vertice>> indice : tabelaHash.entrySet()) {
                total += indice.getValue().size();
            }
            total = total / 2;
        }
        return "\nQuantidade de arestas do grafo: " + total;
    }

    public String grauMinimo() {
        int minimo = 999999999;
        LinkedList<String> vertices = new LinkedList<String>();
        for (Map.Entry<Vertice, LinkedList<Vertice>> indice : tabelaHash.entrySet()) {
            if (indice.getValue().size() < minimo) {
                minimo = indice.getValue().size();
            }
        }
        for (Map.Entry<Vertice, LinkedList<Vertice>> indice : tabelaHash.entrySet()) {
            if (indice.getValue().size() == minimo) {
                vertices.add(indice.getKey().getNome());
            }
        }
        StringBuilder resultado = new StringBuilder("");
        for (String v : vertices) {
            resultado.append(v).append(", ");
        }
        return "\nO(s) vértice(s) " + resultado + "possui(em) o menor grau deste grafo, que é: " + minimo;
    }

    public String grauMaximo() {
        int maximo = 0;
        LinkedList<String> vertices = new LinkedList<String>();
        for (Map.Entry<Vertice, LinkedList<Vertice>> indice : tabelaHash.entrySet()) {
            if (indice.getValue().size() > maximo) {
                maximo = indice.getValue().size();
            }
        }
        for (Map.Entry<Vertice, LinkedList<Vertice>> indice : tabelaHash.entrySet()) {
            if (indice.getValue().size() == maximo) {
                vertices.add(indice.getKey().getNome());
            }
        }
        StringBuilder resultado = new StringBuilder("");
        for (String v : vertices) {
            resultado.append(v).append(", ");
        }
        return "\nO(s) vértice(s) " + resultado + "possui(em) o maior grau deste grafo, que é: " + maximo;
    }

    public String grauMedio() {
        int soma = 0;
        for (Map.Entry<Vertice, LinkedList<Vertice>> indice : tabelaHash.entrySet()) {
            soma += indice.getValue().size();
        }
        int media = soma / tabelaHash.keySet().size();
        return "\nGrau médio: " + media;
    }

    public String mostraCaminhos(LinkedList<Vertice> caminhos) {
        StringBuilder resultado = new StringBuilder();
        for (Vertice v : caminhos) {
            resultado.append(v).append(" ");
        }
        return resultado.toString();
    }

    public boolean naoFoiVisitado(Vertice v, LinkedList<Vertice> caminhos) {
        for (Vertice caminho : caminhos) {
            if (caminho.equals(v)) {
                return false;
            }
        }
        return true;
    }

    public int menorDaLista(LinkedList<LinkedList<Vertice>> lista) {
        int tamanhoMinimo = 999999999;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).size() < tamanhoMinimo) {
                tamanhoMinimo = lista.get(i).size();
            }
        }
        return tamanhoMinimo;
    }

    public String buscaEmLargura(Vertice comeco, Vertice destino) {
        // Fila para armazenar os caminhos
        LinkedList<LinkedList<Vertice>> fila = new LinkedList<LinkedList<Vertice>>();
        // Armazena caminho atual
        LinkedList<Vertice> caminhos = new LinkedList<Vertice>();
        LinkedList<LinkedList<Vertice>> listaDeCaminhos = new LinkedList<LinkedList<Vertice>>();
        caminhos.add(comeco);
        fila.add(caminhos);
        while (!fila.isEmpty()) {
            caminhos = fila.removeFirst();
            Vertice ultimo = caminhos.get(caminhos.size() - 1);
            if (ultimo.equals(destino)) {
                // Se o último vértice for o destino, caminho é adicionado
                listaDeCaminhos.add(caminhos);
            }
            //Percorre todos os vértices conectados ao atual e adiciona o novo caminho a fila
            LinkedList<Vertice> ultimoVertice = tabelaHash.get(ultimo);
            for (int i = 0; i < ultimoVertice.size(); i++) {
                if (naoFoiVisitado(ultimoVertice.get(i), caminhos)) {
                    LinkedList<Vertice> novoCaminho = new LinkedList<Vertice>(caminhos);
                    novoCaminho.add(ultimoVertice.get(i));
                    fila.add(novoCaminho);
                }
            }
        }
        menorDaLista(listaDeCaminhos);
        for (LinkedList<Vertice> listaDeCaminho : listaDeCaminhos) {
            if (listaDeCaminho.size() == menorDaLista(listaDeCaminhos)) {
                mostraCaminhos(listaDeCaminho);
                int distancia = listaDeCaminho.size() - 1;
                return "Caminho: " + mostraCaminhos(listaDeCaminho) + "\tDistância: " + distancia;
            }
        }
        return "";
    }

    @Override
    public String toString() {
        return "Grafo: " + tabelaHash;
    }
}
