package me.carbonate.dpstaff.items;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.carbonate.dpstaff.Utils;

public class StaffItems {
	
	static ItemStack freezer = new ItemStack(Material.BARRIER, 1);
	static ItemStack ban = new ItemStack(Material.IRON_AXE, 1);
	static ItemStack warn = new ItemStack(Material.PAPER, 1);
	
	public static void giveStaffItems(Player p) {
		ItemMeta fMeta = freezer.getItemMeta();
		fMeta.setDisplayName(Utils.Chat("&bFreeze Player"));
		freezer.setItemMeta(fMeta);
		
		ItemMeta bMeta = ban.getItemMeta();
		bMeta.setDisplayName(Utils.Chat("&cBan Player"));
		ban.setItemMeta(bMeta);
		
		ItemMeta wMeta = warn.getItemMeta();
		wMeta.setDisplayName(Utils.Chat("&aWarn Player"));
		warn.setItemMeta(wMeta);
		
		p.getInventory().setItem(0, freezer);
		p.getInventory().setItem(4, ban);
		p.getInventory().setItem(8, warn);
		
	}

}
