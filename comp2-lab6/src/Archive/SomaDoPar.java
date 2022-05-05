import java.util.ArrayList;
import java.util.HashSet;

public class SomaDoPar {

    /**
     * Percorre a lista dada para encontrar um par de elementos
     * cuja soma seja o valor desejado.
     *
     * @param numeros uma lista de inteiros
     * @param somaDesejada a soma desejada
     *
     * @return O menor dos elementos do par encontrado;
     *         ou null, caso nenhum par de elementos some o valor desejado
     */
    public static Integer encontrarParComSomaDadaQuadratica(
            ArrayList<Integer> numeros, int somaDesejada) {

//        Algoritmo ineficiente (quadrático):

        for (int i = 0; i < numeros.size(); i++) {
            for (int j = i + 1; j < numeros.size(); j++) {
                int x = numeros.get(i);
                int y = numeros.get(j);
                if (x + y == somaDesejada) {
                    return Math.min(x, y);
                }
            }
        }
        return null;
    }
        // Algoritmo eficiente (linear):
    public static Integer encontrarParComSomaDadaLinear(
                ArrayList<Integer> numeros, int somaDesejada) {

        HashSet<Integer> newSet = new HashSet();
        int wantedNumber = 0;

        for(Integer i: numeros) {
            newSet.add(i);
        }

        for(Integer i: newSet) {
            wantedNumber = somaDesejada - i;

            if(newSet.contains(wantedNumber)){
                return Math.min(i,wantedNumber);
            }
        }

        return null;
    }

}


