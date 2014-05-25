package com.mutinycraft.jigsaw.AntiBuildLight;

import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class AntiBuildLight extends JavaPlugin implements Listener {
    private static final String MESSAGE = "&cYou are not allowed to build!";

    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        new AntiBuildEventHandler(this);
    }

    /**
     * Predefined message that will be sent when interaction is denied.
     *
     * @return message to send to player.
     */
    public String getMessage() {
        return ChatColor.translateAlternateColorCodes('&', MESSAGE);
    }
}
