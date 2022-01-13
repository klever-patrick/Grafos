package AV1.trabalho03;

public class Main {
    public static void main(String[] args) {
        Grafo<String> grafo1 = new Grafo<String>();

        Vertice v1g1 = new Vertice("1", new String[]{"2", "3", "6", "7"});
        Vertice v2g1 = new Vertice("2", new String[]{"1", "3", "4", "6"});
        Vertice v3g1 = new Vertice("3", new String[]{"1", "2", "4", "5"});
        Vertice v4g1 = new Vertice("4", new String[]{"2", "3", "5", "7"});
        Vertice v5g1 = new Vertice("5", new String[]{"3", "4", "6", "7"});
        Vertice v6g1 = new Vertice("6", new String[]{"1", "2", "5", "7"});
        Vertice v7g1 = new Vertice("7", new String[]{"1", "4", "5", "6"});

        Vertice[] verticesGrafo1 = {v1g1, v2g1, v3g1, v4g1, v5g1, v6g1, v7g1};
        String[] atual1;
        for (Vertice vertice : verticesGrafo1) {
            atual1 = vertice.getArestas();
            for (String s : atual1) {
                grafo1.addAresta(vertice.getNome(), s, true);
            }
        }

        System.out.println("Grafo 1: ");
        grafo1.euleriano();
        grafo1.semiEuleriano();
        grafo1.naoEuleriano();
        System.out.println();


        Grafo<String> grafo2 = new Grafo<String>();

        Vertice v1g2 = new Vertice("1", new String[]{"2", "3", "6", "7"});
        Vertice v2g2 = new Vertice("2", new String[]{"1", "3", "4", "6"});
        Vertice v3g2 = new Vertice("3", new String[]{"1", "2", "4"});
        Vertice v4g2 = new Vertice("4", new String[]{"2", "3", "5", "7"});
        Vertice v5g2 = new Vertice("5", new String[]{"4", "6", "7"});
        Vertice v6g2 = new Vertice("6", new String[]{"1", "2", "5", "7"});
        Vertice v7g2 = new Vertice("7", new String[]{"1", "4", "5", "6"});

        Vertice[] verticesGrafo2 = {v1g2, v2g2, v3g2, v4g2, v5g2, v6g2, v7g2};
        String[] atual2;
        for (Vertice vertice : verticesGrafo2) {
            atual2 = vertice.getArestas();
            for (String s : atual2) {
                grafo2.addAresta(vertice.getNome(), s, true);
            }
        }

        System.out.println("Grafo 2: ");
        grafo2.euleriano();
        grafo2.semiEuleriano();
        grafo2.naoEuleriano();
        System.out.println();


        Grafo<String> grafo3 = new Grafo<String>();

        Vertice v1g3 = new Vertice("1", new String[]{"2", "3", "6", "7"});
        Vertice v2g3 = new Vertice("2", new String[]{"1", "3"});
        Vertice v3g3 = new Vertice("3", new String[]{"1", "2", "4"});
        Vertice v4g3 = new Vertice("4", new String[]{"3", "5"});
        Vertice v5g3 = new Vertice("5", new String[]{"4", "6", "7"});
        Vertice v6g3 = new Vertice("6", new String[]{"5", "7"});
        Vertice v7g3 = new Vertice("7", new String[]{"1", "5", "6"});

        Vertice[] verticesGrafo3 = {v1g3, v2g3, v3g3, v4g3, v5g3, v6g3, v7g3};
        String[] atual3;
        for (Vertice vertice : verticesGrafo3) {
            atual3 = vertice.getArestas();
            for (String s : atual3) {
                grafo3.addAresta(vertice.getNome(), s, true);
            }
        }

        System.out.println("Grafo 3: ");
        grafo3.euleriano();
        grafo3.semiEuleriano();
        grafo3.naoEuleriano();
        System.out.println();


        Grafo<String> grafo4 = new Grafo<String>();

        Vertice v1g4 = new Vertice("1", new String[]{"2", "3", "6", "7"});
        Vertice v2g4 = new Vertice("2", new String[]{"1", "3"});
        Vertice v3g4 = new Vertice("3", new String[]{"1", "2", "4"});
        Vertice v4g4 = new Vertice("4", new String[]{"3", "5"});
        Vertice v5g4 = new Vertice("5", new String[]{"4", "6"});
        Vertice v6g4 = new Vertice("6", new String[]{"1", "5", "7"});
        Vertice v7g4 = new Vertice("7", new String[]{"1", "6"});

        Vertice[] verticesGrafo4 = {v1g4, v2g4, v3g4, v4g4, v5g4, v6g4, v7g4};
        String[] atual4;
        for (Vertice vertice : verticesGrafo4) {
            atual4 = vertice.getArestas();
            for (String s : atual4) {
                grafo4.addAresta(vertice.getNome(), s, true);
            }
        }

        System.out.println("Grafo 4: ");
        grafo4.euleriano();
        grafo4.semiEuleriano();
        grafo4.naoEuleriano();
    }
}
