public class JogoMalucoComSorteadores extends JogoDeDoisJogadores {

    Sorteador sorteador1;
    Sorteador sorteador2;

    int numeroJogador1 = 0;
    int numeroJogador2 = 0;

    public JogoMalucoComSorteadores (String nomeJogo, String nomeJogador1, String nomeJogador2, int numeroDeRodadas,
                                     Sorteador sorteador1, Sorteador sorteador2) {

        super (nomeJogo, nomeJogador1, nomeJogador2, numeroDeRodadas);

        this.sorteador1 = sorteador1;  this.sorteador2 = sorteador2;
    }

    @Override
    protected int executarRodadaDoJogo() {
        numeroJogador1 = sorteador1.sortear();
        numeroJogador2 = sorteador2.sortear();

        if (numeroJogador1 > numeroJogador2) return 1;

        if (numeroJogador2 > numeroJogador1) return 2;

        return 0;
    }

}