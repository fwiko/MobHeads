package me.raff.mobheads.files;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class storeConfig {

    private static File file;
    private static FileConfiguration store;

    public static void setup(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("MobHeads").getDataFolder(), "storeconfig.yml");

        if(!file.exists()){
            try{
                file.createNewFile();
            }catch(IOException e){
                //
            }
        }

        store = YamlConfiguration.loadConfiguration(file);




    }

    public static FileConfiguration get() { return store; }

    public static void save() {
        try{
            store.save(file);
        }catch(IOException e){
            System.out.println("Could not save MobHeads Store config");
        }
    }

    public static void reload() { store = YamlConfiguration.loadConfiguration(file); }

}
