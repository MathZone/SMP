package org.sihastrucraft.eu;


import io.netty.channel.local.LocalAddress;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.AbstractMap;


public class Listener implements org.bukkit.event.Listener {
    @EventHandler
    public void PlayerMoveEvent(PlayerMoveEvent event){
        Player p = event.getPlayer();
        Chunk chunk = p.getPlayer().getLocation().getChunk();
        AbstractMap.SimpleEntry<Chunk,Boolean> chunckbool = Main.locations.get(p.getName());
        String playerName = p.getName();
        if(chunk.equals(chunckbool.getKey()) && !chunckbool.getValue()){
        if(Main.chunks.containsKey(chunk)){
            AbstractMap.SimpleEntry<String, String> entry = Main.chunks.get(chunk);
            String owner = entry.getKey();
            String marker = entry.getValue();
            p.sendMessage(ChatColor.LIGHT_PURPLE + "Walked into "+owner+"'s marked ground," +ChatColor.BLUE +"tag:" + marker);
            Main.locations.replace(playerName, new AbstractMap.SimpleEntry(chunk, true));
            }
        }
        else if(!chunk.equals(chunckbool.getKey())){
            Main.locations.replace(playerName, new AbstractMap.SimpleEntry(chunk, false));
        }

    }

    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent event){
        Player p = event.getPlayer();
        Chunk chunk = p.getLocation().getChunk();
        String playerName = p.getName();
        Main.locations.put(playerName, new AbstractMap.SimpleEntry(chunk, false));
    }

    @EventHandler
    public void PlayerLeaveEvent(PlayerQuitEvent event){
        Player p = event.getPlayer();
        String playerName = p.getName();
        Main.locations.remove(playerName);
    }

}


