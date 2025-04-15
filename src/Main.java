public class Main {

    public static void main(String[] args) {
        int[] arr = {3, 8, 9, 2};
        int[] arr3 = {4, 18, 9, 2};
        int[] arr2 = {40, 18, 59, 21, 1};

        SortingAlogs.mergeSort(arr2, 0, arr2.length-1);

//        SortingAlogs.selectionSort(arr);
//        SortingAlogs.bubbleSort(arr3);
//        SortingAlogs.insertionSort(arr2);

        for(int i: arr2){
            System.out.print(" "+i);
        }

    }


}