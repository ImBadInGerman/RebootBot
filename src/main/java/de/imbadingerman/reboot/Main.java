package de.imbadingerman.reboot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class Main {
    public static void main(String[] args) {
        init();
        JDA api = JDABuilder.createDefault(ConfigProvider.getInstance().getProperty("bot.token")).build();
    }

    private static void init() {
        // Initialize ConfigProvider
        ConfigProvider configProvider = ConfigProvider.getInstance();

        // Initialize DatabaseProvider
        DatabaseProvider databaseProvider = DatabaseProvider.getInstance();
        try {
            databaseProvider.connect(
                configProvider.getProperty("db.url"),
                configProvider.getProperty("db.user"),
                configProvider.getProperty("db.password")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Initialize LoggingProvider
        LoggingProvider loggingProvider = LoggingProvider.getInstance();
        loggingProvider.logToFile("Bot is starting up...");
    }
}
