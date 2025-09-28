import java.util.ArrayList;
import java.util.Collections;

public class RadixSort {
    public void sort(Integer[] integers){
        //Split array into negatives and positives
        ArrayList<Integer> negatives = new ArrayList<>();
        ArrayList<Integer> positives = new ArrayList<>();
        for(int i = 0; i<integers.length; i++){
            if(integers[i]<0){
                negatives.add(integers[i]);
            }
            else{
                positives.add(integers[i]);
            }
        }

        //Print positives and negatives
        System.out.println("Negatives:");
        for(int i=0; i<negatives.size(); i++){
            System.out.print(negatives.get(i)+ " ");
        }
        System.out.println();
        System.out.println("Positives:");
        for(int i=0; i<positives.size(); i++){
            System.out.print(positives.get(i) + " ");
        }
        System.out.println();

        //Set negatives to positive
        for(int i = 0; i< negatives.size(); i++){
            negatives.set(i, Math.abs(negatives.get(i)));
        }

        //Sort positives and negatives
        System.out.println("Sorting positives and negatives separately.");
        sortHalves(positives);
        sortHalves(negatives);

        //Set negatives back to negative and reverse order
        for(int i = 0; i< negatives.size(); i++){
            negatives.set(i, negatives.get(i)*-1);
        }
        ArrayList<Integer> flippedNegatives = new ArrayList<>();
        for(int i = negatives.size() - 1; i>=0; i--){
            flippedNegatives.add(negatives.get(i));
        }

        //Print positives and negatives
        System.out.println("Negatives:");
        for(int i=0; i<flippedNegatives.size(); i++){
            System.out.print(flippedNegatives.get(i)+ " ");
        }
        System.out.println();
        System.out.println("Positives:");
        for(int i=0; i<positives.size(); i++){
            System.out.print(positives.get(i) + " ");
        }
        System.out.println();

        //Combine positives and negatives
        for(int i = 0; i< flippedNegatives.size(); i++){
            integers[i] = flippedNegatives.get(i);
        }
        for(int i = 0; i< positives.size(); i++){
            integers[i + flippedNegatives.size()] = positives.get(i);
        }
    }

    private void sortHalves(ArrayList<Integer> integers){
        int max = Collections.max(integers);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(integers, exp);
        }
    }

    private void countingSort(ArrayList<Integer> integers, int exp){
        int n = integers.size();
        ArrayList<Integer> output = new ArrayList<>(Collections.nCopies(n, 0));
        int[] count = new int[10];

        //Count number of each digit
        for (int i = 0; i < n; i++) {
            int digit = (integers.get(i) / exp) % 10;
            count[digit]++;
        }

        //Get last index of each digit
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        //make new array based on digit
        for (int i = n - 1; i >= 0; i--) {
            int digit = (integers.get(i) / exp) % 10;
            output.set(count[digit] - 1, integers.get(i));
            count[digit]--;
        }

        //Copy new array to original array
        for (int i = 0; i < n; i++) {
            integers.set(i, output.get(i));
        }
    }
}