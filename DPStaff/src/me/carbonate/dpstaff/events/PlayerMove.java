package me.carbonate.dpstaff.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.carbonate.dpstaff.DPStaff;

public class PlayerMove implements Listener {

	public DPStaff plugin;
	public PlayerMove(DPStaff plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		if (!plugin.frozenPlayer.containsKey(e.getPlayer())) {
			return;
		}
		
		if (e.getFrom().getBlockX() != e.getTo().getBlockX() || e.getFrom().getBlockZ() != e.getTo().getBlockZ()) {
			e.getPlayer().teleport(plugin.frozenPlayer.get(e.getPlayer()));
		}
	}
	
}
