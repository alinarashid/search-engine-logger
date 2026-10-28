package com.pluralsight;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SearchEngineLogger {
    public static void main(String[] args) {


    }

    public void log(String message) {

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("logs.txt",true));

            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String timestamp = now.format(fmt);

            writer.write(timestamp +" "+ message+"\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: " +e.getMessage());
        }



    }
}
