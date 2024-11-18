package org.raming.rUtils.util

import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.raming.rUtils.RUtils
import org.raming.rUtils.command.RCommand

class CommandHolder {

	@RCommand(name = "Info", description = "Send a player info")
	fun playerInfo(sender: CommandSender, args: Array<out String>?) {
		if(!sender.isOp) return
		if(args.isNullOrEmpty()) return
		if(args.size > 1) return

		val target: Player? = when(args.size) {
			1 -> RUtils.plugin.server.getPlayer(args[0])
			else -> sender as Player
		}

		if(target is Player) {
			sender.sendMessage("Name: ${target.name}")
			TODO("use inventory gui and more info")
		} else {
			sender.sendMessage("해당 플레이어가 존재하지 않습니다.")
			TODO("add color, prefix")
		}
	}

}