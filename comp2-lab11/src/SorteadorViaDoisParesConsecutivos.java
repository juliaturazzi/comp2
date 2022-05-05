public class SorteadorViaDoisParesConsecutivos implements  Sorteador <Integer> {
    Sorteador Dado;


    public SorteadorViaDoisParesConsecutivos(Sorteador dado) { this.Dado = dado;}

    public Integer sortear(){
        int A = (int) Dado.sortear();
        int B = (int) Dado.sortear();
        int C = (int) Dado.sortear();
        int D = (int) Dado.sortear();

        if(A == B && C == D){
            return 1;
        }

        return 0;
    }
}
