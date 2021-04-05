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
        List<List<String>> list = Arrays.asList(Arrays.asList("London", "New York"), Arrays.asList("New York", "Lima"), Arrays.asList("Lima", "Sao Paulo"));
        System.out.println("Get vacation destination: " + getVacationDestination(list));
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

        //flights = [["A", "B"], ["B", "C"]], return "C".
        //flights = [["A", "B"], ["C", "D"], ["B", "C"]], return "D".

        //Brute Force
        for(int i = 0; i < itenary.size(); i++) {
            String letter_to_find = itenary.get(i).get(1);
            boolean found = findDestination(itenary, letter_to_find);
            if(!found) {
                return letter_to_find;
            }
        }
        //Can also use set difference (add all index 1 to set then subtract index 0 that are common - see leetcode.)
        
        return null;
    }

    private static boolean findDestination(List<List<String>> itenary, String letter_to_find) {
        for(int i = 0; i < itenary.size(); i++) {
            if(itenary.get(i).get(0).equals(letter_to_find)) {
                return true;
            }
        }
        return false;
    }
}