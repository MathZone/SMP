package org.sihastrucraft.eu;

import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.AbstractMap;

public class UnMark implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player) commandSender;
        Chunk chunk = p.getLocation().getChunk();
        String playerName = p.getName();
        if(Main.chunks.containsKey(chunk)){
            AbstractMap.SimpleEntry<String, String> entry = Main.chunks.get(chunk);
            String owner = entry.getKey();
            if(owner.equals(playerName)){
                Main.chunks.remove(chunk);
                p.sendMessage(ChatColor.RED + "Marker removed");
            }
            else if(p.isOp()) {
                Main.chunks.remove(chunk);
                p.sendMessage(ChatColor.RED + "Marker removed");
            }
            else{
                p.sendMessage(ChatColor.RED + "You don't own this chunk");
            }
        }
        else{
          p.sendMessage(ChatColor.GREEN + "Chunk isn't marked");
        }
        return true;
    }
}
