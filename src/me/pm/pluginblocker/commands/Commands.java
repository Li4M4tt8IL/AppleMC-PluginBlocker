package me.pm.pluginblocker.commands;

import me.pm.pluginblocker.Main;
import me.pm.pluginblocker.util.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements CommandExecutor {
    private Main plugin;

    public Commands(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender.hasPermission("pblocker.reload")) {
            plugin.reloadConfig();
            commandSender.sendMessage(Utils.color("&8[&5AppleMC&8] &fPrzeladowano config!"));
            return true;
        }
        return false;
    }
}
