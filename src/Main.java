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
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);

        System.out.println(Arrays.toString(arr1));
        System.out.println("");

        System.out.println("сортировка выбором");
        long start1 = System.currentTimeMillis();
        IntegerListImpl.sortSelection(arr1);                     //сортировка выбором
        System.out.println(System.currentTimeMillis() - start1);
        System.out.println(Arrays.toString(arr1));
        System.out.println("");

        System.out.println("пузырьковая сортировка");
        long start2 = System.currentTimeMillis();
        IntegerListImpl.sortBubble(arr2);                        //пузырьковая сортировка
        System.out.println(System.currentTimeMillis() - start2);
        System.out.println(Arrays.toString(arr2));
        System.out.println("");

        System.out.println("сортировка вставкой");
        long start3 = System.currentTimeMillis();
        IntegerListImpl.sortInsertion(arr3);                             //сортировка вставкой
        System.out.println(System.currentTimeMillis() - start3);
        System.out.println(Arrays.toString(arr3));
        System.out.println("");

        //  System.out.println(IntegerListImpl.binarySearch(arr3, 105));


    }

}