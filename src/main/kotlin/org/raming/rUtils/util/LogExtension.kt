package org.raming.rUtils.util

enum class Log {
	NOTICE,
	WARN,
	WRONG,
	SUCCESS,
	JOIN,
	QUIT,
}

fun String.toColor() = this.replace("&", "§")

fun sendLog(text: String, log: Log = Log.NOTICE) = when(log) {
	Log.NOTICE -> "&l&7[!] $text".toColor()
	Log.WARN -> "&l&c[!] $text".toColor()
	Log.WRONG -> "&l&e[!] $text".toColor()
	Log.SUCCESS -> "&l&a[!] $text".toColor()
	Log.JOIN -> "&l[&a+&f&l] $text".toColor()
	Log.QUIT -> "&l[&c-&f&l] $text".toColor()
}