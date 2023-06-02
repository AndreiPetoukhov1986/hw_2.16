import java.util.Arrays;
import java.util.Random;

public class Main {

    public static Integer[] generateRandomArray() {
        Random random=new Random();
        Integer[] arr=new Integer[100_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i]= random.nextInt(100_000)+100_000;
        }
        return arr;
    }

    public static void main(String[] args) {
        Integer[] arr1 = generateRandomArray();
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        System.out.println(Arrays.toString(arr1));
        System.out.println("");
    }

}