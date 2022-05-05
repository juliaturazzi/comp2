public class DadosTriplos implements Sorteador {

    Dado dadoTriplo = new Dado();

    int numero1 = 0;
    int numero2 = 0;
    int numero3 = 0;

    @Override
    public int sortear() {
        numero1 = dadoTriplo.sortear();
        numero2 = dadoTriplo.sortear();
        numero3 = dadoTriplo.sortear();

        return numero1 + numero2 + numero3;
    }

}