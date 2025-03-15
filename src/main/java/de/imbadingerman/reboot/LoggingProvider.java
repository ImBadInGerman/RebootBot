package de.imbadingerman.reboot;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LoggingProvider {
    private static LoggingProvider instance;
    private PrintWriter writer;

    private LoggingProvider() {
        try {
            writer = new PrintWriter(new FileWriter("log.txt", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LoggingProvider getInstance() {
        if (instance == null) {
            instance = new LoggingProvider();
        }
        return instance;
    }

    public void logToFile(String message) {
        writer.println(message);
        writer.flush();
    }

    public void logToChannel(String channelId, String message) {
        // Placeholder for sending message to a specified channel
        // This will require integration with the bot's messaging system
    }
}
