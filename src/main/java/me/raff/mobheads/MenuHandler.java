package me.raff.mobheads;

import me.raff.mobheads.files.playerStats;
import me.raff.mobheads.files.storeConfig;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.net.ProxySelector;


public class MenuHandler implements Listener {

    public void headExchange(String mob_name,  Player p) {
        Integer head_count = playerStats.get().getInt(p.getName()+"."+mob_name);
        if (head_count >= 10) {
            Integer crystal_count = head_count / 10;

            playerStats.get().set(p.getName()+"."+mob_name, playerStats.get().getInt(p.getName()+"."+mob_name)-crystal_count*10);
            playerStats.get().set(p.getName()+"."+"Crystals", playerStats.get().getInt(p.getName()+"."+"Crystals")+crystal_count);

            playerStats.save();

            p.sendMessage(ChatColor.GREEN+"Converted "+ChatColor.WHITE+ChatColor.BOLD+crystal_count*10+ChatColor.RESET+ChatColor.GREEN+" "+mob_name+" Head(s) into "+ChatColor.WHITE+ChatColor.BOLD+crystal_count+ChatColor.RESET+ChatColor.GREEN+" Crystal(s).");

        } else {
            p.sendMessage(ChatColor.RED+"You don't have enough "+mob_name+" Heads to convert into crystals.");
        }
    }

    public void itemShopExecutor(String item_name, Player player) {

        String command = storeConfig.get().getString(item_name+"."+"executes");



    }

    @EventHandler
    public void onMenuClicked(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD+"Crystal Conversion")){
            try {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§bCreeper Heads")) {
                    p.closeInventory();
                    headExchange("Creeper", p);
                }  else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§bSkeleton Heads")){
                    p.closeInventory();
                    headExchange("Skeleton", p);
                }  else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§bZombie Heads")){
                    p.closeInventory();
                    headExchange("Zombie", p);
                }  else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§bPig Heads")){
                    p.closeInventory();
                    headExchange("Pig", p);
                }  else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§bCow Heads")){
                    p.closeInventory();
                    headExchange("Cow", p);
                }
            } catch (Exception exception) {
                //
            }

        } else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD+"Item Store")) {
            try{
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA+storeConfig.get().getString("item-1"+"."+"name"))) {
                    p.closeInventory();
                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), String.format(storeConfig.get().getString("item-1" + "." + "executes"), p.getName()));
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA+storeConfig.get().getString("item-2"+"."+"name"))) {
                    p.closeInventory();
                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), String.format(storeConfig.get().getString("item-2" + "." + "executes"), p.getName()));
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA+storeConfig.get().getString("item-3"+"."+"name"))) {
                    p.closeInventory();
                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), String.format(storeConfig.get().getString("item-3" + "." + "executes"), p.getName()));
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA+storeConfig.get().getString("item-4"+"."+"name"))) {
                    p.closeInventory();
                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), String.format(storeConfig.get().getString("item-4" + "." + "executes"), p.getName()));
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA+storeConfig.get().getString("item-5"+"."+"name"))) {
                    p.closeInventory();
                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), String.format(storeConfig.get().getString("item-5" + "." + "executes"), p.getName()));
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA+storeConfig.get().getString("item-6"+"."+"name"))) {
                    p.closeInventory();
                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), String.format(storeConfig.get().getString("item-6" + "." + "executes"), p.getName()));
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA+storeConfig.get().getString("item-7"+"."+"name"))) {
                    p.closeInventory();
                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), String.format(storeConfig.get().getString("item-7" + "." + "executes"), p.getName()));
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA+storeConfig.get().getString("item-8"+"."+"name"))) {
                    p.closeInventory();
                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), String.format(storeConfig.get().getString("item-8" + "." + "executes"), p.getName()));
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA+storeConfig.get().getString("item-9"+"."+"name"))) {
                    p.closeInventory();
                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), String.format(storeConfig.get().getString("item-9" + "." + "executes"), p.getName()));
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA+storeConfig.get().getString("item-10"+"."+"name"))) {
                    p.closeInventory();
                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), String.format(storeConfig.get().getString("item-10" + "." + "executes"), p.getName()));
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA+storeConfig.get().getString("item-11"+"."+"name"))) {
                    p.closeInventory();
                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), String.format(storeConfig.get().getString("item-11" + "." + "executes"), p.getName()));
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA+storeConfig.get().getString("item-12"+"."+"name"))) {
                    p.closeInventory();
                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), String.format(storeConfig.get().getString("item-12" + "." + "executes"), p.getName()));
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA+storeConfig.get().getString("item-13"+"."+"name"))) {
                    p.closeInventory();
                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), String.format(storeConfig.get().getString("item-13" + "." + "executes"), p.getName()));
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA+storeConfig.get().getString("item-14"+"."+"name"))) {
                    p.closeInventory();
                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), String.format(storeConfig.get().getString("item-14" + "." + "executes"), p.getName()));
                }
            } catch (Exception exception) {
                //
            }

        }

    }

}
