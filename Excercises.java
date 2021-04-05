import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Excercises {
    public static void main(String[] args) {
        // Problem: 1
        int arr[] = { 1, 1, 1, 2, 1, 3, 4, 2, 3 };
        System.out.println("Lucky number: " + getLuckyNumber(arr));

        // Problem: 2
        String str = "rammingabcprogrammingdefprog";
        System.out.println("Programming Occurances: " + getProgrammingInstances(str));

        // Problem: 3
        int na = 56;
        System.out.println("Product Sum Difference: " + getProdSumDiff(na));

        // Problem: 4
        int nums[] = { 6, 2, 6, 3 };
        System.out.println("Max Product: " + getMaxProduct(nums));

        // Problem: 5
        int num = 100;
        System.out.println("Binary to Decimal: " + getDecimalFromBinary(num));

        // Problem: 6
        String word = "ABCd";
        System.out.println("To lower case: " + getLowerCase(word));

        // Problem: 7
        int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 } };
        System.out.println("Max Account: " + getMaxRowSumIn2D(mat));

        // Problem: 8
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(4);
        list.add(8);
        list.add(7);
        list.add(3);
        list.add(6);
        int m = 4;
        int n = 3;
        System.out.println("Remove Partition: " + removePartition(list, m, n));

        // Problem: 9 (still needs work)
        String binary = "0010110";
        System.out.println("Get Max Score of Binary String: " + getMaxScoreBinaryString(binary));

        // Problem: 10
        int number = 16;
        System.out.println("Get to Zero Steps: " + getToZero(number));

        // Problem: 11
        String[] words = { "cat", "bat" };
        String chars = "act";
        System.out.println("Get common chars length: " + getCommonCharLengthSum(words, chars));
    }

    public static int getLuckyNumber(int[] arr) {
        // Given an array, nums, every value appears twice except for one which only
        // appears once.
        // The value that only appears once is the lucky number. Return the lucky
        // number.

        int lucky_num = -1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i : map.keySet()) {
            if (map.get(i) == 1) {
                lucky_num = i;
                break;
            }
        }

        return lucky_num;
    }

    public static int getProgrammingInstances(String str) {
        // Given a string, text,
        // return how many times you can form the string “programming”.

        // p 1
        // r 2
        // o 1
        // g 2
        // a 1
        // m 2
        // i 1
        // n 1

        // Solution: Brute Force
        // long start = System.currentTimeMillis();
        String programming = "programming";
        int occ = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < programming.length(); i++) {
            occ = 0;
            for (int j = 0; j < str.length(); j++) {
                char char_to_check = programming.charAt(i);
                if (char_to_check == str.charAt(j)) {
                    occ++;
                }
            }
            if (occ < min) {
                min = occ;
            }
        }
        // long end = System.currentTimeMillis();
        // System.out.println("Brute Force Time: " + (end-start));

        // Solution: HashMap
        // start = System.currentTimeMillis();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        System.out.println(map);

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();

            if (c == 'p' || c == 'r' || c == 'o' || c == 'g' || c == 'a' || c == 'm' || c == 'i' || c == 'n') {
                if (count < min) {
                    min = count;
                }
            }
        }
        // end = System.currentTimeMillis();
        // System.out.println("HashMap Time: " + (end-start));

        return min;
    }

    public static int getProdSumDiff(int number) {
        // Given an integer, n, return the difference between the product and sum of its
        // digits.
        int sum = 0;
        int product = 1;

        for (int i = number; i > 0; i /= 10) {
            int digit = i % 10;
            sum += digit;
            product *= digit;
        }

        return product - sum;
    }

    public static int getMaxProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max1) {
                max1 = nums[i];
                index = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max2 && i != index) {
                max2 = nums[i];
            }
        }

        return max1 * max2;
    }

    public static int getDecimalFromBinary(int num) {
        // Given a binary number represented as a linked list, return its decimal value.

        // Yet to do with linked list - did with normal num

        int decimal = 0;
        int exponent = 0;
        for (int i = num; i > 0; i /= 10) {
            int digit = i % 10;
            if (digit == 1) {
                decimal += Math.pow(2, exponent);
            }
            exponent++;
        }
        return decimal;
    }

    public static String getLowerCase(String str) {
        // You are typing on a computer when all of a sudden you realize you’ve been
        // typing with caps lock on. Given a string s, return a new string containing
        // all of its alphabetical character transformed to lowercase.
        // Note: Do you not use an built in library functions.
        String result = "";
        for (char c : str.toCharArray()) {
            int ascii_value = c;
            if (ascii_value > 64 && ascii_value < 91) {
                // upper case letter - convert to lower
                int new_ascii_value = c + 32;
                char new_letter = (char) new_ascii_value;
                result += Character.toString(new_letter);
            } else {
                result += Character.toString(c);
            }

        }
        return result;
    }

    public static int getMaxRowSumIn2D(int mat[][]) {
        // Given a two-dimensional integer array, accounts, each row in the matrix
        // represents the total wealth of the ith customer.
        // The total wealth of a customer is given by the sum of their j account in the
        // ith row. Return the wealth of the richest customer.

        int max = Integer.MIN_VALUE;
        int sum;
        for (int r = 0; r < mat.length; r++) {
            sum = 0;
            for (int c = 0; c < mat[r].length; c++) {
                sum += mat[r][c];
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    public static LinkedList<Integer> removePartition(LinkedList<Integer> list, int m, int n) {
        // Given a reference to the head of a linked list and two values, m, and n,
        // traverse the entire list keeping the first m elements followed by removing
        // the next n elements.
        // Return the resulting list.
        int temp = 0;
        for (int i = m; i < (m + n); i++) {
            list.remove(i - temp);
            temp++;
        }
        return list;
    }

    public static int getMaxScoreBinaryString(String binary) {
        // Given a binary string, binary, return the maximum score of the string. The
        // score of a string is given by splitting the string at a specific index and
        // summing the total number of zeroes in the left substring and the total number
        // of ones in the right substring.
        // Note: Both the left and right substring after the split must have at least a
        // single character.

        int score = 0;

        int index = 0;
        for (char c : binary.toCharArray()) {
            if (c == '1') {
                break;
            }
            index++;
        }

        for (int i = 0; i < index; i++) {
            if (binary.charAt(i) == '0') {
                score++;
            }
        }
        for (int i = index; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                if (index == 0) {
                    continue;
                }
                score++;
            }
        }

        return score;
    }

    public static int getToZero(int num) {
        // Given a non-negative integer, num, return the number of operations it takes
        // to reduce it to zero. If num is even, divide it by two. If num is odd,
        // subtract one from it. Continue this process until num is zero.

        int operations = 0;
        int number = num;

        if (num == 0) {
            return operations;
        } else if (num % 2 == 0) {
            number /= 2;
            operations++;
            operations += getToZero(number);
        } else if (num % 2 != 0) {
            number -= 1;
            operations++;
            operations += getToZero(number);
        }
        return operations;
    }

    public static int getCommonCharLengthSum(String[] arr, String chars) {
        // Given an array of words and a string of characters, chars, return the sum of
        // the lengths of words that can be formed using only the chars.
        // Note: Each character within chars can only be used once.

        //Brute Force Sol'n
        int total_length = 0;
        for (String word : arr) {
            total_length += word.length();
        }

        for (int j = 0; j < arr.length; j++) {
            String word = arr[j];
            for (int i = 0; i < word.length(); i++) {
                String letter = Character.toString(word.charAt(i));
                if (!chars.contains(letter)) {
                    total_length -= word.length();
                }
            }

        }

        return total_length;
    }
}