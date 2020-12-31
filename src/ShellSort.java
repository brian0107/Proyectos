public class ShellSort {

    protected int jump;
    protected int i;
    protected int j;
    protected int k;
    protected int aux;
    protected int[] sortArr;
    protected int count = 0;
    protected int count_I = 0;
    protected int count_JK = 0;

    public ShellSort(int[] arr){
        System.out.println("|-------------------------|");
        System.out.println("| Algorithm - Shell Sort  |");
        System.out.println("|-------------------------|");

        sortArr = arr;
        printArray(sortArr);
        jump = sortArr.length / 2;
        long timeStart  = System.currentTimeMillis();
        while (jump > 0){
            for (i = jump; i < sortArr.length; i++){
                j = i - jump;
                while (j >= 0){
                    k = j + jump;
                    if (sortArr[j] <= sortArr[k]){
                        break;
                    }else{
                        aux = sortArr[j];
                        sortArr[j] = sortArr[k];
                        sortArr[k] = aux;
                        j -= jump;
                    }
                    count_JK++;
                }
                count_I++;
            }
            jump = jump/2;
            count++;
        }
        long timeFinish = System.currentTimeMillis();
        System.out.println("Comparisons jump -> "+ count);
        System.out.println("Comparisons in I -> "+ count_I);
        System.out.println("Comparisons in JK -> "+ count_JK);
        System.out.println("Total Comparisons -> "+ (count + count_I + count_JK));
        System.out.println("timeStart -> " + timeStart);
        System.out.println("timeFinish -> " + timeFinish);
        System.out.println("Time -> " + (timeFinish - timeStart) + "ms ");
        System.out.println("_______________________________________");
        printArray(sortArr);
    }
    protected void printArray(int[] arr){
        String print = "";
        for (int i = 0; i < arr.length; i++){
            print += "["+arr[i]+"],";
        }
        System.out.println("Sort -> "+ print);
    }
}
