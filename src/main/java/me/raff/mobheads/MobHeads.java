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
        storeConfig.get().addDefault("item-1"+"."+"message", "§6Buy §f§l1 §6Diamond Sword for§f§l %d §6Crystals");

        storeConfig.get().addDefault("item-2"+"."+"name","Diamond Axe");
        storeConfig.get().addDefault("item-2"+"."+"material",Material.DIAMOND_AXE);
        storeConfig.get().addDefault("item-2"+"."+"price",2);
        storeConfig.get().addDefault("item-2"+"."+"executes","give %s diamond_axe 1");
        storeConfig.get().addDefault("item-2"+"."+"message", "§6Buy §f§l1 §6Diamond Axe for§f§l %d §6Crystals");

        storeConfig.get().addDefault("item-3"+"."+"name","Cow Spawner");
        storeConfig.get().addDefault("item-3"+"."+"material",Material.MOB_SPAWNER);
        storeConfig.get().addDefault("item-3"+"."+"price",2);
        storeConfig.get().addDefault("item-3"+"."+"executes","ss give %s cow 1");
        storeConfig.get().addDefault("item-3"+"."+"message", "§6Buy §f§l1 §6Cow Spawner for§f§l %d §6Crystals");

        storeConfig.get().addDefault("item-4"+"."+"name","Zombie Spawner");
        storeConfig.get().addDefault("item-4"+"."+"material",Material.MOB_SPAWNER);
        storeConfig.get().addDefault("item-4"+"."+"price",5);
        storeConfig.get().addDefault("item-4"+"."+"executes","ss give %s zombie 1");
        storeConfig.get().addDefault("item-4"+"."+"message", "§6Buy §f§l1 §6Zombie Spawner for§f§l %d §6Crystals");

        storeConfig.get().addDefault("item-5"+"."+"name","Skeleton Spawner");
        storeConfig.get().addDefault("item-5"+"."+"material",Material.MOB_SPAWNER);
        storeConfig.get().addDefault("item-5"+"."+"price",5);
        storeConfig.get().addDefault("item-5"+"."+"executes","ss give %s cow 1");
        storeConfig.get().addDefault("item-5"+"."+"message", "§6Buy §f§l1 §6Skeleton Spawner for§f§l %d §6Crystals");

        storeConfig.get().addDefault("item-6"+"."+"name","Pig Spawner");
        storeConfig.get().addDefault("item-6"+"."+"material",Material.MOB_SPAWNER);
        storeConfig.get().addDefault("item-6"+"."+"price",2);
        storeConfig.get().addDefault("item-6"+"."+"executes","ss give %s pig 1");
        storeConfig.get().addDefault("item-6"+"."+"message", "§6Buy §f§l1 §6Pig Spawner for§f§l %d §6Crystals");

        storeConfig.get().addDefault("item-7"+"."+"name","Sheep Spawner");
        storeConfig.get().addDefault("item-7"+"."+"material",Material.MOB_SPAWNER);
        storeConfig.get().addDefault("item-7"+"."+"price",2);
        storeConfig.get().addDefault("item-7"+"."+"executes","ss give %s sheep 1");
        storeConfig.get().addDefault("item-7"+"."+"message", "§6Buy §f§l1 §6Sheep Spawner for§f§l %d §6Crystals");

        storeConfig.get().addDefault("item-8"+"."+"name","Chicken Spawner");
        storeConfig.get().addDefault("item-8"+"."+"material",Material.MOB_SPAWNER);
        storeConfig.get().addDefault("item-8"+"."+"price",1);
        storeConfig.get().addDefault("item-8"+"."+"executes","ss give %s chicken 1");
        storeConfig.get().addDefault("item-8"+"."+"message", "§6Buy §f§l1 §6Chicken Spawner for§f§l %d §6Crystals");

        storeConfig.get().addDefault("item-9"+"."+"name","Creeper Spawner");
        storeConfig.get().addDefault("item-9"+"."+"material",Material.MOB_SPAWNER);
        storeConfig.get().addDefault("item-9"+"."+"price",5);
        storeConfig.get().addDefault("item-9"+"."+"executes","ss give %s creeper 1");
        storeConfig.get().addDefault("item-9"+"."+"message", "§6Buy §f§l1 §6Creeper Spawner for§f§l %d §6Crystals");

        storeConfig.get().addDefault("item-10"+"."+"name","Villager Spawner");
        storeConfig.get().addDefault("item-10"+"."+"material",Material.MOB_SPAWNER);
        storeConfig.get().addDefault("item-10"+"."+"price",25);
        storeConfig.get().addDefault("item-10"+"."+"executes","ss give %s villager 1");
        storeConfig.get().addDefault("item-10"+"."+"message", "§6Buy §f§l1 §6Villager Spawner for§f§l %d §6Crystals");

        storeConfig.get().addDefault("item-11"+"."+"name","Enderman Spawner");
        storeConfig.get().addDefault("item-11"+"."+"material",Material.MOB_SPAWNER);
        storeConfig.get().addDefault("item-11"+"."+"price",5);
        storeConfig.get().addDefault("item-11"+"."+"executes","ss give %s enderman 1");
        storeConfig.get().addDefault("item-11"+"."+"message", "§6Buy §f§l1 §6Enderman Spawner for§f§l %d §6Crystals");

        storeConfig.get().addDefault("item-12"+"."+"name","Witch Spawner");
        storeConfig.get().addDefault("item-12"+"."+"material",Material.MOB_SPAWNER);
        storeConfig.get().addDefault("item-12"+"."+"price",5);
        storeConfig.get().addDefault("item-12"+"."+"executes","ss give %s witch 1");
        storeConfig.get().addDefault("item-12"+"."+"message", "§6Buy §f§l1 §6Witch Spawner for§f§l %d §6Crystals");

        storeConfig.get().addDefault("item-13"+"."+"name","Spider Spawner");
        storeConfig.get().addDefault("item-13"+"."+"material",Material.MOB_SPAWNER);
        storeConfig.get().addDefault("item-13"+"."+"price",5);
        storeConfig.get().addDefault("item-13"+"."+"executes","ss give %s spider 1");
        storeConfig.get().addDefault("item-13"+"."+"message", "§6Buy §f§l1 §6Spider Spawner for§f§l %d §6Crystals");

        storeConfig.get().addDefault("item-14"+"."+"name","Blaze Spawner");
        storeConfig.get().addDefault("item-14"+"."+"material",Material.MOB_SPAWNER);
        storeConfig.get().addDefault("item-14"+"."+"price",5);
        storeConfig.get().addDefault("item-14"+"."+"executes","ss give %s blaze 1");
        storeConfig.get().addDefault("item-14"+"."+"message", "§6Buy §f§l1 §6Blaze Spawner for§f§l %d §6Crystals");

        storeConfig.save();
    }

    @Override
    public void onDisable() {
        System.out.println("DISABLING MOBHEADS PLUGIN");
    }

}
