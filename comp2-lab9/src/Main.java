public class Main {

    public static void main(String[] args) {
        DadosDeGamao dadoJogador1 = new DadosDeGamao();
        DadosTriplos dadoJogador2 = new DadosTriplos();

        JogoMalucoComSorteadores RPG = new JogoMalucoComSorteadores("RPG", "Kayan",
                                                    "Julia", 10000, dadoJogador1, dadoJogador2);

        System.out.println(RPG.jogar()); // Informa qual jogador venceu
    }

}