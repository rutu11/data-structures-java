import common.CommonUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayProblems {
    public static void reverseArr(int[] arr) {
        //2. Using 2pointer -- TIME: O(N), SPACE: O(1)
        int i = 0, j = arr.length - 1, n = arr.length;

        System.out.println("Before reversing arr");
        CommonUtil.printArray(arr);;

        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        System.out.println("After reversing arr");
        CommonUtil.printArray(arr);;

/* 1. Using Extra space --  TIME: O(N), SPACE: O(N)
        int n = arr.length;
        int[] temp = new int[n];
        System.out.println("Before reversing arr");
        CommonUtil.printArray(arr);;

        for(int i=0; i<n; i++){
            temp[i] = arr[n-i-1];
        }
        for(int i=0; i<n; i++){
            arr[i] = temp[i];
        }
        System.out.println("\nAfter reversing arr");
        CommonUtil.printArray(arr);;
         */
    }

    public static void reverseInGroups(int[] arr, int k){
        int n = arr.length;
        if(k == 1){
            System.out.println("Unchanged array..");
            return;
        }

//        TIME: O(N), SPACE: O(1)
        for(int i=0; i < n; i = i + k){
            int left = i;
            int right = Math.min(i+k-1, n-1);

            while(left < right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        System.out.println("Array is reverse in groups of k: "+k);
        CommonUtil.printArray(arr);;
    }

    public static void secondLargest(int[] arr) {
        int maxV = Integer.MIN_VALUE, secondV = Integer.MAX_VALUE;

        if (arr.length == 0 || arr.length == 1) {
            System.out.println("No second largest element found!");
            return;
        }

        //TIME: O(N), SPACE: O(1)
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxV) {
                secondV = maxV;
                maxV = arr[i];
            }
            if (arr[i] < maxV && arr[i] > secondV) {
                secondV = arr[i];
            }
        }

        System.out.println("Second largest element: " + secondV);

    }

    public static void thirdLargest(int[] arr) {
        if (arr.length < 3) {
            System.out.println("No third largest element found!");
            return;
        }

        //TIME: O(N), SPACE: O(1) -- ALL ELES ARE DISTINCT
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > first) {
                third = second;
                second = first;
                first = arr[i];
            } else if (arr[i] > second) {
                third = second;
                second = arr[i];
            } else if (arr[i] > third) {
                third = arr[i];
            }
        }
        System.out.println("Third largest element: " + third);

        //TC: O(n log n) -- IF ARR HAS UNIQUE ELES
//        Arrays.sort(arr);
//        System.out.println("Third largest element: " + arr[arr.length - 3]);

    }

    public static void getMaxMin(int[] arr) {
        int maxV = Integer.MIN_VALUE, minV = Integer.MAX_VALUE;
        if (arr.length == 0) {
            System.out.println("No Max and Min element");
            return;
        } else if (arr.length == 1) {
            maxV = arr[0];
            minV = arr[0];
        }

        // TIME: O(N), SPACE: O(1)
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxV) {
                maxV = arr[i];
            }
            if (arr[i] < minV) {
                minV = arr[i];
            }
        }

        System.out.println("Max: " + maxV + " ,Min: " + minV);
    }

    public static void threeGreatCandidates(int[] arr) {
        //Greedy approach - TIME: O(N), SPACE: O(1)
        //-2 -3 2 4 5 -- 1st-> -2*-3*5=30, 2nd->2*4*5=40 --> Max

        //FIND MAX -- FIRST, SECOND, THIRD
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;

        //FIND MIN -- FIRST, SECOND
        int firstMin = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > first) {
                third = second;
                second = first;
                first = arr[i];
            } else if (arr[i] > second) {
                third = second;
                second = arr[i];
            } else if (arr[i] > third) {
                third = arr[i];
            }

            if (arr[i] < secondMin) {
                firstMin = secondMin;
                secondMin = arr[i];
            } else if (arr[i] < firstMin) {
                firstMin = arr[i];
            }
        }
        System.out.println("Three Great Candidates product: " + Math.max(first * second * third, firstMin * secondMin * first));
    }

    public static void moveAllZeroesToEnd(int[] arr){
        int count = 0;
        for(int i=0; i < arr.length; i++){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;

                count++;
            }
        }
        System.out.println("After moving all zeroes");
        CommonUtil.printArray(arr);;
    }

    //SORTED ARRAY
    public static void removeAllDuplicatesInplace(int[] arr){
        int slow = 1;
        for(int fast=1; fast<arr.length; fast++){
            if(arr[fast] != arr[fast-1]){
                arr[slow] = arr[fast];
                slow++;
            }
        }
        System.out.println("Sorted Array size without duplicate elements: "+slow);
        for(int i=0; i<slow; i++){
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
    }

    //UNSORTED ARRAY
    public static void removeDuplicates(int[] nums) {
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
        int keyCount = map.size();

        System.out.println("\nUnsorted array after shifting duplicates in the end with size: "+keyCount);
        for(int i=0; i<keyCount; i++){
            System.out.print(nums[i]+"\t");
        }
        System.out.println();
    }

    public static void maxConsecutiveBits(int[] arr){
        if(arr.length == 0){
            System.out.println("No elements to find max bits!");
            return;
        }

        int maxCount = 0, count = 1;
        for(int i=1; i<arr.length; i++){
            if(arr[i] == arr[i-1]){
                count++;
            }
            else {
                maxCount = Math.max(count, maxCount);
                count = 1;
            }
        }

        maxCount = Math.max(count, maxCount);
        System.out.println("Max consecutive ones: "+maxCount);
    }

    public static void chocolateDistribution(int[] arr, int m){
        int diff = Integer.MAX_VALUE;
        int maxChocolates = 0, minChocolates = 0;

        Arrays.sort(arr); //IF ARR WAS ARRAYLIST THEN Collections.sort(arr)
        for(int i=0; i <= arr.length - m; i++){
            minChocolates = arr[i];
            maxChocolates = arr[i+m-1];

            diff = Math.min(diff, maxChocolates - minChocolates);
        }

        System.out.println("\nDifference between maximum number of chocolates given to a student: "+diff);
    }

    public static void rotateRight(int[] nums, int k){
        int[] arr = Arrays.copyOf(nums, nums.length);
        int n = nums.length;
        for(int i=0; i< n; i++){
            nums[(i+k)%n] = arr[i];
        }
        System.out.println("Before rotating the array");
        CommonUtil.printArray(arr);

        System.out.println("Rotating array to right by k: "+k);
        CommonUtil.printArray(arr);
    }

    public static void highestLowest(int[] arr){
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
        System.out.println("Maximum Frequency element: "+ maxEle+", Minimum Frequency element: "+minEle);
    }

    public static boolean isSorted(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i-1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        //1. Maximum and Minimum of an array
        int[] arr = {3, 5, 4, 1, 9}; //{3, 5, 4, 1, 9, 9, 5};
        getMaxMin(arr);
        secondLargest(arr);
        thirdLargest(arr);
        reverseArr(arr);
        System.out.println("Is the array sorted? "+isSorted(arr));

        int[] frequency = {1,3,4,1,1,4,2};
        highestLowest(frequency);

        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotateRight(nums, k);

        int[] bits = {0, 1, 0, 1, 1, 1, 1};
        maxConsecutiveBits(bits);

        int[] arrWithZeroes = {1, 2, 0, 4, 3, 0, 5, 0};
        moveAllZeroesToEnd(arrWithZeroes);

        int[] candidates = {-10, -3, 5, 6, -20};
        threeGreatCandidates(candidates);

        int[] reverTheArr = {1, 2, 3, 4, 5, 6, 7, 8};
        reverseInGroups(reverTheArr, 3);

        int[] sortedArrWithDup = {1,1,2,2,3,3,3};
        removeAllDuplicatesInplace(sortedArrWithDup);

        int[] unsortedArrWithDup = {1,2,1,4,5,2,5};
        removeDuplicates(unsortedArrWithDup);

        int[] packets = {3, 4, 1, 9, 56, 7, 9, 12};
        int students = 5;
        chocolateDistribution(packets, students);


    }
}