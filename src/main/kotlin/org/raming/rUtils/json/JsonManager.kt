package org.raming.rUtils.json

import kotlinx.serialization.KSerializer
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.File

object JsonManager {

	fun <T> saveToJson(filePath: String, data: T, serializer: KSerializer<T>) {
		val jsonData = Json.encodeToString(serializer, data)
		File(filePath).writeText(jsonData)
		TODO("Log Extension")
	}

	fun <T> loadFromJson(filePath: String, serializer: KSerializer<T>) : T? {
		return try {
			val jsonData = File(filePath).readText()
			Json.decodeFromString(serializer, jsonData)
		} catch (e: Exception) {
			TODO("Log Extension")
			null
		}
	}

}