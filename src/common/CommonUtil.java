package common;

public class CommonUtil {
    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int k = 0; k < n; k++) {
            System.out.print(arr[k] + "\t");
        }
        System.out.println();
    }

}
