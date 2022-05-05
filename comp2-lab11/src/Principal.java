import java.util.HashMap;
import java.util.Map;

public class Principal {

    private static final int CONT_REPETICOES_POR_SIMULACAO = 10_000;

    private static DadoComum dadoComum = new DadoComum();
    private static DadoGenerico dadoGenerico;

    private static SorteadorViaTrio sorteadorTrio = new SorteadorViaTrio(dadoComum);


    private static void jogoParXTrio(int numeroDeRodadasPorPartida) {
        SorteadorViaDoisParesConsecutivos paresConsecutivos = new SorteadorViaDoisParesConsecutivos(dadoComum);

        JogoMalucoComSorteadores<SorteadorViaDoisParesConsecutivos, SorteadorViaTrio> jogoComum;

        jogoComum = new JogoMalucoComSorteadores<>(
                "JogadorParesConsecutivos", "JogadorTrio",
                numeroDeRodadasPorPartida, paresConsecutivos, sorteadorTrio);

        for (int i = 0; i < CONT_REPETICOES_POR_SIMULACAO; i++) {
            jogoComum.jogar();
        }

        System.out.println(String.format("\n\n" +
                        "      Para partidas com %d rodada(s):\n" +
                        "      Vitórias do Jogador 1: %f%%\n" +
                        "      Vitórias do Jogador 2: %f%%\n" +
                        "      Empates: %f%%",
                numeroDeRodadasPorPartida,
                jogoComum.getPercentualVitoriasJogador1(),
                jogoComum.getPercentualVitoriasJogador2(),
                jogoComum.getPercentualEmpates()));
    }


    private static void jogoParXTrioViciado(int numeroDeRodadasPorPartida) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 9);
        map.put(2, 1);
        map.put(3, 1);
        map.put(4, 1);
        map.put(5, 1);
        map.put(6, 1);

        DadoGenerico dadoGenerico = new DadoGenerico(map);

        SorteadorViaDoisParesConsecutivos paresConsecutivos = new SorteadorViaDoisParesConsecutivos(dadoComum);
        SorteadorViaTrio sorteadorTrioViciado = new SorteadorViaTrio(dadoGenerico);

        JogoMalucoComSorteadores<SorteadorViaDoisParesConsecutivos, SorteadorViaTrio> jogoComum;

        jogoComum = new JogoMalucoComSorteadores<>(
                "JogadorParesConsecutivos", "JogadorTrio",
                numeroDeRodadasPorPartida, paresConsecutivos, sorteadorTrioViciado);

        for (int i = 0; i < CONT_REPETICOES_POR_SIMULACAO; i++) {
            jogoComum.jogar();
        }

        System.out.println(String.format("\n\n" +
                        "      Para partidas com %d rodada(s):\n" +
                        "      Vitórias do Jogador 1: %f%%\n" +
                        "      Vitórias do Jogador 2: %f%%\n" +
                        "      Empates: %f%%",
                numeroDeRodadasPorPartida,
                jogoComum.getPercentualVitoriasJogador1(),
                jogoComum.getPercentualVitoriasJogador2(),
                jogoComum.getPercentualEmpates()));
    }

    public static void main(String[] args) {
        System.out.println("\n*************** Jogo não viciado ***************");
        for (int numeroDeRodadas = 1; numeroDeRodadas <= 1000; numeroDeRodadas *= 2) {
            jogoParXTrio(numeroDeRodadas);
        }

        System.out.println("\n\n\n*************** Jogo viciado ***************");
        for (int numeroDeRodadas = 1; numeroDeRodadas <= 1000; numeroDeRodadas *= 2) {
            jogoParXTrioViciado(numeroDeRodadas);
        }
    }
}
