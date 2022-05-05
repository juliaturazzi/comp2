import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JogoOnlineTest {

    private JogoOnline jogo;

    @Before
    public void setUp() {
        jogo = new JogoOnline();
    }

    @Test
    public void testarLoginComUsuarioDesconhecido() throws SenhaInvalidaException {
        try {
            jogo.fazerLogin("UsuarioQualquerDesconhecido", "1234");
            fail("Uma UsuarioInexistenteException deve ser lançada se o username for desconhecido");

        } catch (UsuarioInexistenteException e) {
            // tudo bem, aconteceu o que eu esperava!!!
        }
    }

    // equivalentemente...

    @Test(expected = UsuarioInexistenteException.class)
    public void testarLoginComUsuarioDesconhecidoOutraManeira() throws UsuarioInexistenteException, SenhaInvalidaException {
        JogoOnline jogo = new JogoOnline();
        jogo.fazerLogin("UsuarioQualquerDesconhecido", "1234");
    }

    @Test
    public void testarCadastroELogin() throws UsuarioInexistenteException, SenhaInvalidaException {
        Jogador jogadorJoao = jogo.cadastrarJogador("joao", "1234");
        assertNotNull(jogadorJoao);
        assertEquals("joao", jogadorJoao.getUsername());

        jogo.fazerLogin("joao", "1234");

        assertTrue("Após o login (e antes do logout), o jogador " +
                        "deve ser considerado online",
                jogadorJoao.isOnline());
    }

    @Test
    public void testarCadastroELoginComSenhaIncorreta() throws UsuarioInexistenteException {
        Jogador jogadorJoao = jogo.cadastrarJogador("joao", "1234");
        assertNotNull(jogadorJoao);
        assertEquals("joao", jogadorJoao.getUsername());

        try {
            jogo.fazerLogin("joao", "3246523");
            fail("O fazerLogin deveria lançar uma SenhaInvalidaException!!!");

        } catch (SenhaInvalidaException e) {
            // ok, era esperado que ela acontecesse!!!!
        }

        assertFalse(jogadorJoao.isOnline());
    }

    @Test
    public void testarIniciarPartida() throws UsuarioInexistenteException, SenhaInvalidaException {
        Jogador jogadorJoao = jogo.cadastrarJogador("joao", "1234");
        Jogador jogadoraMaria = jogo.cadastrarJogador("maria", "3456");

        jogo.fazerLogin("joao", "1234");
        jogo.fazerLogin("maria", "3456");

        // sanity check
        assertFalse(jogadorJoao.isJogando());
        assertFalse(jogadoraMaria.isJogando());

        Partida partida = jogo.iniciarPartida(jogadorJoao, jogadoraMaria);

        assertEquals(jogadorJoao, partida.getJogador1());
        assertEquals(jogadoraMaria, partida.getJogador2());
        assertEquals(Partida.PARTIDA_EM_ANDAMENTO,
                partida.getResultado());
        assertTrue(jogadorJoao.isJogando());
        assertTrue(jogadoraMaria.isJogando());
    }

    @Test
    public void testarLogout() throws UsuarioInexistenteException, SenhaInvalidaException {
        Jogador jogadoraMaria = jogo.cadastrarJogador("maria", "3456");

        jogo.fazerLogin("maria", "3456");

        assertTrue(jogadoraMaria.isOnline());

        jogo.fazerLogout(jogadoraMaria);

        assertFalse(jogadoraMaria.isOnline());
    }

    @Test(expected = RuntimeException.class)
    public void testarLogoutDeJogadorNaoOnline() {
        Jogador jogadoraMaria = jogo.cadastrarJogador("maria", "3456");

        jogo.fazerLogout(jogadoraMaria);
        // impossível fazer o logou t de jogador que nõ está online,
        // então esperamos tomar uma RuntimeException
    }

   // LAB 8

    @Test // Testando se o lugar no ranking está certo após partidas
    public void testeObterRanking() throws SenhaInvalidaException, UsuarioInexistenteException {
        Jogador jogadoraMaria = jogo.cadastrarJogador("maria", "3456");
        jogo.fazerLogin("maria", "3456");
        assertTrue(jogadoraMaria.isOnline());

        Jogador jogadorJoao = jogo.cadastrarJogador("joao", "1234");
        jogo.fazerLogin("joao", "1234");
        assertTrue(jogadorJoao.isOnline());

        Partida P1 = jogo.iniciarPartida(jogadoraMaria, jogadorJoao);
        assertTrue(jogadoraMaria.isJogando());
        assertTrue(jogadorJoao.isJogando());

        jogo.encerrarPartida(P1, 1);
        assertFalse(jogadoraMaria.isJogando());
        assertFalse(jogadorJoao.isJogando());

        Partida P2 = jogo.iniciarPartida(jogadoraMaria, jogadorJoao);
        assertTrue(jogadoraMaria.isJogando());
        assertTrue(jogadorJoao.isJogando());

        jogo.encerrarPartida(P2, 1);
        assertFalse(jogadoraMaria.isJogando());
        assertFalse(jogadorJoao.isJogando());

        Partida P3 = jogo.iniciarPartida(jogadoraMaria, jogadorJoao);
        assertTrue(jogadoraMaria.isJogando());
        assertTrue(jogadorJoao.isJogando());

        jogo.encerrarPartida(P3, 1);
        assertFalse(jogadoraMaria.isJogando());
        assertFalse(jogadorJoao.isJogando());

        Partida P4 = jogo.iniciarPartida(jogadoraMaria, jogadorJoao);
        assertTrue(jogadoraMaria.isJogando());
        assertTrue(jogadorJoao.isJogando());

        jogo.encerrarPartida(P4, 1);
        assertFalse(jogadoraMaria.isJogando());
        assertFalse(jogadorJoao.isJogando());

        Partida P5 = jogo.iniciarPartida(jogadoraMaria, jogadorJoao);
        assertTrue(jogadoraMaria.isJogando());
        assertTrue(jogadorJoao.isJogando());

        jogo.encerrarPartida(P5, 0);
        assertFalse(jogadoraMaria.isJogando());
        assertFalse(jogadorJoao.isJogando());

        assertEquals("maria", jogo.obterRanking().get(0).getUsername()); // Deve estar no primeiro lugar no ranking
        assertEquals("joao", jogo.obterRanking().get(1).getUsername()); // Deve estar no segundo lugar no ranking
    }

    @Test // Testando se a lista está em ordem alfabética
    public void testeObterJogadoresEmOrdemAlfabetica() throws SenhaInvalidaException, UsuarioInexistenteException {
        Jogador jogadoraMaria = jogo.cadastrarJogador("maria", "3456");
        jogo.fazerLogin("maria", "3456");
        assertTrue(jogadoraMaria.isOnline());

        Jogador jogadorJoao = jogo.cadastrarJogador("joao", "1234");
        jogo.fazerLogin("joao", "1234");
        assertTrue(jogadorJoao.isOnline());

        assertEquals("joao", jogo.obterJogadoresEmOrdemAlfabetica().get(0).getUsername()); // Deve estar no primeiro lugar na lista
        assertEquals("maria", jogo.obterJogadoresEmOrdemAlfabetica().get(1).getUsername()); // Deve estar no segundo lugar na lista
    }
}