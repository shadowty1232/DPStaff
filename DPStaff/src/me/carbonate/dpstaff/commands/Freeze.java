package me.carbonate.dpstaff.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.carbonate.dpstaff.DPStaff;
import me.carbonate.dpstaff.Utils;

public class Freeze implements CommandExecutor {

	public DPStaff plugin;

	public Freeze(DPStaff plugin) {
		this.plugin = plugin;
		plugin.getCommand("freeze").setExecutor(this);
	}
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Utils.Chat("&cOnly players may execute this command."));
			return false;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("freeze")) {
			if (p.hasPermission("dpstaff.freeze")) {

				int s = args.length;
				switch (s) {
				case 0:
					p.sendMessage(Utils.Chat("&cUsage: /freeze <player>"));
					break;
				case 1:
					String targetName = args[0];
					if (Bukkit.getOfflinePlayer(targetName).getPlayer() != null) {
						Player target = Bukkit.getPlayer(targetName);
						if (DPStaff.FreezePlayer(target) == true) {
							p.sendMessage(Utils.Chat("&bYou have frozen &9" + targetName));
						} else {
							p.sendMessage(Utils.Chat("&bYou have unfrozen &9" + targetName));
						}
					}
					break;
				}
			}
		}

		return false;
	}

}
