package de.imbadingerman.reboot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class Main {
    public static void main(String[] args) {
        JDA api = JDABuilder.createDefault(BOT_TOKEN).build();
    }
}
