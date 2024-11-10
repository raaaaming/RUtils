package org.raming.rUtils.command

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.plugin.java.JavaPlugin
import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.jvm.isAccessible

object CommandRegistry {

	fun registerCommands(plugin: JavaPlugin, commandHolder: Any) {
		val methods = commandHolder::class.declaredFunctions.filter { it.annotations.any { it is RCommand } }
		for (method in methods) {
			val annotation = method.annotations.find { it is RCommand } as? RCommand ?: continue
			val cmd = annotation.name
			plugin.getCommand(annotation.name)?.setExecutor(object : CommandExecutor {
				override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
					method.isAccessible = true
					method.call(commandHolder, sender, args)
					return true
				}
			})
			TODO("Log Extension")
		}
	}

}