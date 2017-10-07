package Tools;

import java.util.*;

public class ConcatString {

    public static <T> T[] concat(T[] first, T[] second) {
        T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

    public static <T> T[] concatAll(T[] first, T[]... rest) {
        int totalLength = first.length;
        for (T[] array : rest) {
            totalLength += array.length;
        }
        T[] result = Arrays.copyOf(first, totalLength);
        int offset = first.length;
        for (T[] array : rest) {
            System.arraycopy(array, 0, result, offset, array.length);
            offset += array.length;
        }
        return result;
    }

    /**
     * simply test the functionality
     */
    public static void main(String args[]) {
        Integer[] array_1 = new Integer[] {1,2,3};
        Integer[] array_2 = new Integer[] {2,3,4,5};
        System.out.println(Arrays.toString(concat(array_1, array_2)));
        System.out.println(Arrays.toString(concatAll(array_1, array_2)));
    }
}
