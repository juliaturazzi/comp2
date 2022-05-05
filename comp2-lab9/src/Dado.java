import java.util.Random;

public class Dado implements Sorteador {

    Random rand = new Random();

    @Override
    public int sortear() { return rand.nextInt(7); }

}
