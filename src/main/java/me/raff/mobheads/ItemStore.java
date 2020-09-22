package me.raff.mobheads;

import me.raff.mobheads.files.storeConfig;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ItemStore implements CommandExecutor {

    public ItemStack item(String item_name) {
        String name = storeConfig.get().getString(item_name+"."+"name");
        Material material = (Material) storeConfig.get().get(item_name+"."+"material");
        String message = storeConfig.get().getString(item_name+"."+"message");
        Integer price = storeConfig.get().getInt(item_name+"."+"price");

        ItemStack item = new ItemStack(material);
        ItemMeta item_meta = item.getItemMeta();
        item_meta.setDisplayName(ChatColor.AQUA+name);
        ArrayList<String> item_lore = new ArrayList<>();
        item_lore.add(String.format(message, price));
        item_meta.setLore(item_lore);
        item.setItemMeta(item_meta);

        return item;
    };

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        Inventory item_store = getItemShop(p);
        p.openInventory(item_store);

        return false;
    }
    private Inventory getItemShop(Player p) {
        Inventory item_store = Bukkit.getServer().createInventory(null, 36, ChatColor.GOLD+"Item Store");

        item_store.setItem(11, item("item-1"));
        item_store.setItem(12, item("item-2"));
        item_store.setItem(13, item("item-3"));
        item_store.setItem(14, item("item-4"));
        item_store.setItem(15, item("item-5"));

        return item_store;
    }
}
