package me.doreen.firstplugin;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Squid;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.bukkit.Bukkit.*;

public class MyListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){

        event.getPlayer().sendMessage(ChatColor.AQUA + "Hi " + event.getPlayer().getDisplayName() + ", welcome to the server!");
    }

    @EventHandler
    public void onPlayerSleep(PlayerBedEnterEvent event){

        World world = event.getPlayer().getServer().getWorld("world");
        long time = world.getTime();
        //getLogger().info(String.valueOf(time));

        if ((time >= 12541 && time <= 23458) || world.isThundering()){
            broadcastMessage(ChatColor.AQUA + event.getPlayer().getDisplayName() + " went to sleep. Goodnight!");
        }

    }
}
