package me.raff.mobheads;

import me.raff.mobheads.files.playerStats;
import me.raff.mobheads.files.storeConfig;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

public final class MobHeads extends JavaPlugin {

    @Override
    public void onEnable() {

        getCommand("crystalshop").setExecutor(new CrystalShop());
        getCommand("itemshop").setExecutor(new ItemStore());

        getServer().getPluginManager().registerEvents(new MenuHandler(), this);

        Bukkit.getServer().getPluginManager().registerEvents(new KillHandler(), this);

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        playerStats.setup();
        playerStats.get().options().copyDefaults(true);

        storeConfig.setup();
        storeConfig.get().options().copyDefaults(true);

        storeConfig.get().addDefault("item-1"+"."+"name","Diamond Sword");
        storeConfig.get().addDefault("item-1"+"."+"material",Material.DIAMOND_SWORD);
        storeConfig.get().addDefault("item-1"+"."+"price",2);
        storeConfig.get().addDefault("item-1"+"."+"executes","give %s diamond_sword 1");
        storeConfig.get().addDefault("item-1"+"."+"message", "§6Buy §f§l1 §6Diamond Sword for§f§l%2d §6Crystals");

        storeConfig.get().addDefault("item-2"+"."+"name","Diamond Axe");
        storeConfig.get().addDefault("item-2"+"."+"material",Material.DIAMOND_AXE);
        storeConfig.get().addDefault("item-2"+"."+"price",2);
        storeConfig.get().addDefault("item-2"+"."+"executes","give %s diamond_axe 1");
        storeConfig.get().addDefault("item-2"+"."+"message", "§6Buy §f§l1 §6Diamond Axe for§f§l%2d §6Crystals");

        storeConfig.get().addDefault("item-3"+"."+"name","Cow Spawner");
        storeConfig.get().addDefault("item-3"+"."+"material",Material.MOB_SPAWNER);
        storeConfig.get().addDefault("item-3"+"."+"price",5);
        storeConfig.get().addDefault("item-3"+"."+"executes","ss give %s cow 1");
        storeConfig.get().addDefault("item-3"+"."+"message", "§6Buy §f§l1 §6Cow Spawner for§f§l%2d §6Crystals");

        storeConfig.get().addDefault("item-4"+"."+"name","Zombie Spawner");
        storeConfig.get().addDefault("item-4"+"."+"material",Material.MOB_SPAWNER);
        storeConfig.get().addDefault("item-4"+"."+"price",5);
        storeConfig.get().addDefault("item-4"+"."+"executes","ss give %s zombie 1");
        storeConfig.get().addDefault("item-4"+"."+"message", "§6Buy §f§l1 §6Zombie Spawner for§f§l%2d §6Crystals");

        storeConfig.get().addDefault("item-5"+"."+"name","Skeleton Spawner");
        storeConfig.get().addDefault("item-5"+"."+"material",Material.MOB_SPAWNER);
        storeConfig.get().addDefault("item-5"+"."+"price",5);
        storeConfig.get().addDefault("item-5"+"."+"executes","ss give %s cow 1");
        storeConfig.get().addDefault("item-5"+"."+"message", "§6Buy §f§l1 §6Skeleton Spawner for§f§l%2d §6Crystals");

        storeConfig.save();
    }

    @Override
    public void onDisable() {
        System.out.println("DISABLING MOBHEADS PLUGIN");
    }

}
