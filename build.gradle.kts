buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    dependencies {
        val kotlinVersion = "1.4.0"
        classpath(kotlin("gradle-plugin", version = kotlinVersion))
        classpath("com.android.tools.build:gradle:4.1.0-rc03")
        classpath("com.squareup.sqldelight:gradle-plugin:1.4.3")
    }
}
group = "com.kevicsalazar.pokedex"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

allprojects {
    repositories {
        maven("https://dl.bintray.com/kodein-framework/kodein-dev/")
    }
}
