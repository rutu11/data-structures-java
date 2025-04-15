import java.util.ArrayList;

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
    //2 5 1 3 6 --- low = 0, high = 4
    //mid = 4+0/2 == 2 --> [2 5 1] [3 6]
    //mid = 2+0/2 = 1 [2 5] [1]        [3] [6]

    public static void mergeSort(int[] arr, int low, int high){
        if(low >= high) return;

        int mid = (high+low)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    public static void merge(int[] arr, int low, int mid, int high){
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else{
                temp.add(arr[right]);
                right++;
            }
        }
        while(left <= mid){
            temp.add(arr[left]);
            left++;
        }
        while(right <= high){
            temp.add(arr[right]);
            right++;
        }

        for(int i=low; i<=high; i++) {
            arr[i] = temp.get(i - low);
        }
    }
}
