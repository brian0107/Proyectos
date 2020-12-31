package Paquete;

public class Burbuja {

    private int aux = 0;
    private int contFilas = 0;
    private int contColumas = 0;

    public Burbuja(int[] A){
        System.out.println("|| BURBUJA ||");

        System.out.println("Arreglo desordenado");
        Imprimir(A);

        long tiempoInicio = System.currentTimeMillis();

        for (int i = 0; i < A.length; i++){
            for (int j = i + 1; j < A.length; j++){
                if (A[i] > A[j]){
                    aux = A[i];
                    A[i] = A[j];
                    A[j] = aux;
                }
                contColumas ++;
            }
            contFilas ++;
        }
        long tiempoFinal = System.currentTimeMillis();

        System.out.println("tiempoInicio = " + tiempoInicio);
        System.out.println("tiempoFinal = "+ tiempoFinal);
        System.out.println("Comparaciones totales = "+ (contFilas + contColumas));
        System.out.println("Tiempo = " + (tiempoFinal - tiempoInicio) + "ms ");
        System.out.println("Arreglo ordenado");
        Imprimir(A);
        System.out.println("\n");
    }

    private void Imprimir(int[] B){
        String cadena = "";
        for (int i = 0; i < B.length; i++){
            cadena += "["+ B[i]+"],";
        }
        System.out.println(cadena);
    }
}
