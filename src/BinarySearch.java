import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = {2, 10, 10, 12, 12, 12, 15, 22};
        int[] desArr = {35, 30, 24, 22, 10, 5}; // eles sorted in des order

        System.out.println("Element found at : "+binarySearch(arr, 12));
        System.out.println("Element found at : "+binarySearch(arr, 16));
        System.out.println("First occurrence found at : "+firstOccurrence(arr, 10));
        System.out.println("Last occurrence found at : "+lastOccurrence(arr, 10));

        System.out.println("Element in Descending arr: "+reverseBinarySearch(desArr, 22));

//        ORDER AGNOSTIC ARRAY
        int[] arr1 = {4, 5, 7, 10};
        orderAgnosticArr(arr1, 5);

        int[] arr2 = {30, 20, 10, 5, 1};
        orderAgnosticArr(arr2, 1);

        int[] arr3 = {30};
        orderAgnosticArr(arr3, 30);

        System.out.println("Count occurrence of element "+12+": "+countOccurrence(arr, 12));

        int[] rotateArr = {11, 10, 17, 2, 5, 6, 7};
        System.out.println("Rotated arr by: "+arrRotatedBy(rotateArr));

    }

    public static int binarySearch(int[] arr, int target){
        int start = 0, end = arr.length-1;
        while(start <= end){
            int mid = start + ((end-start)/2); // to avoid int overflow

            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid]  < target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }

    public static int reverseBinarySearch(int[] arr, int target){
        int start = 0, end = arr.length-1;

        while(start <= end){
            int mid = start + ((end-start)/2);

            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] < target){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }

        return -1;
    }

    public static int firstOccurrence(int[] arr, int target){
        int res = -1;
        int start = 0, end = arr.length-1;
        while(start <= end){
            int mid = start + ((end-start)/2);
            if(arr[mid] == target){
                res = mid;
                end = mid-1;
            }
            else if(arr[mid]  < target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }

        return res;
    }

    public static int lastOccurrence(int[] arr, int target){
        int res = -1;
        int start = 0, end = arr.length-1;

        while(start <= end){
            int mid = start + ((end-start)/2);

            if(arr[mid] == target){
                res = mid;
                start = mid+1;
            }
            else if(arr[mid] < target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }

        return res;
    }

    public static void orderAgnosticArr(int[] arr, int target){
        if(arr.length == 1){
            int res = arr[0] == target ? 0 : -1;
            System.out.println("Element found at: "+res);
        }
        if(arr.length > 1){
            if(arr[0] < arr[1]){
                System.out.println("Element found at: "+binarySearch(arr, target));
            }
            else{
                System.out.println("Element found at: "+reverseBinarySearch(arr, target));
            }
        }
    }

    public static int countOccurrence(int[] arr, int target){
        int first = firstOccurrence(arr, target);
        int last = lastOccurrence(arr, target);

        return Math.max(last - first + 1, 0);
    }
    //2, 5, 7, 8, 11, 15, 17 --> 8, 11, 15, 17, 2, 5, 7 --> rotated by 3
    public static int arrRotatedBy(int[] arr){
        int n = arr.length;
        int start = 0, end = n -1;

        if(arr[start] < arr[end]){
            return 0;
        }

        while(start <= end){
            int mid = start + ((end-start)/2);
            int next = (mid+1)% n;
            int prev = (mid+n -1)%n;

            if(arr[mid] < arr[prev] && arr[mid] < arr[next]){
                return mid;
            }
            if(arr[start] <= arr[mid]){
                start = mid+1;
            }
            else if(arr[mid] <= arr[end]){
                end = mid-1;
            }
        }
        return -1;
    }
}
