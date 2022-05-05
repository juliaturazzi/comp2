import java.util.ArrayList;
import java.util.Random;

public class SpeedTest {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 50000; i++) {
            Random random = new Random();
            numbers.add(random.nextInt());
        }

        long counterStartQuadratica = System.currentTimeMillis();
        SomaDoPar.encontrarParComSomaDadaQuadratica(numbers, 0);

        long sumDurationQuadratica = System.currentTimeMillis() - counterStartQuadratica;
        System.out.printf("\nDuracao, em segundos, da soma quadratica: %.3f", sumDurationQuadratica / 1000.0);

        long startOfSumLinear = System.currentTimeMillis();
        SomaDoPar.encontrarParComSomaDadaLinear(numbers, 0);

        long sumDurationLinear = System.currentTimeMillis() - startOfSumLinear;
        System.out.printf("\nDuracao, em segundos, da soma linear: %.3f", sumDurationLinear / 1000.0);


        String sequence = "aaaaaaaaaaaaaaaaaaahkqehftqeikhrweihrio";
        String text = "";

        for (int i = 0; i < 1000; i++) {
            text += sequence;
        }

        long characterStartQuadratico = System.currentTimeMillis();
        CaracterMaisFrequente.encontrarCaracterMaisFrequenteQuadratico(text);

        long characterDurationQuadratico = System.currentTimeMillis() - characterStartQuadratico;
        System.out.printf("\nDuracao, em segundos, do caractere mais frequente na quadratica: %.3f", characterDurationQuadratico / 1000.0);

        long characterStartLinear = System.currentTimeMillis();
        CaracterMaisFrequente.encontrarCaracterMaisFrequenteQuadratico(text);

        long characterDurationLinear = System.currentTimeMillis() - characterStartLinear;
        System.out.printf("\nDuracao, em segundos, do caractere mais frequente na linear: %.3f", characterDurationLinear / 1000.0);

    }
}
