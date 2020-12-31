package Paquete;

public class ShellSort {

    private int salto,i,j,k,aux;
    private int cont1 = 0;
    private int cont2 = 0;
    private int cont3 = 0;

    public ShellSort(int[] A){
        System.out.println("|| SHELL SORT ||");
        System.out.println("Arreglo desordenado");
        printArray(A);
        salto = A.length / 2;
        long tiempoInicio = System.currentTimeMillis();
        while (salto > 0){
            for (i = salto; i < A.length; i++){
                j = i - salto;
                while (j >= 0){
                    k = j + salto;
                    if (A[j] <= A[k]){
                        break;
                    }else{
                        aux = A[j];
                        A[j] = A[k];
                        A[k] = aux;
                        j -= salto;
                    }
                    cont1++;
                }
                cont2++;
            }
            salto = salto /2;
            cont3++;
        }
        long tiempoFinal = System.currentTimeMillis();
        System.out.println("tiempoInicio = " + tiempoInicio);
        System.out.println("tiempoFinal = " + tiempoFinal);
        System.out.println("Comparaciones totales = "+ (cont1 + cont2 + cont3));
        System.out.println("Tiempo = " + (tiempoFinal - tiempoInicio) + "ms ");
        System.out.println("Arreglo ordenado");
        printArray(A);
        System.out.println("\n");
    }
    protected void printArray(int[] B){
        String cadena = "";
        for (int i = 0; i < B.length; i++){
            cadena += "["+ B[i]+"],";
        }
        System.out.println(cadena);
    }
}
