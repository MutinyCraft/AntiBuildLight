package com.mutinycraft.jigsaw.AntiBuildLight;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.hanging.HangingPlaceEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;

public class AntiBuildEventHandler implements Listener {

    private AntiBuildLight plugin;

    public AntiBuildEventHandler(AntiBuildLight pl) {
        this.plugin = pl;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    // Events
    @EventHandler(priority = EventPriority.LOW)
    public void NoBuild(BlockPlaceEvent event) {

        Player player = event.getPlayer();

        if (!player.hasPermission("antibuild.bypass")) {
            event.setCancelled(true);
            message(player);
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void NoBreak(BlockBreakEvent event) {

        Player player = event.getPlayer();

        if (!player.hasPermission("antibuild.bypass")) {
            event.setCancelled(true);
            message(player);
        }
    }

    // Bucket Interaction

    @EventHandler(priority = EventPriority.LOW)
    public void NoBucketEmpty(PlayerBucketEmptyEvent event) {

        Player player = event.getPlayer();

        if (!player.hasPermission("antibuild.bypass")) {
            event.setCancelled(true);
            message(player);
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void NoBucketFill(PlayerBucketFillEvent event) {

        Player player = event.getPlayer();

        // Bucket check
        if (!player.hasPermission("antibuild.bypass")) {
            event.setCancelled(true);
            message(player);
        }
    }

    // Painting/ItemFrame Interaction

    @EventHandler(priority = EventPriority.LOW)
    public void NoHangingBreak(HangingBreakByEntityEvent event) {

        Entity entity = event.getRemover();
        Player player = null;

        if (event.getRemover().getType() == EntityType.PLAYER) {
            player = (Player) entity;
        }
        if (player != null) {

            if (!player.hasPermission("antibuild.bypass")) {
                event.setCancelled(true);
                message(player);
            }
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void NoHangingPlace(HangingPlaceEvent event) {

        Player player = event.getPlayer();

        // Hanging place
        if (!player.hasPermission("antibuild.bypass")) {
            event.setCancelled(true);
            message(player);
        }
    }

    // Inventory Access

    @EventHandler(priority = EventPriority.LOW)
    public void NoInventoryAccess(InventoryOpenEvent event) {
        Player player = null;

        if (event.getPlayer() instanceof Player) {
            player = (Player) event.getPlayer();
        }

        if (player != null && !player.hasPermission("antibuild.bypass")) {
            event.setCancelled(true);
            message(player);
        }
    }

    /**
     * Relay message to user.
     *
     * @param p
     */
    public void message(Player p) {
        p.sendMessage(plugin.getMessage());
    }
}
