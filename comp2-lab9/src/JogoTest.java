import org.junit.Assert;
import org.junit.Test;

public class JogoTest {

    @Test
    public void Test(){
        DadosDeGamao dadoJogador1 = new DadosDeGamao();
        DadosTriplos dadoJogador2 = new DadosTriplos();

        JogoMalucoComSorteadores RPG = new JogoMalucoComSorteadores("RPG", "Kayan",
                "Julia", 10000, dadoJogador1, dadoJogador2);

        RPG.jogar();

        Assert.assertEquals(10000, RPG.historicoResultados.size()); // Verifica o número de rodadas
        Assert.assertTrue(RPG.rodadasVencidasJogador2 > RPG.rodadasVencidasJogador1); // Jogador 2 sempre ganha com os dados triplos
    }

}