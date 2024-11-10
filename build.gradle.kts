plugins {
	`maven-publish`
	kotlin("jvm") version "2.0.0"
	id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "org.raming"
version = "1.0.0"

publishing {
	publications {
		create<MavenPublication>("") {
			groupId = "com.raming"
			artifactId = "RUtils"
			version = "1.0.0"
			from(components["java"])
		}
	}
}

/*
signing {
	useInMemoryPgpKeys(System.getenv("SIGNING_KEY"), System.getenv("SIGNING_PASSWORD"))
	sign(publishing.publications["gpr"])
}
*/

repositories {
	mavenCentral()
	maven("https://repo.papermc.io/repository/maven-public/") {
		name = "papermc-repo"
	}
	maven("https://oss.sonatype.org/content/groups/public/") {
		name = "sonatype"
	}
}

dependencies {
	compileOnly("io.papermc.paper:paper-api:1.20.1-R0.1-SNAPSHOT")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
	implementation("org.jetbrains.kotlin:kotlin-reflect:2.0.0")
}

val targetJavaVersion = 17
kotlin {
	jvmToolchain(targetJavaVersion)
}

tasks.build {
	dependsOn("shadowJar")
}

tasks.processResources {
	val props = mapOf("version" to version)
	inputs.properties(props)
	filteringCharset = "UTF-8"
	filesMatching("paper-plugin.yml") {
		expand(props)
	}
}
