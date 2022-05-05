public class SorteadorViaTrio implements Sorteador<Integer>{
    Sorteador Dado;

    public SorteadorViaTrio(Sorteador dado) { this.Dado = dado;}

    public Integer sortear(){
        int A = (int) Dado.sortear();
        int B = (int) Dado.sortear();
        int C = (int) Dado.sortear();

        if(A == B && A == C) {
            return 1;
        }

        return 0;
    }

}
