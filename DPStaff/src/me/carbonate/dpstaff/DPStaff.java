package me.carbonate.dpstaff;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import me.carbonate.dpstaff.commands.Freeze;
import me.carbonate.dpstaff.commands.MainCommand;
import me.carbonate.dpstaff.commands.Staff;
import me.carbonate.dpstaff.events.BanGUI;
import me.carbonate.dpstaff.events.BlockBreak;
import me.carbonate.dpstaff.events.EntityDamage;
import me.carbonate.dpstaff.events.Interact;
import me.carbonate.dpstaff.events.InvClick;
import me.carbonate.dpstaff.events.MuteGUI;
import me.carbonate.dpstaff.events.PlayerChat;
import me.carbonate.dpstaff.events.PlayerMove;

public class DPStaff extends JavaPlugin {
	
	public HashMap<Player, Location> frozenPlayer = new HashMap<Player, Location>();
	public ArrayList<Player> staffMode = new ArrayList<Player>();
	public HashMap<Player, ItemStack[][]> inv = new HashMap<Player, ItemStack[][]>();
	
	public void onEnable() {
		registerCommands();
		registerEvents();
		BanGUI.initialize();
		MuteGUI.initialize();
		getLogger().info("By Carbonate");
	}
	
	public void registerCommands() {
		new MainCommand(this);
		new Freeze(this);
		new Staff(this);
	}
	
	public void registerEvents() {
		new PlayerMove(this);
		new InvClick(this);
		new EntityDamage(this);
		new BlockBreak(this);
		new Interact(this);
		new BanGUI(this);
		new MuteGUI(this);
		new PlayerChat(this);
	}

}
