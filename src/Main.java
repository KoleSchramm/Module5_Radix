public class Main {
    public static void main(String[] args) {
        Integer[] integers = {783, -99, 472, 182, -264, -543, 356, 295, -692, 491, -94};
        RadixSort radixSort = new RadixSort();

        System.out.println("Initial array: ");
        for(int i = 0; i < integers.length; i++){
            System.out.print(integers[i] + ", ");
        }
        System.out.println();

        radixSort.sort(integers);

        System.out.println("Full sorted array: ");
        for(int i = 0; i < integers.length; i++){
            System.out.print(integers[i] + ", ");
        }
    }
}