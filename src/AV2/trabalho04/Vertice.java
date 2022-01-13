package AV2.trabalho04;

import java.util.Objects;

public class Vertice {
    private int n;
    private String nome;
    private boolean visitado;

    public Vertice(String nome) {
        this.n = Integer.parseInt(nome);
        this.nome = nome;
        this.visitado = false;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        Vertice vertice = (Vertice) o;
        return Objects.equals(nome, vertice.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return getNome();
    }
}
