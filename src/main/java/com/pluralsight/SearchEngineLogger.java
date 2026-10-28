package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngineLogger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        log("launch");
        while (true) {
            System.out.print("Enter a search term (X or x to exit) : ");
            String search = scanner.nextLine();

            if (search.equalsIgnoreCase("X")) {
                log("exit");
                break;

            }
            log("search : " + search);
        }
        scanner.close();

    }

    public static void log(String message) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("logs.txt", true));

            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String timestamp = now.format(fmt);

            writer.write(timestamp + " " + message + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }


    }
}
