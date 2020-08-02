package me.carbonate.dpstaff.events;

import org.bukkit.Bukkit;

import java.util.Date;

import org.bukkit.BanList;
import org.bukkit.BanList.Type;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.carbonate.dpstaff.DPStaff;
import me.carbonate.dpstaff.Utils;

public class BanGUI implements Listener {
	
	public static Inventory inv;
	public static String inventory_name;
	public static int inv_rows = 6 * 9;
	
	
	public static DPStaff plugin;
	public BanGUI(DPStaff plugin) {
		BanGUI.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	public static void initialize() {
		
		inventory_name = Utils.Chat("DPStaff > Ban");

		inv = Bukkit.createInventory(null, inv_rows);
	}
	
	public static Inventory BGUI(Player p) {
		Inventory toReturn = Bukkit.createInventory(null, inv_rows, inventory_name);
		
		// Filler
		Utils.createItemByte(inv, 160, 7, 1, 1, "&7");
		Utils.createItemByte(inv, 160, 7, 1, 2, "&7");
		Utils.createItemByte(inv, 160, 7, 1, 3, "&7");
		Utils.createItemByte(inv, 160, 7, 1, 4, "&7");
		Utils.createItemByte(inv, 160, 7, 1, 5, "&7");
		Utils.createItemByte(inv, 160, 7, 1, 6, "&7");
		Utils.createItemByte(inv, 160, 7, 1, 7, "&7");
		Utils.createItemByte(inv, 160, 7, 1, 8, "&7");
		Utils.createItemByte(inv, 160, 7, 1, 9, "&7");
		Utils.createItemByte(inv, 160, 7, 1, 10, "&7");
		Utils.createItemByte(inv, 160, 7, 1, 18, "&7");
		Utils.createItemByte(inv, 160, 7, 1, 19, "&7");
		Utils.createItemByte(inv, 160, 7, 1, 27, "&7");
		Utils.createItemByte(inv, 160, 7, 1, 28, "&7");
		Utils.createItemByte(inv, 160, 7, 1, 36, "&7");
		Utils.createItemByte(inv, 160, 7, 1, 37, "&7");
		Utils.createItemByte(inv, 160, 7, 1, 45, "&7");
		Utils.createItemByte(inv, 160, 7, 1, 46, "&7");
		Utils.createItemByte(inv, 160, 7, 1, 47, "&7");
		Utils.createItemByte(inv, 160, 7, 1, 48, "&7");
		Utils.createItemByte(inv, 160, 7, 1, 49, "&7");
		Utils.createItem(inv, 166, 1, 50, "&cClose");
		Utils.createItemByte(inv, 160, 7, 1, 51, "&7");
		Utils.createItemByte(inv, 160, 7, 1, 52, "&7");
		Utils.createItemByte(inv, 160, 7, 1, 53, "&7");
		Utils.createItemByte(inv, 160, 7, 1, 54, "&7");
		
		// Actual Buttons
		Utils.createItem(inv, 331, 1, 21, "&c&l1 Day Ban");
		Utils.createItem(inv, 331, 1, 23, "&c&l7 Day Ban");
		Utils.createItem(inv, 331, 1, 25, "&c&lLifetime Ban");
		
		toReturn.setContents(inv.getContents());
		return toReturn;	
	}
	
	static BanList BL = Bukkit.getBanList(Type.NAME);
	
	public static void clicked(Player p, int slot, ItemStack clicked, Inventory inv, Inventory cinv) {		
		if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.Chat("&c&l1 Day Ban"))) {
			Player target = Interact.punishedPlayer.get(p);
			String targetName = target.getName();
			Date date = new Date(System.currentTimeMillis()+24*60*60*1000);
			BL.addBan(targetName, null, date, p.getName());
			target.kickPlayer(Utils.Chat("&cYou were banned."));
			p.closeInventory();
			Interact.punishedPlayer.clear();
		}
		if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.Chat("&c&l7 Day Ban"))) {
			Player target = Interact.punishedPlayer.get(p);
			String targetName = target.getName();
			Date date = new Date(System.currentTimeMillis()+(24*7)*60*60*1000);
			BL.addBan(targetName, null, date, p.getName());
			target.kickPlayer(Utils.Chat("&cYou were banned."));
			p.closeInventory();
			Interact.punishedPlayer.clear();
		}
		if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.Chat("&c&lLifetime Ban"))) {
			Player target = Interact.punishedPlayer.get(p);
			String targetName = target.getName();
			BL.addBan(targetName, null, null, p.getName());
			target.kickPlayer(Utils.Chat("&cYou were banned."));
			p.closeInventory();
			Interact.punishedPlayer.clear();
		}
	}

}