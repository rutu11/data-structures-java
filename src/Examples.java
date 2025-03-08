import java.util.*;

public class Examples {
    public static void main(String[] args) {
        int[] nums = {2,2,1};
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }
            else{
                map.put(num,1);
            }
        }
//        Examples.HighestLowest(arr);
//
//        System.out.println(Examples.getSecondLargest(arr));
//
//        int[] arr2 = {11,2,3};
//        System.out.println("isSorted?? "+isSorted(arr2));
//
//        int[] arr3 = {0,0,1,1,1,2,2,3,3,4};
//        System.out.println("unique eles: "+Examples.removeDuplicates(arr3));

//        int[] nums = {1,2,3,4,5,6,7};
//        int k = 3;
//        rotateRight(nums, k);

    }

    public static void rotateRight(int[] nums, int k){
        int[] arr = Arrays.copyOf(nums, nums.length);
        int n = nums.length;
        for(int i=0; i< n; i++){
            nums[(i+k)%n] = arr[i];
        }
        for(int i: nums){
            System.out.print(i+" ");
        }
    }

    public static int getSecondLargest(int[] arr) {
        if(arr == null || arr.length < 2){
            return -1;
        }
        int largest = Integer.MIN_VALUE;
        int secondL = Integer.MIN_VALUE;

        for(int num: arr){
            if(num > largest){
                secondL = largest;
                largest = num;
            }
            else if(num > secondL && num < largest){
                secondL = num;
            }
        }
        return (secondL == Integer.MIN_VALUE) ? -1: secondL;
    }

    public static void HighestLowest(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        System.out.println(map);

        int maxFreq = 0, minFreq = Integer.MAX_VALUE, maxEle = 0, minEle = 0;

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int count = entry.getValue();
            int ele = entry.getKey();
            if(count > maxFreq){
                maxFreq = count;
                maxEle = ele;
            }
            if(count < minFreq){
                minFreq = count;
                minEle = ele;
            }
        }
        System.out.println("Max ele "+ maxEle+" Min ele "+minEle);
    }

    public static boolean isSorted(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i-1])
                return false;
        }
        return true;
    }
    public static int removeDuplicates(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0; i< nums.length; i++){
            if(map.containsKey(nums[i])){
                continue;
            } else{
                map.put(nums[i],1);
                nums[count] = nums[i];
                count++;
            }
        }
        int keyCount = map.keySet().size();
        for(int i: nums){
            System.out.print(i+" ");
        }
        return keyCount;
    }



}
