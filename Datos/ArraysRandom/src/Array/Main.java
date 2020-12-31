package Array;

public class Main {
    public static void main(String[] args){
        int A[]= new int[10];

        for (int i=0; i<10;i++){
            A[i]=(int) (Math.random()*100);

            System.out.println("Arreglo "+i+" = "+A[i]);
        }
    }
}
