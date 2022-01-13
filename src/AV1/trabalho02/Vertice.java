package AV1.trabalho02;

public class Vertice {
    private String nome;
    private String[] arestas;

    public Vertice(String nome, String[] arestas) {
        this.nome = nome;
        this.arestas = arestas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String[] getArestas() {
        return arestas;
    }

    public void setArestas(String[] arestas) {
        this.arestas = arestas;
    }
}
