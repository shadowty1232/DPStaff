package me.carbonate.dpstaff.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.carbonate.dpstaff.DPStaff;
import me.carbonate.dpstaff.Utils;

public class PlayerChat implements Listener {

	public DPStaff plugin;
	public PlayerChat(DPStaff plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = (Player) e.getPlayer();
		
		if (MuteGUI.mutedPlayer.contains(p)) {
			e.setCancelled(true);
			p.sendMessage(Utils.Chat("&cYou are muted."));
		}
	}
	
}
