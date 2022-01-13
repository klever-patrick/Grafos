package AV1.trabalho01;

public class Main {
    public static void main(String[] args) {
        Grafo<String> grafo = new Grafo<>();

        Estado AC = new Estado("AC", new String[]{"AM", "RO"});
        Estado AL = new Estado("AL", new String[]{"BA", "PE", "SE"});
        Estado AM = new Estado("AM", new String[]{"AC", "MT", "PA", "RO", "RR"});
        Estado AP = new Estado("AP", new String[]{"PA"});
        Estado BA = new Estado("BA", new String[]{"AL", "ES", "GO", "MG", "PE", "PI", "SE", "TO"});
        Estado CE = new Estado("CE", new String[]{"PB", "PE", "PI", "RN"});
        Estado DF = new Estado("DF", new String[]{"GO", "MG"});
        Estado ES = new Estado("ES", new String[]{"BA", "MG", "RJ"});
        Estado GO = new Estado("GO", new String[]{"BA", "DF", "MG", "MT", "MS"});
        Estado MA = new Estado("MA", new String[]{"PA", "PI", "TO"});
        Estado MG = new Estado("MG", new String[]{"BA", "DF", "ES", "GO", "MS", "SP", "RJ"});
        Estado MS = new Estado("MS", new String[]{"GO", "MG", "MT", "PR", "SP"});
        Estado MT = new Estado("MT", new String[]{"AM", "GO", "MS", "PA", "RO", "TO"});
        Estado PA = new Estado("PA", new String[]{"AM", "AP", "MA", "MT", "RR", "TO"});
        Estado PB = new Estado("PB", new String[]{"CE", "PE", "RN"});
        Estado PE = new Estado("PE", new String[]{"AL", "BA", "CE", "PB", "PI"});
        Estado PI = new Estado("PI", new String[]{"BA", "CE", "MA", "PE", "TO"});
        Estado PR = new Estado("PR", new String[]{"MS", "SC", "SP"});
        Estado RJ = new Estado("RJ", new String[]{"ES", "MG", "SP"});
        Estado RN = new Estado("RN", new String[]{"CE", "PB"});
        Estado RS = new Estado("RS", new String[]{"SC"});
        Estado RO = new Estado("RO", new String[]{"AC", "AM", "MT"});
        Estado RR = new Estado("RR", new String[]{"AM", "PA"});
        Estado SC = new Estado("SC", new String[]{"PR", "RS"});
        Estado SE = new Estado("SE", new String[]{"AL", "BA"});
        Estado SP = new Estado("SP", new String[]{"MG", "MS", "PR", "RJ"});
        Estado TO = new Estado("TO", new String[]{"BA", "GO", "MA", "MT", "PA", "PI"});

        Estado[] estados = {AC, AL, AM, AP, BA, CE, DF, ES, GO, MA, MG, MS, MT, PA, PB, PE, PI, PR, RJ, RN, RS, RO, RR, SC, SE, SP, TO};
        String[] atual;
        for (Estado estado : estados) {
            atual = estado.getVizinhos();
            for (String s : atual) {
                grafo.addAresta(estado.getNome(), s, true);
            }
        }

        System.out.println(grafo);
        grafo.maisArestas();
        grafo.menosArestas();
        grafo.densidadeGrafo(true);
        grafo.grauVertices();
        grafo.grauDeUmVertice("CE");
        grafo.ordemDoGrafo();
    }
}
