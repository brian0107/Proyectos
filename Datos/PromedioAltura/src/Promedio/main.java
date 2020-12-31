package Promedio;
import java.util.*;
public class main {
    public static void main(String[] args) {
        double A[]= new double[5];
        Scanner sc = new Scanner(System.in);
        double promedio=0;
        for(int i=0;i< A.length;i++){
            System.out.println("Ingrese la altura: ");
            A[i]= sc.nextDouble();
            promedio += A[i];
        }
        for(int i=0;i< A.length;i++){
            System.out.println("Altura " +i+" es : "+ A[i]);
        }
        promedio = promedio/5;
        System.out.println("El promedio de altura es: "+promedio);

    }
}
