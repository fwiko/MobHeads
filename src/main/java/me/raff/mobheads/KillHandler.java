package me.raff.mobheads;

import me.raff.mobheads.files.playerStats;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class KillHandler implements Listener {
    public LivingEntity mob;
    public Player player;
    public EntityDeathEvent event;
    public String mob_name;


    private void UpdateStats() {
        System.out.println(mob_name);
        player.sendMessage("§a+1 "+mob_name+" head");
        if (!playerStats.get().isSet(player.getName()+"."+mob_name)) {
            playerStats.get().set(player.getName()+"."+mob_name, 1);
            playerStats.save();
        } else {
            playerStats.get().set(player.getName()+"."+mob_name, (playerStats.get().getInt(player.getName()+"."+mob_name))+1);
            playerStats.save();
        }
        if ((playerStats.get().getInt(player.getName()+"."+mob_name)) % 10 == 0) {
            player.sendMessage("§fYou have §6§l"+(playerStats.get().getInt(player.getName()+"."+mob_name))+" "+mob_name+" §fheads!");
        } else {
            return;
        }
    }

    private void CheckEntity() {
        if ( mob instanceof Creeper ) {
            mob_name = "Creeper";
            UpdateStats();
        } else if ( mob instanceof Skeleton ) {
            mob_name = "Skeleton";
            UpdateStats();
        } else if ( mob instanceof Zombie ) {
            mob_name = "Zombie";
            UpdateStats();
        } else if ( mob instanceof Pig ) {
            mob_name = "Pig";
            UpdateStats();
        } else if ( mob instanceof Cow ) {
            mob_name = "Cow";
            UpdateStats();
        }
    }

    @EventHandler
    public void EntityKilled(EntityDeathEvent e){
        if (e.getEntity().getKiller() != null) {
            if(e.getEntity().getKiller() instanceof Player) {

                player = e.getEntity().getKiller();
                mob = e.getEntity();
                event = e;

                int num = (int) (Math.random() * ((100 - 1) + 1)) + 1;
                System.out.println(num);
                if (num > 70) {
                    CheckEntity();
                }
                else {
                    return;
                }


            }
        }
    }
}