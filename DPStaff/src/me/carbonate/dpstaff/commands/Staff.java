package me.carbonate.dpstaff.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.carbonate.dpstaff.DPStaff;
import me.carbonate.dpstaff.Utils;
import me.carbonate.dpstaff.items.StaffItems;

public class Staff implements CommandExecutor {

	public DPStaff plugin;

	public Staff(DPStaff plugin) {
		this.plugin = plugin;
		plugin.getCommand("staff").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Utils.Chat("&cOnly players may execute this command."));
			return false;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("staff")) {
			if (p.hasPermission("dpstaff.staff.use")) {
				if (!plugin.staffMode.contains(p)) {
					if (p.getGameMode() == GameMode.SURVIVAL || p.getGameMode() == GameMode.ADVENTURE
							|| p.getGameMode() == GameMode.SPECTATOR) {
						p.setGameMode(GameMode.CREATIVE);
						ItemStack[][] store = new ItemStack[2][1];
						store[0] = p.getInventory().getContents();
						store[1] = p.getInventory().getArmorContents();
						plugin.inv.put(p, store);
						plugin.staffMode.add(p);
						p.getInventory().clear();
						p.getInventory().setArmorContents(null);
						StaffItems.giveStaffItems(p);
						p.updateInventory();
					} else {
						p.sendMessage(Utils.Chat("&cYou got to be in survival to execute this command."));
					}
				} else {
					p.setGameMode(GameMode.SURVIVAL);
					plugin.staffMode.remove(p);
					p.getInventory().clear();
					p.getInventory().setContents(plugin.inv.get(p)[0]);
					p.getInventory().setArmorContents(plugin.inv.get(p)[1]);
					p.updateInventory();
					plugin.inv.clear();
				}
			}
		}

		return false;
	}

}
