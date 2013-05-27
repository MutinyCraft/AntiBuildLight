package com.mutinycraft.jigsaw.AntiBuildLight;

import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class AntiBuildLight extends JavaPlugin implements Listener {

    Logger log;
    private static final String VERSION = " v1.1";
    private static final String MESSAGE = "&cIf you wish to build, visit: &djoin.mutinycraft.com";

    // Enable
    public void onEnable() {
        log = this.getLogger();

        getServer().getPluginManager().registerEvents(this, this);
        new AntiBuildEventHandler(this);

        log.info(this.getName() + VERSION + " enabled!");
    }

    // Message Handling
    public String getMessage() {
        return ChatColor.translateAlternateColorCodes('&', MESSAGE);
    }

    // Disable
    public void onDispable() {
        log.info(this.getName() + VERSION + " disabled!");
    }
}
