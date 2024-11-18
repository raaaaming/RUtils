package org.raming.rUtils

import org.bukkit.plugin.java.JavaPlugin
import org.raming.rUtils.command.CommandRegistry
import org.raming.rUtils.database.DatabaseManager
import org.raming.rUtils.util.CommandHolder
import org.raming.rUtils.util.sendLog

class RUtils : JavaPlugin() {

	companion object {
		lateinit var plugin: JavaPlugin
	}

	init {
		plugin = this
	}

	override fun onEnable() {
		// Plugin startup logic
		DatabaseManager.connect()
		CommandRegistry.registerCommands(this, CommandHolder())

		sendLog("Loaded This Plugin!")
	}

	override fun onDisable() {
		// Plugin shutdown logic
		DatabaseManager.disconnect()

		sendLog("Unloaded This Plugin!")
	}
}
