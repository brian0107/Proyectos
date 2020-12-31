package Paquete;

public class BusquedaBinaria {

    protected int bottom = 0;
    protected int center = 0;
    protected int top;
    private int cont = 0;


    public BusquedaBinaria(int[] A, int buscar){
        System.out.println("|| BUSQUEDA BINARIA ||");


        long tiempoInicio = System.currentTimeMillis();

        top = A.length - 1;
        while (bottom <= top){
            center = (top + bottom) / 2;
            if (A[center] == buscar){
                System.out.println("Numero encontrado = "+ A[center]);
                System.out.println("Posicion ="+center);
                break;
            }else if (buscar < A[center]){
                top = center - 1;
            }else{
                bottom = center + 1;
            }
            cont++;
        }

        long tiempoFinal = System.currentTimeMillis();
        System.out.println("Comparaciones totales = "+ cont);
        System.out.println("Tiempo = "+ (tiempoFinal - tiempoInicio) + "ms ");
        System.out.println("\n");
    }
}
