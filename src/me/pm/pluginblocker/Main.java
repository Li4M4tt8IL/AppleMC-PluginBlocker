package me.pm.pluginblocker;

import me.pm.pluginblocker.commands.Commands;
import me.pm.pluginblocker.events.CommandEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private CommandEvent commandEvent;
    private Commands commands;

    @Override
    public void onEnable() {

        load();
        getCommand("pbreload").setExecutor(commands);
        Bukkit.getPluginManager().registerEvents(commandEvent, this);
    }

    @Override
    public void onDisable() {
        saveConfig();
    }

    public void load() {
        commandEvent = new CommandEvent(this);
        commands = new Commands(this);
        saveDefaultConfig();
    }
}
