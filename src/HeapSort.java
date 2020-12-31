public class HeapSort {

    protected int count_I = 0;
    protected int count_J = 0;
    protected int count_r = 0;
    protected int count_l = 0;
    protected int count_largest = 0;
    protected int[] sortArr;
    protected int n;

    public HeapSort(int[] arr){
        System.out.println("|-------------------------|");
        System.out.println("| Algorithm - Heap Sort   |");
        System.out.println("|-------------------------|");

        sortArr = arr;
        printArray(sortArr);
        n = sortArr.length;
        long timeStart = System.currentTimeMillis();
        for (int i = n/2-1; i >= 0; i--){
            heapify(sortArr, n, i);
            count_I++;
        }

        for (int j = n-1; j > 0; j--){
            int aux = sortArr[0];
            sortArr[0] = sortArr[j];
            sortArr[j] = aux;
            heapify(sortArr, j, 0);
            count_J++;
        }
        long timeFinish = System.currentTimeMillis();
        System.out.println("Comparisons in I -> "+ count_I);
        System.out.println("Comparisons in J -> "+ count_J);
        System.out.println("Comparisons in r -> "+ count_r);
        System.out.println("Comparisons in l -> "+ count_l);
        System.out.println("Comparisons in largest -> "+ count_largest);
        System.out.println("Total comparisons -> "+ (count_I + count_J + count_r + count_l + count_largest));
        System.out.println("timeStart -> " + timeStart);
        System.out.println("timeFinish -> " + timeFinish);
        System.out.println("Time -> " + (timeFinish - timeStart) + "ms ");
        printArray(sortArr);
        System.out.println("_______________________________________");
    }

    protected void heapify(int arr[], int n, int i){
        int largest = i;
        int l = 2*i+1;
        int r = 2*i+2;

        if (l < n && arr[l] > arr[largest]){
            largest = l;
            count_l++;
        }
        if (r < n && arr[r] > arr[largest]){
            largest = r;
            count_r++;
        }
        if (largest != i){
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            count_largest++;
            heapify(arr, n, largest);
        }
    }

    protected void printArray(int[] arr){
        String print = "";
        for (int i = 0; i < arr.length; i++){
            print += "["+arr[i]+"],";
        }
        System.out.println("Sort -> "+ print);
    }
}
