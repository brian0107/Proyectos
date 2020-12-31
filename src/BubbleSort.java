public class BubbleSort {

    protected int aux = 0;
    protected int[] sortArr;
    protected int count_I = 0;
    protected int count_J = 0;

    public BubbleSort(int[] arr){
        System.out.println("|-------------------------|");
        System.out.println("| Algorithm - Bubble Sort |");
        System.out.println("|-------------------------|");

        this.sortArr = arr;
        printArray(sortArr);

        long timeStart  = System.currentTimeMillis();

        for (int i = 0; i < sortArr.length; i++){
            for (int j = i + 1; j < sortArr.length; j++){
                if (sortArr[i] > sortArr[j]){
                    aux = sortArr[i];
                    sortArr[i] = sortArr[j];
                    sortArr[j] = aux;
                }
                count_J++;
            }
            count_I++;
        }
        long timeFinish = System.currentTimeMillis();
        System.out.println("Comparisons in I -> "+ count_I);
        System.out.println("Comparisons in J -> "+ count_J);
        System.out.println("Total comparisons -> "+ (count_I + count_J));
        System.out.println("timeStart -> " + timeStart);
        System.out.println("timeFinish -> "+ timeFinish);
        System.out.println("Time -> " + (timeFinish - timeStart) + "ms ");
        printArray(sortArr);
        System.out.println("_______________________________________");
    }

    protected void printArray(int[] arr){
        String print = "";
        for (int i = 0; i < arr.length; i++){
            print += "["+arr[i]+"],";
        }
        System.out.println("Sort -> "+ print);
    }
}
