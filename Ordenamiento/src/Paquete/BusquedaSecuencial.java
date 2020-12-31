package Paquete;

public class BusquedaSecuencial {
    private int cont = 0;

    public BusquedaSecuencial(int[] A, int buscar){
        System.out.println("|| BUSQUEDA SECUENCIAL ||");

        long tiempoInicio = System.currentTimeMillis();

        for (int i = 0; i < A.length; i++){
            if (A[i] == buscar){
                System.out.println("Numero encontrado = " + A[i]);
                System.out.println("Posicion ="+i);
                break;
            }
            cont++;
        }
        long tiempoFinal = System.currentTimeMillis();
        System.out.println("Comparaciones totales = "+ cont);
        System.out.println("Tiempo = " + (tiempoFinal - tiempoInicio) + "ms ");
        System.out.println("\n");
    }
}
