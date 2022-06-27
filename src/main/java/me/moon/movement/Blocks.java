package me.moon.movement;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Blocks implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            Inventory inv = Bukkit.createInventory(player, 45, ChatColor.RED.toString() + ChatColor.BOLD + "Blocks");

            ItemStack block = new ItemStack(Material.COBBLESTONE, 64);
            for (int i : new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44}) {
                inv.setItem(i, block);
            }
            player.openInventory(inv);
        }
        return false;
    }
}