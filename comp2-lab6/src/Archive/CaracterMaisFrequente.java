import java.util.HashMap;

public class CaracterMaisFrequente {

    public static char encontrarCaracterMaisFrequenteQuadratico(String texto) {

        // Algoritmo ineficiente (quadrático):
        char maisFrequente = texto.charAt(0);
        int ocorrenciasDoMaisFrequente = 1;

        for (int i = 0; i < texto.length(); i++) {
            char caracterDaVez = texto.charAt(i);
            int contOcorrencias = 1;
            for (int j = i + 1; j < texto.length(); j++) {
                if (texto.charAt(j) == caracterDaVez) {
                    contOcorrencias++;
                }
            }

            if (contOcorrencias > ocorrenciasDoMaisFrequente) {
                maisFrequente = caracterDaVez;
                ocorrenciasDoMaisFrequente = contOcorrencias;
            }
        }

        return maisFrequente;
    }
        // Algoritmo eficiente (linear):
        public static char encontrarCaracterMaisFrequenteLinear(String texto) {
            HashMap <Character, Integer> Map = new HashMap<>();

            for(int i = 0; i < texto.length(); i++) {
               if(Map.containsKey(texto.charAt(i))) {
                   int j = Map.get(texto.charAt(i));
                   Map.put(texto.charAt(i),j++);
               }
               Map.put(texto.charAt(i), 1);
            }

            char mostFrequentLetter = 0;
            int count = 0;

            for(Character i: Map.keySet()) {
                if(Map.get(i) > count){
                    mostFrequentLetter = i;
                    count = Map.get(i);
                }
            }

            return mostFrequentLetter;
        }
    }

