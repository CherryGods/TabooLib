package me.skymc.tlm.module.sub;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.ServerCommandEvent;

import me.skymc.tlm.module.ITabooLibraryModule;

/**
 * @author sky
 * @since 2018年2月22日 下午1:32:29
 */
public class ModuleCommandChanger implements ITabooLibraryModule, Listener {

	@Override
	public String getName() {
		return "CommandChanger";
	}
	
	@EventHandler
	public void command(PlayerCommandPreprocessEvent e) {
		// 循环命令
		for (String id : getConfig().getConfigurationSection("Commands").getKeys(false)) {
			// 获取命令
			String key = getConfig().getString("Commands." + id + ".Input");
			// 判断命令
			if (e.getMessage().startsWith(key)) {
				// 判断执行方式
				if (!getConfig().contains("Commands." + id + ".ReplaceMode") || getConfig().getString("Commands." + id + ".ReplaceMode").equals("PLAYER")) {
					// 替换命令
					e.setMessage(e.getMessage().replace(key, getConfig().getString("Commands." + id + ".Replace")));
					return;
				}
			}
		}
	}
	
	@EventHandler
	public void command(ServerCommandEvent e) {
		// 循环命令
		for (String id : getConfig().getConfigurationSection("Commands").getKeys(false)) {
			// 获取命令
			String key = getConfig().getString("Commands." + id + ".Input");
			// 判断命令
			if (e.getCommand().startsWith(key)) {
				// 判断执行方式
				if (!getConfig().contains("Commands." + id + ".ReplaceMode") || getConfig().getString("Commands." + id + ".ReplaceMode").equals("CONSOLE")) {
					// 替换命令
					e.setCommand(e.getCommand().replace(key, getConfig().getString("Commands." + id + ".Replace")));
					return;
				}
			}
		}
	}
}
