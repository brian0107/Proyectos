public class TestAlgorithm {

    //Arreglos desordenados de 42
    static int[] SortNumbers = {
            10 ,11, 12, 33, 24, 7, 533,
            26, 47, 68, 9, 34, 33, 35,
            54, 64, 32, 6, 74, 3, 66,
            81, 42, 89, 4, 192, 991, 922,
            0, 41, 61, 89, 22, 113, 456,
            134,753, 785, 443, 999, 100, 343};

    static int[] SortNumbersHeap = {
            10 ,11, 12, 33, 24, 7, 533,
            26, 47, 68, 9, 34, 33, 35,
            54, 64, 32, 6, 74, 3, 66,
            81, 42, 89, 4, 192, 991, 922,
            0, 41, 61, 89, 22, 113, 456,
            134,753, 785, 443, 999, 100, 343
    };

    static int[] SortNumbersShell = {
            10 ,11, 12, 33, 24, 7, 533,
            26, 47, 68, 9, 34, 33, 35,
            54, 64, 32, 6, 74, 3, 66,
            81, 42, 89, 4, 192, 991, 922,
            0, 41, 61, 89, 22, 113, 456,
            134,753, 785, 443, 999, 100, 343
    };

    //Elements = 54
    static int [] SearchNumbers = {
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
            12, 15, 32, 45, 67, 75, 81, 82, 83,
            84, 85, 86, 87, 88, 89, 90, 91, 100,
            102, 103, 106, 108, 110, 122, 124, 126,
            130, 134, 135, 194, 195, 196, 197, 199,
            239, 359, 493, 494, 594, 600, 602, 702
    };

    public static void main(String[] args) {
        //new Secuencial(SearchNumbers, 602);
        //new BinarySearch(SearchNumbers, 602);
        //new BubbleSort(SortNumbers);
        //new HeapSort(SortNumbersHeap);
        new ShellSort(SortNumbersShell);
    }
}
