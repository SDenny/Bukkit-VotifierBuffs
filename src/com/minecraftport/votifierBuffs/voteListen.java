package com.minecraftport.votifierBuffs;

import com.vexsoftware.votifier.Votifier;
import com.vexsoftware.votifier.model.Vote;
import com.vexsoftware.votifier.model.VotifierEvent;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import java.util.Random;
import java.util.UUID;

public class voteListen implements Listener {


    @EventHandler(priority = EventPriority.NORMAL)
    public void onVotifierEvent(VotifierEvent event) {
        Vote vote = event.getVote();

        String username = vote.getUsername();
        String voteService = vote.getServiceName();
        Server server = Votifier.getInstance().getServer();
        Player p = server.getPlayer(username);

        server.broadcastMessage(ChatColor.BOLD + "" + ChatColor.GOLD + username + ChatColor.GREEN + " voted at "+ ChatColor.GOLD + voteService + ChatColor.GREEN + "!");

        if (server.getPlayer(username) != null) {
            int rand = (int) Math.round(Math.random() * 10);
            Location ploc = p.getLocation();

            if (rand <= 4) {
                int randAmt = (int) Math.round(Math.random() * 20)*10;
                server.dispatchCommand(server.getConsoleSender(), "acb " + username + randAmt);
                server.getPlayer(username).sendMessage(ChatColor.BOLD + "" + ChatColor.GOLD + "Thanks for voting! Here are " + randAmt + " claim blocks. ");
            } else if(rand == 5) {
                ItemStack is = new ItemStack(Material.CAKE, 1);
                server.getWorld("world").dropItem(ploc, is);
                server.getPlayer(username).sendMessage(ChatColor.BOLD + "" + ChatColor.GOLD + "Thanks for voting! Have a cake!");
            } else if(rand == 6) {
                    int randAmt = (int) Math.round(Math.random() * 3) + 1;
                    ItemStack is = new ItemStack(Material.EMERALD,randAmt);
                    server.getWorld("world").dropItem(ploc,is);
                    server.getPlayer(username).sendMessage(ChatColor.BOLD + "" + ChatColor.GOLD + "Thanks for voting! Here's "+randAmt + " Emeralds!");
            } else if(rand == 7) {
                int randAmt = (int) Math.round(Math.random() * 7) + 1;
                ItemStack is = new ItemStack(Material.PUMPKIN_PIE, randAmt);
                server.getWorld("world").dropItem(ploc, is);
                server.getPlayer(username).sendMessage(ChatColor.BOLD + "" + ChatColor.GOLD + "Thanks for voting! Have some pie!");
            } else if(rand == 8) {
                server.dispatchCommand(server.getConsoleSender(), "eco give " + username + " 10");
                System.out.println("Added $10 to " + username + "'s account.");
                server.getPlayer(username).sendMessage(ChatColor.BOLD + "" + ChatColor.GOLD + "You were given " + ChatColor.GREEN + "$10 " + ChatColor.GOLD + "for voting. Thanks!");
            } else if(rand == 9) {
                server.dispatchCommand(server.getConsoleSender(), "xp give " + username + " 10L");
                System.out.println("Gave 10 levels of XP to " + username + ".");
                server.getPlayer(username).sendMessage(ChatColor.BOLD + "" + ChatColor.GOLD + "Thanks for voting! Here are a few levels of XP that might come in handy!");
            }else if(rand == 10){
                server.broadcastMessage(ChatColor.GREEN+"Lucky vote - Everyone gained a random potion effect!");
                for (Player pl : server.getOnlinePlayers()) {
                    int rand2 = (int) Math.round(Math.random() * main.poEffect.length-1);
                    pl.addPotionEffect(main.poEffect[rand2]);
                }
            }

        }
    }
}