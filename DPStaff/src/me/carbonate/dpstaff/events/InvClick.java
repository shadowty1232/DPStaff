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
		String title = e.getInventory().getTitle();
		if (title.equals(BanGUI.inventory_name)) {
			e.setCancelled(true);
			if (e.getCurrentItem() == null) {
				return;
			}
			if (title.equals(BanGUI.inventory_name)) {
				BanGUI.clicked((Player) e.getWhoClicked(), e.getSlot(), e.getCurrentItem(), e.getInventory(),
						e.getClickedInventory());
			}

		}
		if (title.equals(MuteGUI.inventory_name)) {
			e.setCancelled(true);
			if (e.getCurrentItem() == null) {
				return;
			}
			if (title.equals(MuteGUI.inventory_name)) {
				MuteGUI.clicked((Player) e.getWhoClicked(), e.getSlot(), e.getCurrentItem(), e.getInventory(),
						e.getClickedInventory());
			}

		}
	}

}
