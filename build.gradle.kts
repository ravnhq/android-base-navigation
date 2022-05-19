buildscript {
    repositories {
        mavenLocal()
        google()
        mavenCentral()
        jcenter()
    }
    dependencies {
        classpath(libs.android.gradlePluginClasspath)
        classpath(libs.dagger.hilt.gradlePluginClasspath)
        classpath(libs.kotlin.gradlePluginClasspath)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    }
}

allprojects {
    repositories {
        mavenLocal()
        google()
        mavenCentral()
        jcenter()
        maven(
            url = uri("https://oss.sonatype.org/content/repositories/snapshots/")
        )
        maven(
            url = uri( "https://jitpack.io")
        )

    }
}

