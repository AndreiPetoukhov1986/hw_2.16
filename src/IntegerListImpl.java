import exception.ArrayIntegerIsFullException;
import exception.ElementNonFoundException;
import exception.InvalidIndexException;
import exception.ItemIsNullException;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {
    private final Integer[] arrayInteger;
    private int size;

    public IntegerListImpl() {
        arrayInteger = new Integer[100_000];
    }

    public IntegerListImpl(int initSize) {
        arrayInteger = new Integer[initSize];
    }

    @Override
    public Integer add(Integer item) {
        validateSize();
        validateItem(item);
        arrayInteger[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validateSize();
        validateIndex(index);
        validateItem(item);
        if (index == size) {
            arrayInteger[size++] = item;
            return item;
        }
        System.arraycopy(arrayInteger, index, arrayInteger, index + 1, size - index);
        arrayInteger[index] = item;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        arrayInteger[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validateItem(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new ElementNonFoundException();
        }
        if (index != size) {
            System.arraycopy(arrayInteger, index + 1, arrayInteger, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);
        Integer item = arrayInteger[index];
        if (index != size) {
            System.arraycopy(arrayInteger, index + 1, arrayInteger, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size - 1; i++) {
            if (item.equals(arrayInteger[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (item.equals(arrayInteger[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return arrayInteger[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(otherList.toArray(), arrayInteger);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(arrayInteger, size);
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new ItemIsNullException();
        }
    }

    private void validateSize() {
        if (size == arrayInteger.length) {
            throw new ArrayIntegerIsFullException();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new InvalidIndexException();
        }
    }

    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    public static void sortBubble(Integer[] arr) {                  //пузырьковая сортировка
        for (int i = 0; i < arr.length - 1; i++) {
            for (int i1 = 0; i1 < arr.length - 1 - i; i1++) {
                if (arr[i1] > arr[i1+1]) {
                    swapElements(arr, i1, i1 + 1);
                }
            }
        }
    }

    public static void sortSelection(Integer[] arr) {                   //сортировка выбором
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = arr.length-1; j >= i; j--) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
                swapElements(arr, i, minElementIndex);
            }
        }
    }


    public static void sortInsertion(Integer[] arr) {               //сортировка вставкой
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public static boolean binarySearch(Integer[] arr, Integer element){
       int min = 0;
       int max = arr.length-1;
       while(min<=max){
           int mid = (min+max)/2;
           if(element==arr[mid]){
               return true;
           }
           if(element>arr[mid]){
               min=mid+1;
           } else {
               max=mid-1;
           }
       }
       return false;
    }
}
