public class DadosDeGamao implements Sorteador {

    Dado dado1 = new Dado();
    Dado dado2 = new Dado();

    int numeroDado1 = 0;
    int numeroDado2 = 0;

    @Override
    public int sortear() {
        numeroDado1 = dado1.sortear();
        numeroDado2 = dado2.sortear();

        if (numeroDado1 == numeroDado2) return 4 * numeroDado1; // Já que os dados são iguais.

        return (numeroDado1 + numeroDado2);
    }

}