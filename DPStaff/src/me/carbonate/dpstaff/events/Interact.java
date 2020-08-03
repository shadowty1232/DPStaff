package me.carbonate.dpstaff.events;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

import me.carbonate.dpstaff.DPStaff;
import me.carbonate.dpstaff.Utils;

public class Interact implements Listener {

	public DPStaff plugin;

	public Interact(DPStaff plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	public static HashMap<Player, Player> punishedPlayer = new HashMap<Player, Player>();

	@EventHandler
	public void onUse(PlayerInteractAtEntityEvent e) {
		if (!(e.getRightClicked() instanceof Player)) {
			return;
		}
		Player p = (Player) e.getPlayer();
		Player target = (Player) e.getRightClicked();
		punishedPlayer.put(p, target);
		if (p.getItemInHand().getItemMeta().getDisplayName().contains("Ban")) {
			p.openInventory(BanGUI.BGUI(p));
		}
		if (p.getItemInHand().getItemMeta().getDisplayName().contains("Mute")) {
			p.openInventory(MuteGUI.MGUI(p));
		}
		if (p.getItemInHand().getItemMeta().getDisplayName().contains("Freeze")) {
			DPStaff.FreezePlayer(target);
			if (DPStaff.frozenPlayer.containsKey(target)) {
				p.sendMessage(Utils.Chat("&bYou have frozen &9" + target.getName()));
			} else {
				p.sendMessage(Utils.Chat("&bYou have thawed &9" + target.getName()));
			}
		}

	}

}
