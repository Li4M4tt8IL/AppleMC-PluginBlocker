package me.pm.pluginblocker.util;

import me.pm.pluginblocker.Main;

public class CommandChecker {
    public static boolean isCommandWhitelisted(String command, Main plugin) {
        for(String string : plugin.getConfig().getStringList("WhitelistedCommands")) {
            if(string.equalsIgnoreCase(command)) {
                return true;
            }
        }
        return false;
    }
}
