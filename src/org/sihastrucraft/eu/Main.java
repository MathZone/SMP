package org.sihastrucraft.eu;

import org.bukkit.Chunk;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.AbstractMap;
import java.util.HashMap;


public class Main extends JavaPlugin {
   public static HashMap<Object, AbstractMap.SimpleEntry<String, String>> chunks= new HashMap<Object, AbstractMap.SimpleEntry<String, String>>();
   public static HashMap<String, AbstractMap.SimpleEntry<Chunk, Boolean>> locations = new HashMap<String , AbstractMap.SimpleEntry<Chunk,Boolean>>();
   public FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        getLogger().info("uw Moeder");
        if(config.get("mark")!=null) {
            chunks = (HashMap<Object, AbstractMap.SimpleEntry<String, String>>) config.get("mark");
        }
        getLogger().info(config.get("mark").toString());

        this.getServer().getPluginManager().registerEvents(new Listener(),this);
        this.getCommand("mark").setExecutor(new Mark());
        this.getCommand("unmark").setExecutor(new UnMark());
        this.getCommand("owouwuowouwu").setExecutor(new SaveConf());


    }
    @Override
    public void onDisable(){
        config.addDefault("mark",chunks);
        saveConfig();
    }
}
