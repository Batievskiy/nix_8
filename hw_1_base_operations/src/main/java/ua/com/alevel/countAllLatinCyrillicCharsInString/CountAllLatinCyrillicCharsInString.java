// 1. Get the string from user in console.
// 2. Parse all characters from this string.
// 3. Sort them.
// 4. Print out the number of occurrences of each character.

package ua.com.alevel.countAllLatinCyrillicCharsInString;

import ua.com.alevel.WantToPlayALittleGame;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CountAllLatinCyrillicCharsInString {
    private static final Scanner SCANNER_CP866 = new Scanner(System.in, "CP866");

    private static final String TITLE = "\n---< Number of each character in the String >---\n";

    public static void run() {
        title();
        play();
    }

    public static void play() {
        boolean isPlay = true;
        while (isPlay) {
            String string = getString();

            charOccurrenceCount(string);

            // and let's ask user to play more ;)
            isPlay = WantToPlayALittleGame.isWantMore(isPlay);

            System.out.println();
        }
    }

    private static void title() {
        System.out.println(TITLE);
    }

    private static String getString() {
        System.out.print("Input a string -> ");
        // SOLUTION - https://www.cyberforum.ru/java-j2se/thread1532517.html
        try {
            System.setOut(new PrintStream(System.out, true, "CP866"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return SCANNER_CP866.nextLine();
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
