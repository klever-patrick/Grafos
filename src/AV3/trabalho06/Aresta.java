package AV3.trabalho06;

public class Aresta implements Comparable<Aresta> {
    Vertice origem;
    Vertice destino;
    double peso;

    Aresta(Vertice o, Vertice d, double p) {
        origem = o;
        destino = d;
        peso = p;
    }

    public String toString() {
        return String.format("(%s -> %s, %f)", origem.nome, destino.nome, peso);
    }

    public int compareTo(Aresta otherEdge) {
        if (this.peso > otherEdge.peso) {
            return 1;
        }
        else return -1;
    }
}