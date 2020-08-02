package me.carbonate.dpstaff.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.carbonate.dpstaff.DPStaff;

public class EntityDamage implements Listener {

	public DPStaff plugin;

	public EntityDamage(DPStaff plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onUse(EntityDamageByEntityEvent e) {
		Player p = (Player) e.getDamager();
		if (e.getDamager() instanceof Player) {
			if (plugin.staffMode.contains(p)) {
				e.setCancelled(true);
			}
		}
	}

	
}
