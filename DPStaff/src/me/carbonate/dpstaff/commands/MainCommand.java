package me.carbonate.dpstaff.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.carbonate.dpstaff.DPStaff;
import me.carbonate.dpstaff.Utils;

public class MainCommand implements CommandExecutor {

	public DPStaff plugin;

	public MainCommand(DPStaff plugin) {
		this.plugin = plugin;
		plugin.getCommand("dpstaff").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("dpstaff")) {
			if (sender.hasPermission("dpstaff.use")) {
				Utils.sendCenteredMessage(p, Utils.Chat(" "));
				Utils.sendCenteredMessage(p, Utils.Chat("&9&lDP &r&lSTAFF"));
				Utils.sendCenteredMessage(p, Utils.Chat(" "));
				Utils.sendCenteredMessage(p, Utils.Chat("&7Commands:"));
				Utils.sendCenteredMessage(p, Utils.Chat("&7/dpstaff - View all Commands"));
				Utils.sendCenteredMessage(p, Utils.Chat("&7/staff - Staff Mode"));
				Utils.sendCenteredMessage(p, Utils.Chat("&7/staffgui - Opens GUI"));
				Utils.sendCenteredMessage(p, Utils.Chat("&7/freeze <player> - Freezes Player"));
				Utils.sendCenteredMessage(p, Utils.Chat("&7/warn <player> <reason> - Warns Player"));
				Utils.sendCenteredMessage(p, Utils.Chat("&7/warnings <player>"));
				Utils.sendCenteredMessage(p, Utils.Chat(" "));
				return true;
			}
		}

		return false;
	}

}
