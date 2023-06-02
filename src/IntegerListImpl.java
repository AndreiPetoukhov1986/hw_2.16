import exception.ElementNonFoundException;
import exception.InvalidIndexException;
import exception.ItemIsNullException;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {
    private Integer[] arrayInteger;
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
            grow();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new InvalidIndexException();
        }
    }

    private void grow(){
        arrayInteger = Arrays.copyOf(arrayInteger, size+size/2);
    }

    public void sort(Integer[] arrayInteger){
        quickSort(arrayInteger, 0, arrayInteger.length-1);
    }

    public static void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }
        swapElements(arr, i + 1, end);
        return i + 1;
    }

    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }
}
