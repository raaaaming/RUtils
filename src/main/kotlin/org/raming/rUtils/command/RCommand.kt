package org.raming.rUtils.command

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class RCommand(val name: String, val description: String = "")