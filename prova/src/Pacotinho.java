import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Pacotinho<T extends Colecionavel> extends ArrayList<T> {

    int size;

    public Pacotinho(int tamanho) {
        super();

        this.size = tamanho;
    }

    @Override
    public boolean add(T elemento) {
        if (size() >= size)     throw  new IllegalStateException();

        return super.add(elemento);
    }
}
