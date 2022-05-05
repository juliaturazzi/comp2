import java.util.Map;
import java.util.Random;

public class DadoGenerico<T> implements Sorteador<Integer> {

    Map<T, Integer> frequenciaByResultado;

    public DadoGenerico(Map<T, Integer> frequenciaByResultado) {
        this.frequenciaByResultado = frequenciaByResultado;
    }

    @Override
    public Integer sortear() {
        int freqParcial = 0;
        int freqTotal = 0;

        for (int i = 1; i < frequenciaByResultado.size()+1; i++){
            freqTotal += frequenciaByResultado.get(i);
        }

        Random rand = new Random();

        int j = rand.nextInt(freqTotal+1);

        for(int i = 1; i < frequenciaByResultado.size()+1; i++){
            freqParcial += frequenciaByResultado.get(i);

            if(j <= freqParcial){
                return i;
            }
        }

        return null;
    }
}
