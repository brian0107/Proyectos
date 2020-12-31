public class Secuencial {

    protected int count = 0;

    public Secuencial(int[] arr, int get){
        System.out.println("|---------------------------|");
        System.out.println("| Algorithm - S. Secuencial |");
        System.out.println("|---------------------------|");
        long timeStart  = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == get){
                System.out.println("Get -> " + arr[i]);
                System.out.printf("Position -> %d%n", i);
                break;
            }
            count++;
        }
        long timeFinish = System.currentTimeMillis();
        System.out.println("Comparisons - > "+ count);
        System.out.println("Time -> " + (timeFinish - timeStart) + "ms ");
        System.out.println("_______________________________________");
    }
}
