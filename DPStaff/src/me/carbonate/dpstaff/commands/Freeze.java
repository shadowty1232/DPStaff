package me.carbonate.dpstaff.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.carbonate.dpstaff.DPStaff;
import me.carbonate.dpstaff.Utils;

public class Freeze implements CommandExecutor {

	public DPStaff plugin;

	public Freeze(DPStaff plugin) {
		this.plugin = plugin;
		plugin.getCommand("freeze").setExecutor(this);
	}
	int i = 0;
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("freeze")) {
			int s = args.length;
			switch (s) {
			case 0:
				p.sendMessage(Utils.Chat("&cUsage: /freeze <player>"));

			case 1:
				i++;
				new BukkitRunnable() {
					Player target = Bukkit.getPlayer(args[0]);
					Location targetLoc = target.getLocation();

					@Override
					public void run() {
						target.teleport(targetLoc);

						if (i == 2) {
							i = 0;
							cancel();
						}

					}

				}.runTaskTimer(plugin, 0, 1);

			}
		}

		return false;
	}

}
