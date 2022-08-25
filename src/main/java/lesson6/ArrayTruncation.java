package lesson6;


import java.util.Arrays;

public class ArrayTruncation {

    public int[] truncation(int[] arr) {
        int lastFour = 0;

        if (Arrays.stream(arr).noneMatch(s -> s == 4)) {
            throw new RuntimeException();
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) {
                lastFour = i;
            }
        }
        return Arrays.copyOfRange(arr, lastFour + 1, arr.length);
    }

    public static boolean isArrContainsNumbersOneAndFour(int[] arr) {
        if (!Arrays.stream(arr).allMatch(s -> s == 4 || s == 1)) {
            return false;
        }
        return Arrays.stream(arr).anyMatch(s -> s == 4) & Arrays.stream(arr).anyMatch(s -> s == 1);
    }
}
