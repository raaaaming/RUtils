package org.raming.rUtils.database

import java.sql.Connection
import java.sql.DriverManager

object DatabaseManager {
	private var connection: Connection? = null

	fun connect() {
		connection = DriverManager.getConnection("jdbc:sqlite:RDatabase.db")
		TODO("Log Extension")
	}

	fun createTable(tableName: String, tableSchema: String) {
		connection?.createStatement()?.use { statement ->
			statement.execute("CREATE TABLE IF NOT EXISTS $tableName ($tableSchema)")
			TODO("Log Extension")
		}
	}

	fun disconnect() {
		connection?.close()
		TODO("Log Extension")
	}
}