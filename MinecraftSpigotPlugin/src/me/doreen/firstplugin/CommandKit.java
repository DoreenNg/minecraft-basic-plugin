package me.doreen.firstplugin;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandKit implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            // here we need to give items to our player

            // Create a new ItemStack (type: Diamond)
            ItemStack diamond = new ItemStack(Material.DIAMOND);

            // Create a new ItemStack (type: Diamond)
            ItemStack dirt = new ItemStack(Material.DIRT);
            // ItemStack bricks = new ItemStack(Material.BRICK, 20);

            // Set the amount of the ItemStack
            dirt.setAmount(64);

            ItemStack axe = new ItemStack(Material.DIAMOND_AXE);

            // Give the player our items (comma-separated list of all ItemStack)
            player.getInventory().addItem(dirt, diamond, axe);
        }

        // If the player (or console) uses our command correct, we can return true
        return true;
        // In your onCommand method, return false if you want the CommandSender to receive the message dictating correct usage of your command (as defined in the plugin.yml). Return true to stop execution silently.
    }
}
