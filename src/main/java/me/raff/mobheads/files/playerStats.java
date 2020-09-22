package me.raff.mobheads.files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class playerStats {

    private static File file;
    private static FileConfiguration stats;

    public static void setup(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("MobHeads").getDataFolder(), "playerstats.yml");

        if(!file.exists()){
            try{
                file.createNewFile();
            }catch(IOException e){
                //
            }
        }

        stats = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get() { return stats; }

    public static void save() {
        try{
            stats.save(file);
        }catch(IOException e){
            System.out.println("Could not save MobHeads player statistics");
        }
    }

    public static void reload() { stats = YamlConfiguration.loadConfiguration(file); }

}