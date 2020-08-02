package me.carbonate.dpstaff.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.carbonate.dpstaff.DPStaff;

public class InvClick implements Listener {

	public DPStaff plugin;

	public InvClick(DPStaff plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (!p.hasPermission("dpstaff.bypass")) {
			if (plugin.staffMode.contains(p)) {
				e.setCancelled(true);
			} else {
				return;
			}
		} else {
			return;
		}
	}

}
