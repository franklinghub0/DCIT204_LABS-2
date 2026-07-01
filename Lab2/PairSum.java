import java.util.Scanner;

/**
 * DCIT 204 - Lab 2, Task 2
 *
 * Interactive Pair Sum (Brute Force) Algorithm.
 *
 * This program collects an array of integers and a target sum from the
 * user, then uses a brute-force nested loop search to find a unique
 * pair of numbers whose sum equals the target value.
 *
 * Time Complexity: O(n^2) - every pair of elements is compared using
 * two nested loops, which is characteristic of the brute-force approach.
 */
public class PairSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Get the size of the array from the user
        int size = readArraySize(scanner);

        // Step 2: Fill the array with user input
        int[] numbers = readArrayElements(scanner, size);

        // Step 3: Get the target sum
        int target = readTargetSum(scanner);

        // Step 4: Perform the brute-force pair search
        int[] result = findPairIndices(numbers, target);

        // Step 5 & 6: Display the outcome
        displayResults(numbers, target, result);

        scanner.close();
    }

    /**
     * Prompts the user for the array size, ensuring it is a positive integer.
     */
    private static int readArraySize(Scanner scanner) {
        int size;
        while (true) {
            System.out.print("Enter the number of elements in the array: ");
            if (scanner.hasNextInt()) {
                size = scanner.nextInt();
                if (size > 1) {
                    break;
                }
                System.out.println("Array size must be at least 2 to form a pair. Please try again.");
            } else {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.next(); // discard invalid token
            }
        }
        return size;
    }

    /**
     * Prompts the user to enter each element of the array, one at a time.
     */
    private static int[] readArrayElements(Scanner scanner, int size) {
        int[] numbers = new int[size];
        System.out.println("\nEnter " + size + " integer value(s):");

        for (int i = 0; i < size; i++) {
            while (true) {
                System.out.print("  Element[" + i + "]: ");
                if (scanner.hasNextInt()) {
                    numbers[i] = scanner.nextInt();
                    break;
                } else {
                    System.out.println("  Invalid input. Please enter an integer.");
                    scanner.next(); // discard invalid token
                }
            }
        }
        return numbers;
    }

    /**
     * Prompts the user for the target sum value.
     */
    private static int readTargetSum(Scanner scanner) {
        int target;
        while (true) {
            System.out.print("\nEnter the Target Sum: ");
            if (scanner.hasNextInt()) {
                target = scanner.nextInt();
                break;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // discard invalid token
            }
        }
        return target;
    }

    /**
     * Brute-force nested loop search for a pair of indices whose
     * values sum to the target. Returns {i, j} if found, or null
     * if no such pair exists.
     */
    private static int[] findPairIndices(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }

    /**
     * Displays the array, target sum, and the result of the pair search.
     */
    private static void displayResults(int[] numbers, int target, int[] result) {
        System.out.println("\n===================================");
        System.out.println("         PAIR SUM - RESULTS        ");
        System.out.println("===================================");
        System.out.print("Array Entered : [");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i < numbers.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        System.out.println("Target Sum    : " + target);

        if (result != null) {
            int i = result[0];
            int j = result[1];
            System.out.println("Pair Found!");
            System.out.println("  Index 1 : " + i + "  ->  Value: " + numbers[i]);
            System.out.println("  Index 2 : " + j + "  ->  Value: " + numbers[j]);
            System.out.println("  Equation: " + numbers[i] + " + " + numbers[j] + " = " + target);
        } else {
            System.out.println("No pair found whose sum equals " + target + ".");
        }
        System.out.println("===================================");
    }
}
