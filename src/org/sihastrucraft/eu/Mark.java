package org.sihastrucraft.eu;

import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.AbstractMap;

public class Mark implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player)commandSender;
        Chunk chunk = p.getLocation().getChunk();
        String playerName = p.getName();
        if(strings.length<=0){
            return false;
        }
        else {
            String arg = strings[0];
            if (Main.chunks.containsKey(chunk)) {
                commandSender.sendMessage(ChatColor.RED + "Already marked");
            } else {
                Main.chunks.put(chunk, new AbstractMap.SimpleEntry(playerName, arg));
                commandSender.sendMessage(ChatColor.GREEN + "Chunk marked");

            }
        }
        return true;
    }
}
