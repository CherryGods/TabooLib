package me.skymc.taboolib.commands.sub;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;

import me.skymc.taboolib.Main;
import me.skymc.taboolib.commands.SubCommand;
import me.skymc.taboolib.inventory.ItemUtils;
import me.skymc.taboolib.itemnbtapi.NBTItem;
import me.skymc.taboolib.jsonformatter.JSONFormatter;
import me.skymc.taboolib.jsonformatter.click.SuggestCommandEvent;
import me.skymc.taboolib.jsonformatter.hover.ShowTextEvent;
import me.skymc.taboolib.message.MsgUtils;

public class InfoCommand extends SubCommand {

	@SuppressWarnings("deprecation")
	public InfoCommand(CommandSender sender, String[] args) {
		super(sender, args);
		
		if (isPlayer()) {
			Player player = (Player) sender;
			if (player.getItemInHand().getType().equals(Material.AIR)) {
				MsgUtils.send(player, "&7���ֳ���ȷ��Ʒ");
			}
			else {
				sender.sendMessage("��f");
				sender.sendMessage("��b��l----- ��3��lItemStack Info ��b��l-----");
				sender.sendMessage("��f");
				
				JSONFormatter json = new JSONFormatter();
				json.append("��7 - ��Ʒ����: ��f"); json.appendHoverClick("��f" + player.getItemInHand().getType().name(), new ShowTextEvent("��f�������"), new SuggestCommandEvent(player.getItemInHand().getType().name()));
				json.newLine();
				json.append("��7 - ��Ʒ����: ��f"); json.appendHoverClick("��f" + ItemUtils.getCustomName(player.getItemInHand()), new ShowTextEvent("��f�������"), new SuggestCommandEvent(ItemUtils.getCustomName(player.getItemInHand()).replace("��", "&")));
				json.newLine();
				json.append("��7 - ��Ʒ���: ��f" + player.getItemInHand().getTypeId() + ":" + player.getItemInHand().getDurability());
				json.send(player);
				
				NBTItem nbt = new NBTItem(((Player) sender).getItemInHand());
				sender.sendMessage("��7 - ��Ʒ NBT: ��f");
				sender.sendMessage("��f");
				sender.sendMessage(nbt.toString());
				
				sender.sendMessage("��f");
			}
		}
	}
}