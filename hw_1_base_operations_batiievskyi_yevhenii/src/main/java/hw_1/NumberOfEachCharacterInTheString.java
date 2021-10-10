package hw_1;// 1. Get the string from user in console.
// 2. Parse all characters from this string.
// 3. Sort them.
// 4. Print out the number of occurrences of each character.

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Collectors;

public class NumberOfEachCharacterInTheString {
    private static final Scanner SCANNER = new Scanner(System.in, StandardCharsets.UTF_8);

    public static void run() {
        title();
        play();
    }

    public static void play() {
        boolean isPlay = true;
        while (isPlay) {
            String string = getString();

            charOccurrenceCount(string);

            System.out.print("\nWant more? ( Y / N ) - > ");
            String s = "";
            while (s.isEmpty()) {
                s = SCANNER.nextLine();
                if (!s.toLowerCase().matches("[y]")) {
                    System.out.println("Bye-Bye ;)\n");
                    isPlay = false;
                    break;
                }
            }
        }
    }

    private static void title() {
        System.out.println("\n---< Number of each character in the String >---\n");
    }

    private static String getString() {
        System.out.print("Input a string -> ");
        String string = SCANNER.nextLine();
        return string; // can't read cyrillic characters
//        return System.console().readLine();
    }

    private static void charOccurrenceCount(String sourceString) {
        // let's create Map to store repeated subStrings as a key
        // and number of occurrences as a value
        Map<Character, Integer> repeatedCharsMap = new TreeMap<>();

        // let's convert String into character array
        char[] charArray = Arrays.stream(sourceString.split(""))
                .filter(c -> c.matches("[a-zA-Z]|[\\p{InCyrillic}]"))
                .sorted()
                .collect(Collectors.joining())
                .toCharArray();
        System.out.println(Arrays.toString(charArray));

        // iterate through all chars in charArray
        // and save chars in Map
        for (char currentChar : charArray) {
            // let's leave some space
            if (currentChar != ' ') {
                // check weather Map contains particular character
                if (repeatedCharsMap.containsKey(currentChar)) {
                    int counterValue = repeatedCharsMap.get(currentChar);
                    // increase current character counter value by 1
                    repeatedCharsMap.put(currentChar, counterValue + 1);
                } else {
                    // make a new entry
                    repeatedCharsMap.put(currentChar, 1);
                }
            }
        }
        printResult(repeatedCharsMap);
    }

    private static void printResult(Map<Character, Integer> repeatedSubstringsTreeMap) {
        int counter = 1;
        for (Map.Entry<Character, Integer> entry : repeatedSubstringsTreeMap.entrySet()) {
            System.out.printf("%02d. %s - %s\n", counter, entry.getKey(), entry.getValue());
            counter++;
        }
    }
}
