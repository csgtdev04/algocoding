import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Excercises2 {
    public static void main(String[] args) {
        // Problem: 12
        int[] nums = { 8, 2, 4, 9 };
        int k = 13;
        System.out.println("Get Max Sum Less Than K: " + getMaxSumLessThanK(nums, k));

        // Problem: 13
        int[] a = { 8, 23, 2 };
        int[] b = { 2, 23, 8 };
        int[] result = getAnagramElements(a, b);
        System.out.println("Get anagram elements: " + Arrays.toString(result));

        // Problem: 14
        int[][] mat = { { 1, 2, 3 }, { 4, 1, 2 }, { 5, 4, 1 } };
        System.out.println("Is a Toeplitz matrix: " + getToeplitzMatrix(mat));

        // Problem: 15
        int[] arr = { 1, 1, 2, 3 };
        System.out.println("Value sort: " + Arrays.toString(getValueSort(arr)));

        // Problem: 16
        int num = 9669;
        System.out.println("Max Number: " + getMaxNumber(num));

        // Problem: 17
        int num1 = 7;
        System.out.println("Is perfect number: " + isPerfectNumber(num1));

        // Problem: 18
        List<List<String>> list = Arrays.asList(Arrays.asList("London", "New York"), Arrays.asList("New York", "Lima"),
                Arrays.asList("Lima", "Sao Paulo"));
        System.out.println("Get vacation destination: " + getVacationDestination(list));

        // Problem: 19
        int[] nums1 = { 2, 3, 5, 6, 3 };
        System.out.println("Update Array: " + Arrays.toString(updateArray(nums1)));

        // Problem: 20
        String[] words1 = { "a", "b", "c" };
        String[] words2 = { "a", "b", "d" };
        System.out.println("Compare strings (in array): " + checkStrings(words1, words2));

        // Problem: 21
        int num2 = 38;
        System.out.println("Is magical number: " + isMagicalNumber(num2));

        // Problem: 22
        String typed = "timmm";
        String name = "timmy";
        System.out.println("Is word contained: " + getIsWordContained(typed, name));

        // Problem: 23
        int[] nums3 = { 1, 2, 3, 4 };
        System.out.println("Get one fourth number: " + getOneFourth(nums3));

        // Problem: 24
        String s = "Aabb";
        System.out.println("Get acceptable string: " + getAcceptableString(s));

        // Problem: 25
        int candies = 3;
        int exchange = 4;
        System.out.println("Max Candies: " + getMaxCandies(candies, exchange));

        // Problem: 26
        int[] nums2 = { 4, 2, 9, 10, 3 };
        System.out.println("Smaller than array: " + Arrays.toString(getSmallerThan(nums2)));
    }

    public static int getMaxSumLessThanK(int[] nums, int k) {
        // Given an integer array, nums, return the maximum sum that exists between two
        // elements that is less than k.

        // Brute force solution O(n^2)
        int max_sum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int current_sum = nums[i] + nums[j];
                if (current_sum > max_sum && current_sum < k) {
                    max_sum = current_sum;
                }
            }
        }

        // Sliding window apprach O(n)
        int i = 0;
        int j = 1;
        max_sum = Integer.MIN_VALUE;
        while (true) {
            if (i >= nums.length - 1 && j >= nums.length - 1) {
                break;
            }
            int current_sum = nums[i] + nums[j];
            if (j == nums.length - 1) {
                i++;
                j = i + 1;
                continue;
            }
            if (current_sum > max_sum && current_sum < k) {
                max_sum = current_sum;
            }
            j++;
        }

        return max_sum;
    }

    // Saved for later (date: March 28/2021)
    public static int getDistinctCharacterSubstr(String s) {
        // Given a string, s, return the total number of substrings that only contain
        // one distinct character.

        int result = 0;

        return result;
    }

    public static int[] getAnagramElements(int[] a, int[] b) {
        int[] result = new int[a.length];

        // Brute Force - O(n^2)
        for (int i = 0; i < a.length; i++) {
            int a_element = a[i];
            for (int j = 0; j < b.length; j++) {
                int b_element = b[j];
                if (a_element == b_element) {
                    result[i] = j;
                }
            }
        }

        // return result;

        // HashMap approach - O(n)
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int index = 0;
        for (int i : b) {
            map.put(i, index);
            index++;
        }

        int[] result2 = new int[a.length];
        int temp = 0;
        for (int i : a) {
            int idX = map.get(i);
            result2[temp] = idX;
            temp++;
        }

        return result2;
    }

    // Saved for later (date: March 30/2021)
    public static boolean getToeplitzMatrix(int[][] mat) {
        return false;
    }

    // Still needs work
    public static int[] getValueSort(int[] arr) {
        // Given an integer array, nums, sort the array in increasing order based on
        // frequency of elements. If two numbers appear the same number of times, sort
        // them by their value in decreasing order.

        int[] res = new int[arr.length];

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int idX = 0;
        while (idX <= res.length) {
            int key = findMinInMap(map);
            for (int i = idX; i < (idX + map.get(key)) - 1; i++) {
                res[i] = key;
            }
            idX += map.get(key);
        }

        return res;
    }

    // Helper Method for getValueSort
    public static int findMinInMap(HashMap<Integer, Integer> map) {
        int min = Integer.MAX_VALUE;
        int key = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (min > entry.getValue() && key < entry.getKey()) {
                min = entry.getValue();
                key = entry.getKey();
            }
        }

        // int max = -1;
        // int temp = Integer.MAX_VALUE;
        // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        // if (max < entry.getValue() && temp > entry.getKey()) {
        // max = entry.getValue();
        // temp = entry.getKey();
        // }
        // }

        return key;
    }

    public static int getMaxNumber(int num) {
        // Given an integer, num, that consists of only two digits, sixes and nines,
        // return the largest number you can create by modifying one digit to be a six
        // or a nine.

        int max = num;
        int temp = 1;
        for (int i = num; i > 0; i /= 10) {
            int currentNum = i % 10;
            if (currentNum == 6) {
                if (max < num + (3 * temp)) {
                    max = num + (3 * temp);
                }
            }
            temp *= 10;
        }
        return max;
    }

    public static boolean isPerfectNumber(int num) {
        // Given an integer, num, return whether or not it is a perfect number.
        // Note: A perfect number is a positive number that is equal to the sum of its
        // positive divisors excluding itself.
        int sum = 0;

        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }

        return sum == num;
    }

    public static String getVacationDestination(List<List<String>> itenary) {
        // You are going on a vacation in which you need to take multiple planes to get
        // to your destination. You are given a list, flights, that represents a set of
        // your flights. Each flight is a list itself that contains two elements, the
        // departing city and the arriving city respectively. Return the destination
        // city.

        // flights = [["A", "B"], ["B", "C"]], return "C".
        // flights = [["A", "B"], ["C", "D"], ["B", "C"]], return "D".

        // Brute Force
        for (int i = 0; i < itenary.size(); i++) {
            String letter_to_find = itenary.get(i).get(1);
            boolean found = findDestination(itenary, letter_to_find);
            if (!found) {
                return letter_to_find;
            }
        }
        // Can also use set difference (add all index 1 to set then subtract index 0
        // that are common - see leetcode.)

        return null;
    }

    // Helper method
    private static boolean findDestination(List<List<String>> itenary, String letter_to_find) {
        for (int i = 0; i < itenary.size(); i++) {
            if (itenary.get(i).get(0).equals(letter_to_find)) {
                return true;
            }
        }
        return false;
    }

    public static int[] updateArray(int[] nums) {
        // Given an integer array, nums, replace each element with the largest value
        // that occurs to the right of it and return the array.
        // Note: The rightmost element should be replaced with -1.

        // nums = [5, 2, 3], return [3, 3, -1].
        // nums = [10, 2, 5, 8, 9], return [9,9,9,9,-1].
        // nums = [2, 3, 5, 6, 3], return [6, 6, 6, 3, -1]

        int max = nums[nums.length - 1];
        nums[nums.length - 1] = -1;

        for (int i = nums.length - 2; i >= 0; i--) {
            int temp = nums[i];
            nums[i] = max;
            if (temp > max) {
                max = temp;
            }
        }

        return nums;
    }

    public static boolean checkStrings(String[] a, String[] b) {
        // Given two string arrays, word1 and word2, return whether or not the two
        // arrays represent the same string.

        StringBuilder sba = new StringBuilder();
        StringBuilder sbb = new StringBuilder();

        for (String word : a) {
            sba.append(word);
        }

        for (String word : b) {
            sbb.append(word);
        }

        return sba.toString().equals(sbb.toString());

    }

    public static boolean isMagicalNumber(int num) {
        // Given a k-digit integer, num, return whether or not the number if magical.
        // Note: A magical numbers is a number in which the the sum of all its digits
        // raised to the kth power sum to the number itself.

        int temp = num;
        int power = 0;
        while (temp > 0) {
            power++;
            temp /= 10;
        }

        int sum = 0;
        for (int i = num; i > 0; i /= 10) {
            int curr = i % 10;
            sum += Math.pow(curr, power);
        }

        return sum == num;
    }

    public static boolean getIsWordContained(String typed, String name) {
        // You are typing on a broken keyboard trying to spell your friend’s name. Since
        // the keyboard is broken, sometimes when you press a key the key is typed one
        // or more times. Given a string typed and a string namereturn whether or not
        // you’ve successfully typed your friend’s name even though certain keys might
        // be repeated.
        // Note: Both strings will only contain lowercase alphabetical characters.

        return typed.contains(name);

    }

    public static int getOneFourth(int[] nums) {
        int greater_than = nums.length / 4;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ans = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value > greater_than) {
                ans = key;
            }
        }

        return ans;
    }

    public static String getAcceptableString(String str) {
        // Given a string, s, make it acceptable. An acceptable string is a string that
        // contains no two adjacent characters that are the same with one letter being
        // capitalized and the other being lowercased.
        // Note: An empty string is acceptable and only one distinct answer will exist.

        StringBuilder sb = new StringBuilder();

        int asc_curr = -1;
        int asc_next = -1;

        for (int i = 0; i < str.length() - 1; i++) {
            char curr = str.charAt(i);
            char next = str.charAt(i + 1);
            asc_curr = curr; // converts to ascii value
            asc_next = next; // converts to ascii value

            // asc_curr upper case, asc_next lower case
            if ((asc_curr > 64 && asc_curr < 91) && (asc_next > 96 && asc_next < 123)) {
                i++;
                continue;
            }

            // asc_curr lower case, asc_next upper case
            if ((asc_next > 64 && asc_next < 91) && (asc_curr > 96 && asc_curr < 123)) {
                i++;
                continue;
            }
            sb.append(curr); // append if 'acceptable' letter
        }
        asc_next = str.charAt(str.length() - 1);

        // Since stopped for loop on second to last element, compare 2nd to last and
        // last char after forloop
        if (!((asc_curr > 64 && asc_curr < 91) && (asc_next > 96 && asc_next < 123)
                || (asc_next > 64 && asc_next < 91) && (asc_curr > 96 && asc_curr < 123))) {
            sb.append(str.charAt(str.length() - 1));
        }

        return sb.toString();
    }

    public static int getMaxCandies(int candies, int exchange) {
        // You are given a certain number of candies and an exchange rate. For every
        // exchange number of candy wrappers that you trade in, you receive an
        // additional candy. Return the maximum number of candies that you can eat.

        int temp = candies;
        int extra = 0;
        // c = 10 e = 3
        while (temp > 0) {
            temp -= exchange;
            if (temp < 0) {
                break;
            }
            extra++;
        }
        return candies += extra;
    }

    public static int[] getSmallerThan(int[] nums) {
        // Given an integer array, nums, for each nums[i] you need to find the number of
        // elements that are strictly smaller than it. Do this for all values in the
        // array and return the result in an array.
        int[] res = new int[nums.length];

        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            counter = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i == j)
                    continue;
                if (nums[j] < nums[i]) {
                    counter++;
                }
            }
            res[i] = counter;
        }
        return res;
    }
}