import java.util.Scanner;

/**
 * DCIT 204 - Lab 2, Task 1
 *
 * Interactive Find Maximum Algorithm.
 *
 * This program collects an array of integers from the user, searches
 * through the array to find the maximum value and the index at which
 * it occurs, and displays the result in a clear format.
 *
 * Time Complexity: O(n) - the array is scanned exactly once.
 */
public class FindMax {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Get the size of the array from the user
        int size = readArraySize(scanner);

        // Step 2 & 3: Create the array and fill it with user input
        int[] numbers = readArrayElements(scanner, size);

        // Step 4: Find the maximum value and its index
        int maxIndex = findMaxIndex(numbers);
        int maxValue = numbers[maxIndex];

        // Step 5: Display the results
        displayResults(numbers, maxValue, maxIndex);

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
                if (size > 0) {
                    break;
                }
                System.out.println("Array size must be a positive integer. Please try again.");
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
     * Scans through the array and returns the index of the maximum value.
     */
    private static int findMaxIndex(int[] numbers) {
        int maxIndex = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > numbers[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    /**
     * Displays the array and the result of the search in a clean format.
     */
    private static void displayResults(int[] numbers, int maxValue, int maxIndex) {
        System.out.println("\n===================================");
        System.out.println("        FIND MAXIMUM - RESULTS     ");
        System.out.println("===================================");
        System.out.print("Array Entered : [");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i < numbers.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        System.out.println("Maximum Value : " + maxValue);
        System.out.println("Found At Index: " + maxIndex);
        System.out.println("===================================");
    }
}
