package me.doreen.firstplugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import java.util.Objects;

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

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event){

        if (event.getEntityType() == EntityType.ZOMBIE){
            Zombie zombie = (Zombie) event.getEntity();
            Objects.requireNonNull(zombie.getEquipment()).setHelmet(new ItemStack(Material.DIAMOND_HELMET));
            Objects.requireNonNull(zombie.getEquipment()).setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
        }

        if (event.getEntityType() == EntityType.SKELETON){
            Skeleton skeleton = (Skeleton) event.getEntity();
            Objects.requireNonNull(skeleton.getEquipment()).setHelmet(new ItemStack(Material.DIAMOND_HELMET));
            Objects.requireNonNull(skeleton.getEquipment()).setHelmet(new ItemStack(Material.DIAMOND_HELMET));
        }
    }
}
