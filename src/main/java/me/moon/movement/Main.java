package me.moon.movement;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.plugin.Plugin;

public class Main extends JavaPlugin implements CommandExecutor, Listener {
    private static Main instance;

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = (Player) e.getPlayer();
        Inventory inv = Bukkit.createInventory(player, 45);
        e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, Integer.MAX_VALUE, 255, true, false));
        e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, Integer.MAX_VALUE, 255, true, false));
        }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        Entity entity = (Entity) e.getEntity();
        e.getCause().equals(EntityDamageEvent.DamageCause.FALL);
        e.setDamage(20);
    }

    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(this, (Plugin)this);
        getCommand("blocks").setExecutor(new Blocks());
        getCommand("keybind").setExecutor(new Keybind());
        getServer().getPluginManager().registerEvents(new Keybind(), (Plugin)this);
    }
}