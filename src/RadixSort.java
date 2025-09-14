import java.util.Arrays;

public class RadixSort {
    public void sort(Integer[] integers){
        String[] strings = new String[integers.length];
        String[] tempStrings = new String[integers.length];
        int max = integers[0];
        int digits = 1;
        int count = 0;

        //Get the highest number
        for(int i = 1; i<integers.length; i++){
            if(integers[i]>max){
                max = integers[i];
            }
        }

        //Get number of digits for highest number
        while(true){
            max/=10;
            if(max>1){
                digits+=1;
            }
            else break;
        }
        System.out.println("Digits: " + digits);

        //Convert Integer array to string array
        for(int i = 0; i<integers.length; i++){
            strings[i] = integers[i].toString();
        }

        //Add 0s to strings to match number of digits
        for(int i = 0; i<strings.length; i++){
            while(strings[i].length()<digits){
                strings[i] = "0" + strings[i];
            }
        }

        //Sort string array
        for(int i = digits - 1; i>=0; i--){
            for(int j = 0; j<10; j++){
                for(int k = 0; k < strings.length; k++){
                    if(strings[k].charAt(i) == (j + "").charAt(0)){
                        tempStrings[count] = strings[k];
                        count++;
                    }
                }
            }
            for(int j = 0; j< strings.length; j++){
                strings[j] = tempStrings[j];
            }
            count = 0;
        }

        //Convert String array to Integer array
        for(int j = 0; j< strings.length; j++){
            integers[j] = Integer.parseInt(strings[j]);
        }

    }
}
