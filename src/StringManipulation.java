import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StringManipulation {
    public static void main(String[] args) {
        System.out.println("*********** EASY ***************");
        String str = "Hello world";
        System.out.println("1. Write a program to reverse a given string without using the built-in reverse function: "+str);
        reverseString(str);

        System.out.println("**************************");
        String palindromeStr = "A man a plan a canal Panama";
        System.out.println("2. Check if a string is a palindrome (reads the same forwards and backwards). " +
                "Ignore case and spaces "+palindromeStr);
        palindromeStr = palindromeStr.toLowerCase().replace(" ","");
        checkPalindrome(palindromeStr);

        System.out.println("**************************");
        String sentence = "Today is Saturday".toLowerCase();
        System.out.println("3. Count the number of vowels and consonants in a given string: "+sentence);
        countVowelsCon(sentence);

        System.out.println("**************************");
        String strWithDups = "Java is fun and Java is powerful";
        System.out.println("4. Remove duplicate characters from a string: "+strWithDups);

        String withoutDupsWords = Arrays.stream(strWithDups.split(" "))
                .distinct().collect(Collectors.joining(" "));
        System.out.println("String without duplicate WORDS: "+withoutDupsWords);

        String withoutDupsChar = strWithDups.replace(" ", "").chars()
                .distinct().mapToObj(x -> String.valueOf((char) x)).collect(Collectors.joining());
        System.out.println("String without duplicate CHARACTER: "+withoutDupsChar);

        System.out.println("**************************");
        System.out.println("5. Check if two strings are anagrams (contain the same characters, but in a different order).");
        String str1 = "triangle";
        String str2 = "integral";
        checkAnagram(str1, str2);

        System.out.println("\n********* INTERMEDIATE ****************");
        System.out.println("6. Count the frequency of each character in a string: "+sentence);
        countFreqofChar(sentence);

        System.out.println("**************************");
        String str3 = "swiss";
        System.out.println("7. Find the first non-repeated character in a string: "+str3);
        Character res = findNonRepChar(str3);

        if(res != null){
            System.out.println("First non-repeated character: "+res);
        } else{
            System.out.println("No Unique character");
        }



//
//        Substring Occurrences:
//        Find the number of occurrences of a substring within a string.
//
//                String Rotation:
//        Check if one string is a rotation of another string.
//
//        Replace Characters:
//        Replace all occurrences of a character in a string with another character.
    }

    public static Character findNonRepChar(String s){
        Map<Character, Integer> nonRep = new LinkedHashMap<>();

        for(char c: s.toCharArray()){
            nonRep.put(c, nonRep.getOrDefault(c, 0)+1);
        }
        for(Map.Entry<Character, Integer> entry: nonRep.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return null;
    }

    public static void countFreqofChar(String sentence){
        int[] charArr = new int[26]; //Define an arr of a to z

        for(int i=0; i< sentence.length(); i++){
            if(Character.isLetter(sentence.charAt(i))){
                charArr[sentence.charAt(i) - 'a'] += 1;
            }
        }
        for(int i=0; i<charArr.length; i++){
            if(charArr[i] != 0){
                System.out.print((char)(i + 'a')+": "+charArr[i]+", ");
            }
        }

//  --------------OTHER WAY--------------
//        HashMap<Character, Integer> countFreq = new HashMap<>();
//        sentence = sentence.replace(" ","");
//        for(int i=0; i<sentence.length(); i++){
//            countFreq.put(sentence.charAt(i), countFreq.getOrDefault(sentence.charAt(i),0)+1);
//        }
//        System.out.println(countFreq);
    }

    public static void checkAnagram(String s1, String s2){
        if(s1.isEmpty() || s2.isEmpty() || s1.length() != s2.length()){
            System.out.println("Not an Anagram");
            return;
        }
        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();

        for(int i=0; i< s1.length(); i++){
            countS.put(s1.charAt(i), countS.getOrDefault(s1.charAt(i),0)+1);
        }

        for(int j=0; j<s2.length(); j++){
            countT.put(s2.charAt(j), countT.getOrDefault(s2.charAt(j),0)+1);
        }
        System.out.println("Is "+s1+", "+s2+" anagram?: "+countS.equals(countT));

//  --------------OTHER WAY--------------
//        char[] sArr = s1.toCharArray();
//        char[] tArr = s2.toCharArray();
//        Arrays.sort(sArr);
//        Arrays.sort(tArr);
//        System.out.println(Arrays.equals(sArr, tArr));

    }

    public static void reverseString(String s){
        StringBuilder reversedStr = new StringBuilder();
        for(int i = s.length()-1; i >= 0; i--){
//            res += s.charAt(i); //creates multiple string objects due to immutability.
            reversedStr.append(s.charAt(i));
        }
        System.out.println(s+" -- reversed: "+reversedStr);
    }

    public static void checkPalindrome(String palindromeStr){
        int left = 0, right = palindromeStr.length()-1;
        boolean isPalindrome = true;

        while(left < right){
            if(palindromeStr.charAt(left) != palindromeStr.charAt(right)){
                System.out.println(palindromeStr+" is not a Palindrome");
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }
        if(isPalindrome){
            System.out.println(palindromeStr+" is a Palindrome.");
        }
    }

    public static void countVowelsCon(String sentence){
        String vowelSet = "aeiou";

        int vowels = 0, consonants = 0;
        for(int i=0; i< sentence.length(); i++){
            char character = sentence.charAt(i);
            if(vowelSet.indexOf(character) != -1){
                vowels++;
            }
            else if(character >= 'a' && character <= 'z'){
                consonants++;
            }
        }
        System.out.println("Vowels: "+vowels+" Consonants: "+consonants+" in sentence: "+sentence);
    }
}

