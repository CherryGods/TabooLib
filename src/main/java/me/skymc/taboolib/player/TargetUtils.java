package me.skymc.taboolib.player;

import java.util.LinkedList;

import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.BlockIterator;


@Deprecated
public class TargetUtils {
	
	public static LinkedList<Block> getTarget(LivingEntity p, int max) {
		BlockIterator itor = new BlockIterator(p);
		LinkedList<Block> block = new LinkedList<>();
		while(itor.hasNext())
		{
			max++;
			block.add(itor.next());
			if (max >= 100)
			{
				break;
			}
		}
		return block;
	}
}
