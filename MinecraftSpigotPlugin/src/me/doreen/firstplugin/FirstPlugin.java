package me.doreen.firstplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class FirstPlugin extends JavaPlugin {

    @Override
    public void onEnable(){
        //Fired when the server enables the plugin
        getLogger().info("First plugin running");

        getServer().getPluginManager().registerEvents(new MyListener(), this);

        // Register our command "kit" (set an instance of your command class as executor)
        this.getCommand("kit").setExecutor(new CommandKit());
    }

    @Override
    public void onDisable(){
        //Fired when the server stops and disables all plugins
    }

}
