package me.carbonate.dpstaff.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import me.carbonate.dpstaff.DPStaff;

public class BlockBreak implements Listener {
	
	public DPStaff plugin;
	public BlockBreak(DPStaff plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = (Player) e.getPlayer();
		if (p.hasPermission("dpstaff.bypass")) {
			return;
		}
		
		if (plugin.inv.containsKey(p)) {
			e.setCancelled(true);
		}
	}

}
