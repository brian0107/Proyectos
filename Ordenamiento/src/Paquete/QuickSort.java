package Paquete;

public class QuickSort {
    private int cont = 0;

    public QuickSort(int[] A){
        System.out.println("|| QUICK SORT ||");
        System.out.println("Arreglo desordenado");
        Imprimir(A);
        long tiempoInicio = System.currentTimeMillis();

        quicksort2(A, 0, A.length - 1);

        long tiempoFinal = System.currentTimeMillis();
        System.out.println("tiempoInicio = " + tiempoInicio);
        System.out.println("tiempoFinal = " + tiempoFinal);
        System.out.println("Comparaciones totales = "+ (cont));
        System.out.println("Tiempo = " + (tiempoFinal - tiempoInicio) + "ms ");
        System.out.println("Arreglo ordenado");
        Imprimir(A);
        System.out.println("\n");


    }
    private void quicksort2(int numeros[], int izq, int der) {
        if (izq >= der)
            return;
        int i = izq, d = der;
        if (izq != der) {
            int pivote;
            int aux;
            pivote = izq;
            while (izq != der) {
                while (numeros[der] >= numeros[pivote] && izq < der) {
                    der--;
                }
                while (numeros[izq] < numeros[pivote] && izq < der) {
                    izq++;
                }
                if (der != izq) {
                    aux = numeros[der];
                    numeros[der] = numeros[izq];
                    numeros[izq] = aux;
                    cont++;
                }
            }
            if (izq == der) {
                quicksort2(numeros, i, izq - 1);
                quicksort2(numeros, izq + 1, d);
            }
            } else
                 return;
        return;
    }
    private void Imprimir(int[] B){
        String cadena = "";
        for (int i = 0; i < B.length; i++){
            cadena += "["+ B[i]+"],";
        }
        System.out.println(cadena);
    }
}
