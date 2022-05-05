public class Principal {

    public static void main(String[] args) {

        DadosDeGamao dadosDeGamao = new DadosDeGamao();
        DadosTriplos dadosTriplos = new DadosTriplos();

        for (int numeroDeRodadas = 1; numeroDeRodadas <= 1000; numeroDeRodadas*=2) {
            JogoMalucoComSorteadores <DadosDeGamao, DadosTriplos> jogoMaluco = new JogoMalucoComSorteadores<>(
                    "JogadorDosDadosDeGamao", "JogadorDosDadosTriplos", numeroDeRodadas, dadosDeGamao, dadosTriplos);

            for (int i = 1; i <= 1000; i++) {

                jogoMaluco.jogar();

            }
            System.out.printf("\nPara partidas com %d rodada(s):\n", jogoMaluco.getNumeroDeRodadas());
            System.out.printf("Vitórias do Jogador 1: %.1f%%\n", jogoMaluco.getPercentualVitoriasJogador1());
            System.out.printf("Vitórias do Jogador 2: %.1f%%\n", jogoMaluco.getPercentualVitoriasJogador2());
            System.out.printf("Empates: %.1f%%\n", jogoMaluco.getPercentualEmpates());
        }
    }
}
