package me.moon.movement;

import java.util.Random;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;

public class Keybind implements CommandExecutor, Listener {
    private static boolean Started;

    private static Random rnd;

    public Keybind() {
        Started = false;
        rnd = new Random();
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player))
            return false;
        if (label.equalsIgnoreCase("keybind")) {
            Player player = (Player)sender;
            if (Started) {
                Started = false;
                player.sendMessage(ChatColor.RED + "Hotkey practice has ended!");
            } else {
                Started = true;
                player.sendMessage(ChatColor.GREEN + "Hotkey practice has started!");
            }
        }
        return false;
    }

    @EventHandler
    public void onItemHeld(PlayerItemHeldEvent e) {
        if (!Started)
            return;
        if (e.isCancelled())
            return;
        Player player = e.getPlayer();
        if (player == null)
            return;
        ItemStack stack = player.getInventory().getItem(e.getNewSlot());
        if (stack == null) {
            player.sendMessage(ChatColor.RED + "Try again!");
        } else if (stack.getType().equals(Material.COMMAND_BLOCK)) {
            player.sendMessage(ChatColor.GREEN + "Nice!");
        }
        newTarget(player, e.getNewSlot());
        player.sendMessage(ChatColor.GOLD + "Keybind to CommandBlock");
    }

    private void newTarget(Player player, int curIndex) {
        player.getInventory().clear();
        ItemStack item = new ItemStack(Material.COMMAND_BLOCK, 1);
        int slot = rnd.nextInt(9);
        while (slot == curIndex)
               slot = rnd.nextInt(9);
        player.getInventory().setItem(slot, item);
    }
}