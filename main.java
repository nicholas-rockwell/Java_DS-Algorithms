import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

class Java {

    //RepeatingLetter
    static Boolean isUniqueCharacters(String str) {
        if (str.length() > 128) return false; //edge case for char value being over 128 (outside alphabet)

        boolean[] char_set = new boolean[128]; //creating a bool area for every possible upper or lowercase letter
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    } // time comlexity is O(n), where n is the length of the string. 
      // space complexity is O(c), where c is the size of the character set, though it'll likely be O(1).

    //IsPermutation
    static String sort(String s) {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    static Boolean permutations(String str, String str2) {
        if (str.length() != str2.length()) {
            return false;
        }
        return sort(str).equals(sort(str2));
    }

    //LongestPalindrome
    static int longestPalindrome(String str) {
        HashSet<Character> set = new HashSet<>();
        int len = 0;

        for(char c : str.toCharArray()) {
            if(set.contains(c)) {
                len += 2;
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        if(set.size() > 0) {
            return len + 1;
        } else {
            return len;
        }
    }

    //MinimumWindowSubstring
    static String minimumSubstring(String s, String t) {
        if (s == null || t == null) {
            return "";
        }

        String res = "";
        int[] letterCount = new int[128];
        int left = 0;
        int count = 0; 
        int minLen = Integer.MAX_VALUE;

        for (char c : t.toCharArray()) {
            letterCount[c]++;
        }

        for (int right = 0; right < s.length(); right++) {
            if (--letterCount[s.charAt(right)] >= 0) {
                count++;
                while (count == t.length()) {
                    if (minLen > right - left + 1) {
                        minLen = right - left + 1;
                        res = s.substring(left, right + 1);
                    } 
                    if (++letterCount[s.charAt(left)] > 0) {
                        count--;
                    }
                    left++;
                }
            }
        }
        return res;
    }

    //IntegerSortByBits
    static int[] sortByBits(int[] x) {
        for (int i = 0; i < x.length; i++) {
            x[i] += Integer.bitCount(x[i]) * 1001;
        }

        Arrays.sort(x);;

        for(int i = 0; i < x.length; i++) {
            x[i] %= 10001;
        }

        return x;
    }



    public static void main(String[] args) {
 
        System.out.println("Hello World!");



        //Array

          //SortIntegersbyBits
        int[] x = new int[]{1};
        int[] num = sortByBits(x);
        System.out.println(num[0]);
        

        //ArrayList

        // ArrayList<String> myList = new ArrayList<String>();
        // myList.add("Nicholas");
        // myList.add("Aly");
        // myList.add("Boba");
        // myList.add("Mochi");
        // System.out.println(myList);
            

        //Strings

            //Repeating Letters
        // String repeatNoLetter = "monkey";
        // String repeatLetters = "banana";
        // System.out.println(isUniqueCharacters(repeatNoLetter));
        // System.out.println(isUniqueCharacters(repeatLetters));

          //IsPermutation
        // String notPermutation1 = "ABC";
        // String notPermutation2 = "CDE";
        // System.out.println(permutations(notPermutation1, notPermutation2)); 
        // String isPermutation = "BAT";
        // String isPermutation1 = "TAB";
        // System.out.println(permutations(isPermutation, isPermutation1)); 

          //LongestPalindrome
        // String palindrome = "abaaaadjY";
        // System.out.println(longestPalindrome(palindrome));

          //MinimumWindowSubstring
        // String substring1 = "ADOBECODEBANC";
        // String substring2 = "ABC";
        // System.out.println(minimumSubstring(substring1, substring2));
    }
}