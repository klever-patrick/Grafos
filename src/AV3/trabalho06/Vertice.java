package AV3.trabalho06;

import java.util.LinkedList;
import java.util.Objects;

public class Vertice {
    String nome;
    LinkedList<Aresta> arestas;

    Vertice(String nome) {
        this.nome = nome;
        arestas = new LinkedList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertice that = (Vertice) o;
        return Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

}