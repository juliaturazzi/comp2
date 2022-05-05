import java.util.ArrayList;

public abstract class JogoDeDoisJogadores {

    String nomeJogo;
    String nomeJogador1;
    String nomeJogador2;
    int numeroDeRodadas;
    ArrayList<Integer> historicoResultados;

    public JogoDeDoisJogadores(String nomeJogo, String nomeJogador1, String nomeJogador2, int numeroDeRodadas) {
        this.nomeJogo = nomeJogo;
        this.nomeJogador1 = nomeJogador1;
        this.nomeJogador2 = nomeJogador2;
        this.numeroDeRodadas = numeroDeRodadas;
        this.historicoResultados = new ArrayList<>();
    }

    protected abstract int executarRodadaDoJogo();
    protected int rodadasVencidasJogador1 = 0;
    protected int rodadasVencidasJogador2 = 0;

    public String getNomeJogo() { return nomeJogo; }

    public String getNomeJogador1() { return nomeJogador1; }

    public String getNomeJogador2() { return nomeJogador2; }

    public int getNumeroDeRodadas() { return numeroDeRodadas; }

    public String jogar() {

        for (int counter = 0; counter < getNumeroDeRodadas(); counter++) {
            executarRodadaDoJogo();
            historicoResultados.add(executarRodadaDoJogo());
        }

        for (Integer historicoResultado : historicoResultados) {
            if (historicoResultado == 1) rodadasVencidasJogador1++;

            if (historicoResultado == 2) rodadasVencidasJogador2++;
        }

        if (rodadasVencidasJogador1 > rodadasVencidasJogador2) return "O jogador " + getNomeJogador1() + " venceu o jogo " +
                getNomeJogo() +  " por " + rodadasVencidasJogador1 + " a " + rodadasVencidasJogador2 + ".";

        if (rodadasVencidasJogador2 > rodadasVencidasJogador1) return "O jogador " + getNomeJogador2() + " venceu o jogo " +
                getNomeJogo() +  " por " + rodadasVencidasJogador2 + " a " + rodadasVencidasJogador1 + ".";

        return "O jogo " + getNomeJogo() + " terminou em empate após " + numeroDeRodadas + " rodadas.";
    }

}