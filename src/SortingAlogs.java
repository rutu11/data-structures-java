public class SortingAlogs {

    private static void swap(int[] arr, int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void printValues(int[] arr) {
        for(int i: arr){
            System.out.print(i+" ");
        }
    }

    //SELECT MINIMUM AND SWAP
    public static void selectionSort(int[] arr){
        for(int i=0; i < arr.length-1; i++){
            int minIndex = i;
            for(int j=i+1; j< arr.length; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
        printValues(arr);
    }

    //PUSH MAXIMUM TO THE LAST BY ADJACENT SWAPS
    public static void bubbleSort(int[] arr){
        for(int i=arr.length; i >=1; i--){
//        for(int i=0; i < arr.length-1; i++){
            int swapped = 0;
            for(int j=0; j < i-1; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                    swapped = 1;
                }
            }
            if(swapped == 0){
                break;
            }
            if(swapped == 1){
                System.out.println("largest: "+arr[arr.length-1]);
            }
        }
       printValues(arr);
    }

    //TAKE AN ELEMENT AND PLACE IT IN IT'S CORRECT ORDER
    public static void insertionSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            int j = i;
            while(j > 0 && arr[j-1] > arr[j]){
                swap(arr, j-1, j);
                j--;
            }
        }
        printValues(arr);
    }
}
