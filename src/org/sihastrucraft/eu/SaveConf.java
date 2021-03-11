package org.sihastrucraft.eu;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.HashMap;

public class SaveConf implements CommandExecutor {
    FileConfiguration config = Bukkit.getServer().getPluginManager().getPlugin("SihastruCraft").getConfig();
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        config.addDefault("mark",Main.chunks);
        Bukkit.getServer().getPluginManager().getPlugin("SihastruCraft").saveConfig();
        return true;
    }
}
