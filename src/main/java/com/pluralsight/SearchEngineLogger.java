package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Search Engine Logger
 * Prompts the user for search terms and logs each action
 * (launch, search, exit) with a timestamp to logs.txt.
 */
public class SearchEngineLogger {
    public static void main(String[] args) {
        // Scanner to read the user's search terms
        Scanner scanner = new Scanner(System.in);

        // Log that the application started
        log("launch");

        // Keep asking for search terms until the user types X or x
        while (true) {
            System.out.print("Enter a search term (X or x to exit) : ");
            String search = scanner.nextLine();

            // Exit when the user types X or x (any case)
            if (search.equalsIgnoreCase("X")) {
                log("exit");
                break;
            }

            // Log the search term
            log("search : " + search);
        }

        // Close the Scanner when the program is done
        scanner.close();
    }

    /**
     * Writes one action to logs.txt with the current date and time in front.
     * Example line: 2026-10-28 15:42:46 search : java array
     */
    public static void log(String message) {
        // Try: writing to a file can fail
        try {
            // Open logs.txt in append mode (true) so old entries are kept
            BufferedWriter writer = new BufferedWriter(new FileWriter("logs.txt", true));

            // Build the timestamp, e.g. 2026-10-28 15:42:46
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String timestamp = now.format(fmt);

            // Write the timestamp and message as one line, then save the file
            writer.write(timestamp + " " + message + "\n");
            writer.close();
        } catch (IOException e) {
            // Runs if logs.txt can't be opened or written
            System.out.println("Error: " + e.getMessage());
        }
    }
}