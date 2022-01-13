package AV1.trabalho01;

public class Estado {
    private String nome;
    private String[] vizinhos;

    public Estado(String nome, String[] vizinhos) {
        this.nome = nome;
        this.vizinhos = vizinhos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String[] getVizinhos() {
        return vizinhos;
    }

    public void setVizinhos(String[] vizinhos) {
        this.vizinhos = vizinhos;
    }
}
