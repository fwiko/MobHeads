package me.raff.mobheads;

import dev.dbassett.skullcreator.SkullCreator;
import me.raff.mobheads.files.playerStats;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.HashMap;

public class CrystalShop implements CommandExecutor {
    public String _player;
    public Player p;
    public Integer creeper_heads;
    public Integer skeleton_heads;
    public Integer zombie_heads;
    public Integer pig_heads;
    public Integer cow_heads;

    public static HashMap<String, Integer> creeper_quotient = new HashMap<>();
    public static HashMap<String, Integer> skeleton_quotient = new HashMap<>();
    public static HashMap<String, Integer> zombie_quotient = new HashMap<>();
    public static HashMap<String, Integer> pig_quotient = new HashMap<>();
    public static HashMap<String, Integer> cow_quotient = new HashMap<>();

    public ItemStack head(String texture, String mob_name, Integer quotient){

        ItemStack skull = SkullCreator.itemFromBase64(texture);

        SkullMeta skull_meta = (SkullMeta) skull.getItemMeta();

        skull_meta.setDisplayName(ChatColor.AQUA + mob_name +" Heads");

        ArrayList<String> skull_lore = new ArrayList<>();

        if (quotient>0) {
            skull_lore.add(ChatColor.GOLD + "Convert "+ChatColor.WHITE+(quotient*10)+ChatColor.GOLD+" "+mob_name+" heads into "+ChatColor.WHITE+quotient+ChatColor.GOLD+" Crystals.");
        } else {
            skull_lore.add(ChatColor.GOLD + "You do not have enough "+mob_name+" heads to convert into crystals.");
        }
        skull_meta.setLore(skull_lore);
        skull.setItemMeta(skull_meta);

        return skull;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            _player = sender.getName();
            p = ((Player) sender).getPlayer();
            if (playerStats.get().isSet(_player+"."+"Crystals")) {
                Integer crystals = playerStats.get().getInt(_player+"."+"Crystals");
            } else {
                playerStats.get().set(_player+"."+"Crystals", 0);
            }
            if (playerStats.get().isSet(_player+"."+"Creeper")) {
                creeper_heads = playerStats.get().getInt(_player+"."+"Creeper");
            } else {
                creeper_heads = 0;
                playerStats.get().set(_player+"."+"Creeper", creeper_heads);
            }
            if (playerStats.get().isSet(_player+"."+"Skeleton")) {
                skeleton_heads = playerStats.get().getInt(_player+"."+"Skeleton");
            } else {
                skeleton_heads = 0;
                playerStats.get().set(_player+"."+"Skeleton", skeleton_heads);
            }
            if (playerStats.get().isSet(_player+"."+"Zombie")) {
                zombie_heads = playerStats.get().getInt(_player+"."+"Zombie");
            } else {
                zombie_heads = 0;
                playerStats.get().set(_player+"."+"Zombie", zombie_heads);
            }
            if (playerStats.get().isSet(_player+"."+"Pig")) {
                pig_heads = playerStats.get().getInt(_player+"."+"Pig");
            } else {
                pig_heads = 0;
                playerStats.get().set(_player+"."+"Pig", pig_heads);
            }
            if (playerStats.get().isSet(_player+"."+"Cow")) {
                cow_heads = playerStats.get().getInt(_player+"."+"Cow");
            } else {
                cow_heads = 0;
                playerStats.get().set(_player+"."+"Cow", cow_heads);
            }

            // Inventory

            ItemStack l_glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)3);

            Inventory crystal_store = getCrystalShop(p);

            //crystal_store.setItem(0, l_glass);
            creeper_quotient.put(_player, playerStats.get().getInt(_player+"."+"Creeper") / 10);
            crystal_store.setItem(11, head("eyJ0aW1lc3RhbXAiOjE1NTg1ODQ5OTkyMjMsInByb2ZpbGVJZCI6IjA1N2IxYzQ3MTMyMTQ4NjNhNmZlODg4N2Y5ZWMyNjVmIiwicHJvZmlsZU5hbWUiOiJNSEZfQ3JlZXBlciIsInNpZ25hdHVyZVJlcXVpcmVkIjp0cnVlLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmE1ZTk1NzM1YTNmMzc3MmIxYjQ4NWUxNTAyODA3YWUzOTZhNzJjNjFiZmQzNmFiNDFmYTcxYmVjMmY2NGFhMiJ9fX0=", "Creeper", creeper_quotient.get(_player)));
            skeleton_quotient.put(_player, playerStats.get().getInt(_player+"."+"Skeleton") / 10);
            crystal_store.setItem(12, head("eyJ0aW1lc3RhbXAiOjE1NTcwMDk5OTk4ODIsInByb2ZpbGVJZCI6ImEzZjQyN2E4MThjNTQ5YzVhNGZiNjRjNmUwZTFlMGE4IiwicHJvZmlsZU5hbWUiOiJNSEZfU2tlbGV0b24iLCJzaWduYXR1cmVSZXF1aXJlZCI6dHJ1ZSwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzIyNzk1YzNjNmYzNmQ2N2RlY2Y5YTMxOTVlMTI4MDQwYmVjNTIyNmIwNTVmMmIxNmQ0NmZhMTlhOTE4MGUwMjMifX19", "Skeleton", skeleton_quotient.get(_player)));
            zombie_quotient.put(_player, playerStats.get().getInt(_player+"."+"Zombie") / 10);
            crystal_store.setItem(13, head("eyJ0aW1lc3RhbXAiOjE1Mjc0MzQ5MTY5ODIsInByb2ZpbGVJZCI6ImRhY2EyYzNkNzE5YjQxZjViNjI0ZTQwMzllNmMwNGJkIiwicHJvZmlsZU5hbWUiOiJNSEZfWm9tYmllIiwic2lnbmF0dXJlUmVxdWlyZWQiOnRydWUsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9kOTdlNDI1OTM3OWEwNmYyNDg0M2MxYmI0MmYyZGYzNWMxM2Y4MDFhZDA3OWY3MTViZGVkNDg4ZGI4ZjU3YzMifX19", "Zombie", zombie_quotient.get(_player)));
            pig_quotient.put(_player, playerStats.get().getInt(_player+"."+"Pig") / 10);
            crystal_store.setItem(14, head("eyJ0aW1lc3RhbXAiOjE1NTcwMDk5NTIyNjYsInByb2ZpbGVJZCI6IjhiNTcwNzhiZjFiZDQ1ZGY4M2M0ZDg4ZDE2NzY4ZmJlIiwicHJvZmlsZU5hbWUiOiJNSEZfUGlnIiwic2lnbmF0dXJlUmVxdWlyZWQiOnRydWUsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9hNTYyYTM3Yjg3MWY5NjRiZmMzZTEzMTFlYTY3MmFhYTAzOTg0YTVkYzQ3MjE1NGEzNGRjMjVhZjE1N2UzODJiIn19fQ==", "Pig", pig_quotient.get(_player)));
            cow_quotient.put(_player, playerStats.get().getInt(_player+"."+"Cow") / 10);
            crystal_store.setItem(15, head("eyJ0aW1lc3RhbXAiOjE1NTcwMDk5MzQ3NTcsInByb2ZpbGVJZCI6ImYxNTliMjc0YzIyZTQzNDBiN2MxNTJhYmRlMTQ3NzEzIiwicHJvZmlsZU5hbWUiOiJNSEZfQ293Iiwic2lnbmF0dXJlUmVxdWlyZWQiOnRydWUsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9kMGU0ZTZmYmY1ZjNkY2Y5NDQyMmExZjMxOTQ0OGYxNTIzNjlkMTc5ZGJmYmNkZjAwZTViZmU4NDk1ZmE5NzcifX19", "Cow", cow_quotient.get(_player)));

            p.openInventory(crystal_store);

        }
        return false;
    }
    private Inventory getCrystalShop(Player p) {
        Inventory crystal_store = Bukkit.getServer().createInventory(null, 45, ChatColor.GOLD+"Crystal Conversion");
        return crystal_store;
    }

}
