import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Album <T extends Colecionavel> {

    int albumSize, pacotinhoSize;

    HashMap <Integer, Colecionavel> usedFigurinhas;
    HashMap <Integer, Colecionavel> notUsedFigurinhas;

    ArrayList <Colecionavel> notUsedFigurinhasSize;


    public Album(int tamanhoDoAlbum, int quantItensPorPacotinho) {
       this.albumSize = tamanhoDoAlbum; this.pacotinhoSize = quantItensPorPacotinho;

       usedFigurinhas = new HashMap<>(); notUsedFigurinhas = new HashMap<>();

       notUsedFigurinhasSize = new ArrayList<>();
    }


    public void receberNovoPacotinho(Pacotinho<T> pacotinho) throws PacotinhoInvalidoException {
        if (pacotinho.size() != this.pacotinhoSize) throw new PacotinhoInvalidoException();

        for (T t : pacotinho) {
            if (t.getPosicao() > albumSize) throw new PacotinhoInvalidoException();
        }

        for (T t : pacotinho) {
            if (usedFigurinhas.containsKey(t.getPosicao())) notUsedFigurinhas.put(t.getPosicao(), t);

            usedFigurinhas.put(t.getPosicao(), t);

            notUsedFigurinhasSize.add(t);
        }

    }

        public int getTamanho () { return this.albumSize; }


        public int getQuantItensColados () { return usedFigurinhas.size(); }


        public int getQuantItensRepetidos () { return notUsedFigurinhas.size();}


        public boolean possuiItemColado ( int posicao) { return usedFigurinhas.containsKey(posicao); }


        public boolean possuiItemRepetido ( int posicao) { return notUsedFigurinhas.containsKey(posicao); }


        public int getQuantItensFaltantes () { return albumSize-usedFigurinhas.size(); }


        public T getItemColado ( int posicao) {
            if (usedFigurinhas.containsKey(posicao)) return (T) usedFigurinhas.get(posicao);

            return null;
        }

    }
