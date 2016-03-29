package com.minecraftport.votifierBuffs;

import com.vexsoftware.votifier.model.Vote;
import com.vexsoftware.votifier.model.VoteListener;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class main extends JavaPlugin implements VoteListener {

    @Override
    public void onDisable() {
        PluginDescriptionFile desc = this.getDescription();
        String tag = "[VotifierBuffs]";
        System.out.println(tag + "VotifierBuffs v." + desc.getVersion() + " has been disabled!");
    }


    @Override
    public void onEnable() {
        PluginDescriptionFile desc = this.getDescription();
        String tag = "[VotifierBuffs]";
        System.out.println(tag + "VotifierBuffs v." + desc.getVersion() + " has been enabled!");

        getServer().getPluginManager()
                .registerEvents(new voteListen(), this);
    }

    public static PotionEffect poEffect[] = {
            new PotionEffect(PotionEffectType.ABSORPTION, 2400, 2),
            new PotionEffect(PotionEffectType.FAST_DIGGING, 2400, 2),
            new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 2400, 2),
            new PotionEffect(PotionEffectType.JUMP, 2400, 2),
            new PotionEffect(PotionEffectType.SPEED, 2400, 2)
    };

    public static Economy economy = null;
    private boolean setupEconomy()
    {
        RegisteredServiceProvider<Economy> economyProvider = Bukkit.getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }

    public void voteMade(Vote vote) {
        System.out.println("Received: " + vote);
    }
}