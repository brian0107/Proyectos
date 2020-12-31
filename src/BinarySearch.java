public class BinarySearch {

    protected int bottom = 0;
    protected int center = 0;
    protected int top;
    protected int count = 0;

    public BinarySearch(int[] arr, int get){
        System.out.println("|------------------------|");
        System.out.println("| Algorithm - S. Binary  |");
        System.out.println("|------------------------|");

        long timeStart = System.currentTimeMillis();

        top = arr.length - 1;
        while (bottom <= top){
            center = (top + bottom) / 2;
            if (arr[center] == get){
                System.out.println("Get -> "+arr[center]);
                System.out.println("Position -> "+center);
                break;
            }else if (get < arr[center]){
                top = center - 1;
            }else{
                bottom = center + 1;
            }
            count++;
        }

        long timeFinish = System.currentTimeMillis();

        System.out.println("Comparisons -> "+ count);
        System.out.println("Time -> "+ (timeFinish - timeStart) + "ms ");
        System.out.println("_______________________________________");
    }
}
