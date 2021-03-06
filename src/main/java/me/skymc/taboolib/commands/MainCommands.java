package me.skymc.taboolib.commands;

import me.skymc.taboolib.commands.sub.*;
import me.skymc.taboolib.commands.sub.cycle.CycleCommand;
import me.skymc.taboolib.commands.sub.itemlist.ItemListCommand;
import me.skymc.taboolib.commands.sub.shell.ShellCommand;
import me.skymc.taboolib.commands.sub.sounds.SoundsCommand;
import me.skymc.taboolib.inventory.ItemUtils;
import me.skymc.taboolib.message.MsgUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MainCommands implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
			new HelpCommand(sender, args);
		}
		else if (args[0].equalsIgnoreCase("itemreload") || args[0].equalsIgnoreCase("ireload")) {
			ItemUtils.reloadItemCache();
			ItemUtils.reloadItemName();
			MsgUtils.send(sender, "重载成功");
		}
		else if (args[0].equalsIgnoreCase("save")) {
			new SaveCommand(sender, args);
		}
		else if (args[0].equalsIgnoreCase("enchants")) {
			new EnchantCommand(sender, args);
		}
		else if (args[0].equalsIgnoreCase("potions")) {
			new PotionCommand(sender, args);
		}
		else if (args[0].equalsIgnoreCase("flags")) {
			new FlagCommand(sender, args);
		}
		else if (args[0].equalsIgnoreCase("attributes")) {
			new AttributesCommand(sender, args);
		}
		else if (args[0].equalsIgnoreCase("slots")) {
			new SlotCommand(sender, args);
		}
		else if (args[0].equalsIgnoreCase("importdata")) {
			new ImportCommand(sender, args);
		}
		else if (args[0].equalsIgnoreCase("iteminfo")) {
			new InfoCommand(sender, args);
		}
		else if (args[0].equalsIgnoreCase("itemlist")) {
			new ItemListCommand(sender, args);
		}
		else if (args[0].equalsIgnoreCase("item") || args[0].equalsIgnoreCase("i")) {
			new ItemCommand(sender, args);
		}
		else if (args[0].equalsIgnoreCase("setvariable")) {
			new VariableSetCommand(sender, args);
		}
		else if (args[0].equalsIgnoreCase("getvariable")) {
			new VariableGetCommand(sender, args);
		}
		else if (args[0].equalsIgnoreCase("shell") || args[0].equalsIgnoreCase("s")) {
			new ShellCommand(sender, args);
		}
		else if (args[0].equalsIgnoreCase("cycle") || args[0].equalsIgnoreCase("c")) {
			new CycleCommand(sender, args);
		}
		else if (args[0].equalsIgnoreCase("sounds")) {
			new SoundsCommand(sender, args);
		}
		else if (args[0].equalsIgnoreCase("tagprefix")) {
			new TagPrefixCommand(sender, args);
		}
		else if (args[0].equalsIgnoreCase("tagsuffix")) {
			new TagSuffixCommand(sender, args);
		}
		else if (args[0].equalsIgnoreCase("tagdelete")) {
			new TagDeleteCommand(sender, args);
		}
		else {
			MsgUtils.send(sender, "&4指令错误");
		}
		return true;
	}
}
